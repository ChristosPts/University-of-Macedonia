/*Write a program that reads 5 integers and stores them in an array. The program will then rotate 
  the array elements one position to the right and print the array. For example, if the array 
  elements are: 1, -9, 5, 3, 4 the array after rotation will be: 4, 1, -9, 5, 3.*/
  
#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

#define NUM 5 // Numbers


int main()
{
   int NUMBERS[NUM], i, temp;

   /* Read 5 numbers */
   for (i=0; i<NUM; i++){
            printf("Enter number: ");
            NUMBERS[i]=GetInteger();
  }
   /* Rotate */
   temp = NUMBERS[NUM-1];
   for (i=NUM-1;i>0;i--)
   {
        NUMBERS[i] = NUMBERS[i-1];
   }
   NUMBERS[0]=temp;
   for (i=0;i<NUM;i++)
   {
        printf("%d ",NUMBERS[i]);
   }
   return 0;

}

  
