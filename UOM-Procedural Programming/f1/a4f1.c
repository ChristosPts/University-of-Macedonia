/*A merchant bought at wholesale price goods of value
  buyAmount #€ and sold them at saleAmount #€. If the amount
  saleAmount is derived from the net value of buyAmount and the
  profit percentage merchant's percentage of net worth
  buyAmount, be a program that calculates and displays:
  a) the trader's profit profit (double)
  b) the collected amount saleAmount (double).
  The input data should be in the form:
  buyAmount (variable of type long)
  rate (variable of type int, if the profit rate is 10% then type 10)*/


#include <stdio.h>
#include "genlib.h"
#include "math.h"

int main(){
    int rate;
    long purchaseAmount;
    double profit,saleAmount;

    printf("Give purchase amount: ");
    scanf("%d",&purchaseAmount);

    printf("Give profit rate: ");
    scanf("%d",&rate);

    profit=purchaseAmount*((double)rate/100);
    saleAmount=purchaseAmount+profit;

    printf("Profit: %0.f\n",profit);
    printf("Overal amount: %0.f",saleAmount);

   return 0;
}
