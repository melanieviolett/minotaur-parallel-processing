import java.util.concurrent.ThreadLocalRandom;

class Minotaur {
   
    private static int manager = 0;
    private static int managerCount = 0;
    private static Boolean[] restOfGuests = { false, false, false, false, false };
    private static Boolean no_cake = false;
    private static Boolean solved = false;
    private static Thread[] THREADS = new Thread[5];

    private static synchronized void labyrinth(int i) {

        if (i == manager && no_cake == false) {
            managerCount += 1;
            no_cake = true;
        } 
        
        else if (i != manager && restOfGuests[i] == false && no_cake == true) {
            no_cake = false;
            restOfGuests[i] = true;
        }

        if (managerCount >= 5) {
            solved = true;
            return;
        }

    }

    public static void main(String[] args) throws InterruptedException {

        manager = ThreadLocalRandom.current().nextInt(0, 5);
        managerCount = 1;
        no_cake = true;

        while (solved == false) {
            for (int i = 0; i < 5; i++) {
                if (solved) {
                    break;
                }
                int r = ThreadLocalRandom.current().nextInt(0, 5);
                Thread t = new Thread(() -> labyrinth(r));
                t.start();
                THREADS[i] = t;
            }

            for (Thread i : THREADS) {
                i.join();
            }
        }
            
       System.out.println("All guests have entered the labyrinth at least once!");

    }
}
