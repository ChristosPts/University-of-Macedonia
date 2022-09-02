/*Using the following functions write a program which:
  - will fill array a of size 50 with random numbers from 0 to 9 using
  function rand() (a[i]=rand() % 10), of library <stdlib.h>
  - will display the array a on the screen (function printArr),
  - will request an integer N from 0 to 9 from the user - assume the users gives the correct input,
  - will call the checkTable function, which will count the number of occurrences of the number
    N in table a and the table positions in which the number appears
 The printing of the results will be done by the function main() , and the positions that
 the numbers N are will be displayed by calling printArr.
 (first position is 0 - last position is 49)
  */

#include <stdio.h>
#include "simpio.h"
#include <stdlib.h>
#include "time.h"

#define SIZE 50


void inputData(int array[]);
void printArray(int array[]);
int checkTable(int num, int array[], int index[]);

int main(){

    int num,array[SIZE],index[SIZE],count;

    inputData(array);
    printArray(array);

    printf("\nGive a number between 0 and 9: ");
    scanf("%d",&num);

    count  = checkTable(num,array,index);
    printf("%d shows up %d times at:\n",num,count);


    for(int i=0; i<count; i++){
         printf("%2d ",index[i]);
    }

    printf("\n");
    system("PAUSE");
    return 0;
}


void inputData(int array[]){
    srand(time(NULL));
    for(int i=0; i<SIZE; i++){
         array[i]=rand()%10;
    }
}

void printArray(int array[]){
     for(int i=0; i<SIZE; i++){
          printf("%2d ",array[i]);
    }
}

int checkTable(int num, int array[], int index[]){
     int count=0;

     for(int i=0; i<SIZE; i++){
         index[i]=0;
          if(array[i]==num){
            count++;
          }
       index[count] = i+1;
     }

    return count;
}

