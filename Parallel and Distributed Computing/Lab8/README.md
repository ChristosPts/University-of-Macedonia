## Lab 8
1. Study Code/Cycilc, DynamicAlloc, Executor and Code/Sieve\
Write parallel code for the Code/Sieve program with the following load distributions:\
1.1. Static: standard SPMD, as we have implemented load sharing so far.\
1.2. Simple cyclic allocation: as in Code/Cyclic/Simple/\
1.3. Dynamic allocation: as in Code/DynamicAlloc/MasterWorkerLock.java\
1.4. With Executor: as in Code/Executor/..Fixed/\
Compare their performance for as many prime numbers as you can.

2. Study Code/ForkJoin, JavaStream and Code/NumInt code\
Write parallel code for the Code/NumInt program with the following variations:\
2.1.With Executor: as in Code/Executor/..Fixed/\
2.2 Using ForkJoin Executor: as in Code/ForkJoin code\
2.3. Find the best values for block size and recursion termination\
2.4. Compare with the performance of the solution with JavaStreams.
