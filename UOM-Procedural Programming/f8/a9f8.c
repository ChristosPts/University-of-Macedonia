/*A language school maintains the following payroll data for employees (teachers).
  -Name and Surname
  -Hourly wage
  -Working hours
  -Mixed earnings
  -Reservations
  -Tax
  -Net earnings

  Write a program that will define an employee structure with the above
  elements and perform the following:
	1. input of the number of employees
	2. input of teacher details
	3. enter salary
	4. enter working hours
	5. Calculation of gross earnings
	6. Calculation of net earnings
	7. Show detailed status

  >Main: 1
  >Function get_data: 2,3,4
  >Function calc_salaries: 5,6
  >Function print_data function: 7
  Deductions are 15% of gross earnings and tax is 7% of gross less deductions.
*/


#include <stdio.h>
#include "simpio.h"
#include <string.h>

#define M 100
#define N 10000000000

typedef struct{
    char firstName[20];
    char lastName[30];
    int workHours;
    float hourlyRate;
    float gross;
    float deductions;
    float tax;
    float net;
}EmployeeT;

void employessInput(EmployeeT info[], int num);
void calc_salaries(EmployeeT info[], int num);
void print_data(EmployeeT info[], int num);

int main(){
    EmployeeT info[M];

    int num;

    printf("Give ammount of Employees: ");
    scanf("%d",&num);
    employessInput(info,num);
    calc_salaries(info,num);
    print_data(info,num);

    system("PAUSE");
    return 0;
}

void employessInput(EmployeeT info[], int num){

    for(int i=0; i<num; i++){
        info[i].workHours=-1;
        info[i].hourlyRate=-1;
        printf("Give information for employee %d\n",i+1);

        printf("First Name: ");
        getchar();
        gets(info[i].firstName);

        printf("Last Name: ");
        getchar();
        gets(info[i].lastName);

      while(info[i].hourlyRate>N || info[i].hourlyRate<0){
        printf("Hourly rate: ");
        scanf("%f",&info[i].hourlyRate);
      }

      while(info[i].workHours>300 || info[i].workHours<0){
            printf("Hours worked: ");
            scanf("%d",&info[i].workHours);
        }
    }

}

void calc_salaries(EmployeeT info[], int num){

    for(int i=0; i<num; i++){
        info[i].gross = info[i].hourlyRate*info[i].workHours;
        info[i].deductions = info[i].gross*0.15;
        info[i].tax = (info[i].gross-info[i].deductions)*0.07;
        info[i].net = info[i].gross-info[i].deductions-info[i].tax;
    }

}

void print_data(EmployeeT info[], int num){

    printf("%-16s %-16s %12s %+13s %10s %10s %10s %10s\n",
	       "Name","Surname","Hourly Rate","Hours Worked",
		   "Gross","Deduction","Tax","Net");

	for(int i=0; i<105; i++){printf("-");}
    printf("\n");

	for(int i=0; i<num; i++){
        printf("%-16s %-16s  %11.2f %13.2f %10.2f %10.2f %10.2f %10.2f\n",
               info[i].firstName,
			   info[i].lastName,
			   info[i].hourlyRate,
               info[i].gross,
			   info[i].deductions,
			   info[i].tax,
               info[i].tax,
			   info[i].net);
    }

    for(int i=0; i<105; i++){printf("-");}
	printf("\n");
}
