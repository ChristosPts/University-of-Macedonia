/*Write a program in which the user enters a number (int) from 1 to 7 and accordingly it 
  will print the corresponding day of the week. The first day of the week (1) is Monday. 
  In case of an invalid day number, the message "ERROR" will be displayed.*/

#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

int main (){
    int day;
	printf("Give a day from 1 to 7: ");
    scanf("%d",&day);

 switch(day){
    case 1: printf("Monday"); break;
    case 2: printf("Tuesday"); break;
    case 3: printf("Wednesday"); break;
    case 4: printf("Thursday"); break;
    case 5: printf("Friday"); break;
    case 6: printf("Saturday"); break;
    case 7: printf("Sunday"); break;
    default: printf("ERROR");  break;

 }

 return 0;
}
