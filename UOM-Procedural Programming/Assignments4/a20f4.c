/*Write a program that requests two dates (e.g. 2000, 2010) and displays the leap years
  between these dates. A leap year is when it is exactly divisible by 4. But the years that
  exactly divisible by 100 are not bisectors unless they are exactly divisible by 400. For the decision
  whether a year is a leap year or not, a function should be used that will pass the date as a parameter
  and return a value of 1 if the year is a leap year, and a value of 0 if it is not*/

#include <stdio.h>
#include "genlib.h"

bool findLeap(int year);

int main(){
    int year1,year2;

    printf("From year: ");
    scanf("%d",&year1);
    printf("To year: ");
    scanf("%d",&year2);

    for(int i=year1; i<year2; i++ ){
        if(findLeap(i)==1){
        printf("%d leap year\n",i);
        }
    }

   return 0;
}

bool findLeap(int year){
    if(year%400==0){
        return 1;
    }
     else if (year % 100 == 0) {
        return 0;
   }
    else if (year % 4 == 0) {
       return 1;
   }
   else return 0;

}
