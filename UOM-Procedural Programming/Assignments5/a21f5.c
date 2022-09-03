/*Write a program that reads 5 real numbers(double) and stores them in an array. The program calculates the distances 
  between consecutive elements of the table and stores them in a new array. The distance is derived as the absolute 
  value of the difference of the elements (fabs function). For example, if the first four elements of the array are: 
  5.2, -3.2, 7.5, 12.22, the corresponding distances are: |-3.2-5.2| = 8.4, |7.5-(-3.2)| = 10.7 
  and |12.22-7.5| = 4.72. The program will finally display the original table that
  entered by the user, on a line as well as the table of differences according to the execution that
  is presented. Each element of the arrays will be displayed with 2 decimal places.*/


#include <stdio.h>
#include "simpio.h"
#include "genlib.h"
#include <math.h>

#define SIZE 5 // Numbers


int main(){
   double array[SIZE], temp,array2[SIZE-1];

    for(int i=0; i<SIZE; i++){
        printf("Enter number (%d): ",i);
        scanf("%lf",&array[i]);
    }

    for(int i=0; i<SIZE; i++){
        printf("%3.2f ",array[i]);
    }

    for(int i=0; i<SIZE; i++){
        array2[i] = fabs(array[i+1] - array[i]);
    }
     printf("\n");
    for(int i=0; i<SIZE-1; i++){
        printf("%3.2f ",array2[i]);
    }



   return 0;
}
