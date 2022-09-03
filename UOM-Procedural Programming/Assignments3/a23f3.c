/*Write a program that will display the descending sequence of a given number*/

#include <stdio.h>
#include "simpio.h"

int main(){

     int number=0;

     printf("Enter number: ");
     number = GetInteger();
     printf("Descending sequence of %d: ",number);
     while(number >=0){
        printf("%d ",number);
        number = number-1;
     }

    return 0;
 }

