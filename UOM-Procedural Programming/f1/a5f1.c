/*Write a program that reads the working hours (int), the hourly wage (long) and the percentage
  (double) of a worker's deductions, and calculates and displays the gross earnings (double), 
  the amount of reservations(double) and his net earnings (double). 
  The amounts will be calculated as follows:
  Net Income = hours * hourly wage
  deductions = net income * percentage
  gross earnings = net earnings + deductions
*/

#include <stdio.h>
#include "genlib.h"
#include "math.h"

int main(){
    int workHours;
    long hourlyWage;
    double deductions,deductRate,netIncome,grossIncome;

    printf("Give work days: ");
    scanf("%d",&workHours);

    printf("Give hourly wage: ");
    scanf("%ld",&hourlyWage);

    printf("Give deduction rate: ");
    scanf("%lf",&deductRate);

    netIncome = workHours*hourlyWage;
    deductions = netIncome*deductRate;
    grossIncome =  deductions + netIncome;

    printf("Gross Income: %.0f\n",grossIncome);
    printf("Deduction: %.0f\n",deductions);
    printf("Net Income: %.0f",netIncome);


   return 0;
}
