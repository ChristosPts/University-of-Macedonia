# Sorting numbers from 0 to 9 with a Turing machine
## Instructions
Create a Turing machine that sorts numbers on its tape. In particular, each position on the tape will contain a single digit number from 0 to 9 or a blank. 
The Turing machine should sort the numbers in ascending order and leave the head where it started.
You can use any number of tapes, but the numbers to be sorted need to be on the 1st tape.

## Solution
The head is located at the left end of the tape, and after the numbers are sorted it returns to its original position. For the operation of the machine, the
first symbol required to  be entered is "#". "#" works indicatively as blank space and is later replaced by jflap's blank space symbol. Theoretically the
machine can sort any number of numbers from 0 to 9.

![image](https://user-images.githubusercontent.com/105457831/188270692-8444f24b-1109-43a8-b88d-b53f20205fa8.png)

