/*A wine industry has domestic and foreign shipments. Every shipment of wines
  includes a number of intended boxes for domestic shipments and a number of boxes that
  are intended for abroad. Every domestic box sent has postage 3500 drachma,and 5000
  drachma for foreign shipments. There can be multiple shipments each day.
  Write a program which for each shipment (which includes a known number of boxes
  for domestic and foreign) to estimate the amount required for postage of  domestic and
  foreign fees as well as their sum. The program at the end of the day it calculates both
  the domestic and foreign totals and the grand total for all shipments. Entering a negative number
  (e.g.-9999) ends thed day. All variables are of type long.*/


#include <stdio.h>
#include "math.h"
#include "genlib.h"

int main(){

    long domestic,foreign;
    long sumDom=0,sumFor=0,overalSum=0;

    while(TRUE){
        printf("Domestic shipments: ");
        scanf("%ld",&domestic);
        if(domestic<0){
                break;
            }
        printf("Foreign shipments: ");
        scanf("%ld",&foreign);

        sumDom += domestic*3500;
        sumFor += foreign*5000;
        overalSum = sumDom + sumFor;

        printf("%10ld %10ld %10ld\n",domestic*3500,foreign*5000,domestic*3500+foreign*5000);
    }

    printf("%10ld %10ld %10ld\n",sumDom,sumFor,overalSum);

    system("PAUSE");
    return 0;
 }
