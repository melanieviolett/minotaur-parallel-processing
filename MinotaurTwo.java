import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MinotaurTwo {
    private static final Lock lock = new ReentrantLock();
    private static final Queue<Integer> line = new LinkedList<>();
    private static final int num_showroom_guests = 5;

    private static void showroom(int id) {
        int num_visits = 4;

        while (num_visits > 0) {
            try {
                lock.lock();
                // guest with id lines up
                System.out.println("Guest " + id + " lines up.");
                line.add(id);
            } finally {
                lock.unlock();
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                lock.lock();
                int line_leader = line.poll();
                if (line_leader == id) {
                    // guest with id enters and exists the showroom, this simulates time spent in the showroom
                    System.out.println("Guest " + id + " is in the showroom.");
                    Thread.sleep(500);
                    System.out.println("Guest " + id + " is leaving the showroom.");
                    num_visits--;
                } else {
                    // continue waiting in queue if we reach here
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < num_showroom_guests; i++) {
            final int id = i;
            Thread guest = new Thread(() -> showroom(id));
            guest.start();
        }
    }
}
