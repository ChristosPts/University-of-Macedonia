/*Given the function f(x)= x^4 - 5x^2 +3, (using pow() and the math.h library)
  write a program that displays the values returned by the function for values
  of (double)x from 0 up to 1 with a step of 0.05.*/

#include <stdio.h>
#include "math.h"

int main(){

    float x=0,sum;

    while(x<1.0){
        sum = pow(x,4) - 5*pow(x,2) +3;
        printf("x = %f  f(x) = %9f\n",x,sum);
        x=x+0.05;
    }

    return 0;
}
