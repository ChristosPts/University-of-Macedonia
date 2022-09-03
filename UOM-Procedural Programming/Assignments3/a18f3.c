/*An organization organizes a fundraiser for charity. His goal is to collect at least €100,000.
  Write a program that requests the amount given from each person who participated in the fundraiser.
  The process will stop when the amount of €100,000 (greater or equal) is reached. Finally,
  the program will display the number (int) of people who participated in the fundraiser, the
  largest (int) and the smallest (int) amount given.
*/

#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

int main(){
    long sum=0,amount;
    int count=0,max, min;

     printf("Give amount: ");
     amount = GetLong();
     min = amount;
     max = amount;

	while(1){
        sum+=amount;
        count++;

        if(max<amount){
           max = amount;
        }

        else if (min>amount){
        min = amount;
        }

        if(sum>=100000){
          break;
        }

     printf("Give amount: ");
     amount = GetLong();

    }

    printf("Number of participants: %d\n",count);
    printf("Sum amount: %ld\n",sum);
    printf("Max amount: %d\nMin amount: %d",max,min);

    return 0;
}
