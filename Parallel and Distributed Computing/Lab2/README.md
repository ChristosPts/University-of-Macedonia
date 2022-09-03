## Shared variables, Simple parallelism (map)
### 1. Shared variables
Study Code/Shared and Code/Sqrt. In Code/Sqrt:\
1.1. Label all variables (local, object variables, class variables)\
1.2. Show which variables are shared and how (globals, arguments, via shared object.\
1.3. Try to implement different sharing methods like in Code/Shared.

### 2. Register multiplication by vector.
Study Code/Sqrt and Code/SimpleParallel/MatVec.java. Apply the Code/Sqrt code techniques in Code/SimpleParallel/MatVec.java for parallelism and 
timing measurements\
2.1. Label all variables (local, object variables, class variables)\
2.2. Show which variables are shared and how (global, arguments, via shared object\
2.2. Implement simple parallelization with static allocation. Count times for 1,2,4,8,16 threads and dimension 1000, 2000, 5000, 10000 elements.

### 3. Study and run Code/SimpleParallel/SimpleSat.java, SetPixels.java
3.1. Suggest solutions for their parallelism.\
3.1.1. Which part of the code will be parallelized, why?\
3.1.2. Show which variables are shared, generally label all variables.\
3.2. Implement your design with relevant code.\
3.3. Time your program and compare it to the sequential run
