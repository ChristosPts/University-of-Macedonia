# Encoding - Decoding with Mealy and Moore machines

## Instructions
A) Build in JFLAP two Mealy machines, one for encoding and one for decoding according to the following procedures.\
B) Build in JFLAP two Moore machines, one for encoding and one for decoding according to the following procedures.

We have in the input a sequence of zeros and aces, e.g.: 0 1 0 1 0 0 1 0 0 1\
We read the digits of the sequence one by one and start extracting encrypted digits from the third digit onwards. The output is equal to the last digit of the sum of the last three digits. For this reason, we will need to assume that there are two extra zeros at the end of the input. For the above input, the output is as follows: 1 0 1 1 1 1 1 1 1 1 

![image](https://user-images.githubusercontent.com/105457831/188271413-a798c33d-66a6-462b-a3bf-5b76bee0fefc.png)

In the figure above, the value of x is derived from the values of a, b, and c:\
![image](https://user-images.githubusercontent.com/105457831/188271478-5909972f-202b-4671-b61e-2367ca16192d.png)


For decoding, we proceed from the end to the beginning, taking into account the last two digits added.\
![image](https://user-images.githubusercontent.com/105457831/188271652-a4c8ec90-ae12-4f58-aad6-6233a9aac083.png)

Similarly, in the figure above, the value of x is derived from the values of a, b, and c:\
![image](https://user-images.githubusercontent.com/105457831/188271606-2a9b6bb3-d594-4f96-9fa4-52d9c56b6952.png)

Specifically, if the sum of a, b, and c is 01 or 11, x is equal to 1. Otherwise, if the sum of a, b, and c is 00 or 10, x is equal to 0.

*Note: Mealy and Moore machines are equal/similar. The difference between Mealy and Moore machines lies only in matters of timing.*

## Solution
### Encryption
Based on the above procedures we can conclude the we need to create encoding and decoding machines for a 3-bit XOR gate.
The encryption works on the condition that the user gives the last two zeros. During the transitions from q0 no output is given since we want to ignore the first two elements. In the Mealy machine the labels of the states indicate which position of the table we are in and the transition to them prints the corresponding result of the XOR table, while in the Moore machine the output is given to the state itself and not to the transition to it.

### Decryption
The machine works with the condition that the last two zeros of the original text are already in the machine so they do not need to be supplied by the user.



