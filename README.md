# Assignment 2 Parallel and Distributed Processing

## To compile and run my solution to problem 1, run the following commands in the terminal:

### javac Minotaur.java

### java Minotaur.java

## Problem 1 Explanation: 

#### For this problem, my approach was that first guest who was chosen to go in the labyrinth was in charge of eating the cupcake when there was one on the plate. This first guest also has the task of keeping track of how many guests have gone through by counting the number of cupcakes they've eaten, and once that number equals the number of guests who came to the party, then that person can then say that the game is over. Also, before the party they will come up with this strategy and ensure that the number of guests is counted properly. Each other guest will replace the cupcake only first time they find the plate to be empty, otherwise they are to leave the cupcake how they found it.

#### To explain the correctness of the code itself a little further, the manager indicates which thread will be the manager and be keeping a count of how many cupcakes theyve eaten. The restOfGuests array keeps track of if the guest has replaced the cupcake yet or not. The no_cake variable just keeps track of the state of the plate (if it has no cupcake on it, its true, false otherwise). I made sure to use the synchronized keyword within the labyrinth so that only one thread can access the shared resources/enter the labyrinth at a time. I also used a fixed number for N, with N being 5. When the program is run, the managerCount is 5 when the program terminates, indicating that all the guests have gone through the labyrinth and the manager has kept count of that. Then the restOfGuests array will all be true by the end of the program, except the index that the manager is at in the array. But that is accounted for in that the manage is guaranteed to visit first and sets the count of guests to one after they visit.

## To compile and run my solution to problem 2, run the following commands in the terminal:

### javac MinotaurTwo.java
### java MinotaurTwo.java
