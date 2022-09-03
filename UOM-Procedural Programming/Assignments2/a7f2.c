/*Write a C program to calculate and display an employee's weekly pay as follows: 
  The program will read the code number (long) of the employee. If the code number 
  is greater than or equal to 1000, then the program will read the employee's annual 
  salary (double) and calculate his weekly salary (double) by dividing the annual 
  salary by 52.
  If the code is less than 1000, then the program will read the employee's weekly 
  hours (int), hourly pay (double) and then calculate the weekly pay. If the weekly 
  work is more than 40 hours, then for the hours beyond 40 hours the pay 
  has a 50% salary increase.*/

#include <stdio.h>
#include "genlib.h"
#include "math.h"

int main(){
    long code;
    int hours;
    double hourlyWage,weeklyWage,yearlyWage;

    printf("Enter code: ");
    scanf("%ld",&code);

    if(code>=1000){
        printf("Yearly wage: ");
        scanf("%lf",&yearlyWage);
        weeklyWage = yearlyWage/52;

    }
    else if(code>=0 && code<1000){
        printf("Weekly work hours: ");
        scanf("%d",&hours);
        printf("Hourly wage: ");
        scanf("%lf",&hourlyWage);
        if(hours>40){
             weeklyWage = hours*hourlyWage+(hours-40)*0.5*hourlyWage;
        }
        else weeklyWage = hours*hourlyWage;
    }
    else{printf("Wrong input");}

    printf("Weekly wage: %.0f ",weeklyWage);


   return 0;
}
