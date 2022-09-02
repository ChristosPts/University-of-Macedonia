/*Write a function named total() that accepts a number as a parameter and returns as
  value the sum of the numbers from 1 to the value of the parameter. For example, total(100)
  to return as a value the sum of the numbers from 1 to 100 = 5050. Develop a program
  in which the main() function will call total and display its results for values 100 and
  1000.*/


#include <stdio.h>

long total(int number);

int main(){


    printf("Sum of 1...%d is %ld\n",100,total(100));
    printf("Sum of 1...%d is %ld",1000,total(1000));

    return 0;
}

long total(int number){
    long sum = 0;
    for(int i=1; i<=number; i++){
         sum += i;
    }
    return sum;
}
