# Assignment 2 Parallel and Distributed Processing

## To compile and run my solution to problem 1, run the following commands in the terminal:

### javac Minotaur.java

### java Minotaur.java

## Problem 1 Explanation:

#### For this problem, my approach was that first guest who was chosen to go in the labyrinth was in charge of eating the cupcake when there was one on the plate. This first guest also has the task of keeping track of how many guests have gone through by counting the number of cupcakes they've eaten, and once that number equals the number of guests who came to the party, then that person can then say that the game is over. Also, before the party they will come up with this strategy and ensure that the number of guests is counted properly. Each other guest will replace the cupcake only first time they find the plate to be empty, otherwise they are to leave the cupcake how they found it.

#### To explain the correctness of the code itself a little further, the manager indicates which thread will be the manager and be keeping a count of how many cupcakes theyve eaten. The restOfGuests array keeps track of if the guest has replaced the cupcake yet or not. The no_cake variable just keeps track of the state of the plate (if it has no cupcake on it, its true, false otherwise). I made sure to use the synchronized keyword within the labyrinth so that only one thread can access the shared resources/enter the labyrinth at a time.

## To compile and run my solution to problem 2, run the following commands in the terminal:

### javac MinotaurTwo.java

### java MinotaurTwo.java

## Problem 2 Explanation:

#### The strategy I chose was the third one, using the queue. It ensures that only one guest is allowed into the showroom at a time by the entering guest checking if they are at the front of the queue before entering. If they are at the front, they proceed; otherwise, they continue waiting. Each guest, once inside the showroom, completes their visit before the next guest can enter. This is possible because of the lock I used to control access to the critical section of the code where guests enter and exit the showroom. Only one guest at a time can acquire the lock for either action. Using the lock guarantees mutual exclusion, which prevents multiple threads from concurrently executing the critical section.

#### For the code itself, I chose for there to be a concrete number of guests, and also gave the guests the ability to queue multiple times (up to 3). Additionally, I did use Thread.sleep() simply to simulate a guest spending some time in the showroom.

#### The guests should choose the third strategy. Some disadvantages of the first strategy are that a thread might try to break mutual exclusion, but there is nothing necessarily stopping it from doing so. Doing so can lead to many issues such as possible data corruption, deadlocks, or race conditions. Disadvantages of the second strategy include a guest possibly forgetting to change the state of the sign, if that were to happen then deadlocks or race conditions could occur. Finally, some advantages of the third strategy are that the queue is effective at controlling access to the showroom in this multithreading program. Once a guest exits, they then let the next guest know the room is open and this lowers the risk of race conditions.
