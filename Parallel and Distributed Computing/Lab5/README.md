## Lab 5 - Calculation of π by numerical integration
After studying Code/VecSum apply the corresponding methods to a numerical integration problem, calculating π. The sequential code is in Code/NumInt.\
Shown below is how er calculatine π by numerical integration. We divide the value field into numSteps small parts, with step length. At the middle of 
each segment we calculate x, f(x) and sum the values of the step*f(x) areas to calculate π/4.

step = 1.0/numSteps;\
&nbsp; for(i=0; i<numSteps; i++){\
&nbsp;&nbsp;&nbsp;&nbsp;x = ((double)i+0.5)*step;\
&nbsp;&nbsp;&nbsp;&nbsp;sum + = 4.0/(1.0+x*x);\
&nbsp; }\
&nbsp; pi = sum*step;

Study the sequence code in Code/NumInt. First run experiments with the sequential code and rough timing to understand the behavior 
of the code. Then based on the code in Code/VecSum implement the various display-reduction schemes and compare the execution times.
