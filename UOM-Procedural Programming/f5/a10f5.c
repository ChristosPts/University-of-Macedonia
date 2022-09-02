/*A shipping company carries household appliances of standard size and uses specifically
  transport boxes (containers) which hold 1, 5, 20 and 50 household appliances. Write a
  program which will read the number of home appliances (long) to be transferred and then
  calculate and display the required number of boxes of any size (long) so that the
  transport is carried out with the most economical  way (the minimum possible number of shipping
  boxes without unused space). The exercise will solved using tables.
  The results will be displayed in ascending order of the size of the containers as follows:
  2 places to display the standard size
  5 places to display the number of boxes*/

#include <stdio.h>
#include "stdlib.h"
#include "math.h"

#define ROWS 4
#define COLS 2

int main(){

    int array[ROWS][COLS]= {50,20,5,1};
    int num,f50,f20,f5;

    array[0][0]=50;
    array[1][0]=20;
    array[2][0]=5;
    array[3][0]=1;

    printf("Give amount boxes: ");
    scanf("%d",&num);

    array[0][1] = num/50;
    f50=(array[0][1]*50);

    array[1][1] = (num-f50)/20;
    f20 = f50+20*(array[1][1]);

    array[2][1] = (num-f20)/5;
    f5 = f20+(5*array[2][1]);

    array[3][1] =(num-f5)/1;

    for(int i=ROWS-1; i>=0; i--){
          printf("%2d", array[i][0]);
          printf("%5d", array[i][1]);
        printf("\n");
    }

    return 0;
 }

