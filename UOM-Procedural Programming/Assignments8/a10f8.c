/*A project calendar records various work packages (WP). Each task has a name (char name [60]), 
  a start month (int) as measured from the start of the project, and a duration in months
 (int). For example:
  - the “project specifications” task has a start time of 0 (starts in the first month of the project) 
  and a duration of 4 months, so it is considered to be completed in the 4th month.
  - the task “implementation” has a start time of 2 and a duration of 8 months, so it is considered to be 
  completed in month 10 (10 = 8 + 2)
  
  (a) Define an appropriate structure to store the tasks' data
  (b) Design a program which: 
	   > Asks the user for the total number of WP project tasks.
	   > Through a function ReadWorkpackages asks the user for the details of the WP tasks 
	     (name, start time and duration).
	   > Finds which job starts first via the FindFirstWp function, which returns the structure 
	     of the first job.
	   > Prints the first task's data to the screen via the main() function.
	   > Finds the total project duration  via the FindMakespan function. The total duration of the 
	     project is defined as the month in which the last task is completed (all tasks are finished).
	   > Displays the total duration of the project on the screen.	 
  
  For the above define an array of structures with a size of at least 100. It is assumed that the user:
   (a) will not enter more than 100 tasks (no checking required),
   (b) will always enter a non-negative start time integer (no checking required), 
   (c) that it will always enter a positive integer as duration (no checking required) and
   (d) task names are strictly less than 60 characters (no checking required).
 */


#include <stdio.h>
#include <string.h>
#include "genlib.h"
#include "simpio.h"

#define M 100

typedef struct{
    char name[60];
    int month;
    int length;
}OperationsT;

void ReadWorkpackages(OperationsT jobs[], int x);
OperationsT FindFirstWp(OperationsT jobs[], int x);
int FindMakespan(OperationsT jobs[], int x);

int main(){

    OperationsT jobs[M],first;

    int x;

    printf("Total work packages: ");
    scanf("%d",&x);

    ReadWorkpackages(jobs,x);
    first = FindFirstWp(jobs,x);

    printf("FIRST WP: %s |Starting Month: %d |Duration: %d\n"
           ,first.name,first.month,first.length);

    int duration = FindMakespan(jobs,x);
    printf("Total duration = %d",duration);

    return 0;
}

void ReadWorkpackages(OperationsT jobs[], int x){

    printf("-------------------\n");
    for(int i=0; i<x; i++){
        jobs[i].month = -1;
        printf("Work package %d\n",i);

        printf("WP name: ");
        getchar();
        gets(jobs[i].name);

    while(jobs[i].month<0 || jobs[i].month>11){
        printf("WP Start Month: ");
        scanf("%d",&jobs[i].month);
    }

        printf("WP Duration: ");
        scanf("%d",&jobs[i].length);
        printf("-------------------\n");
     }

}

OperationsT FindFirstWp(OperationsT jobs[], int x){
    OperationsT first;
    first = jobs[0];

    for(int i=0; i<x; i++){
        if(first.month>jobs[i].month){
            first.month=jobs[i].month;
            first = jobs[i];
        }
    }

    return first;
}

int FindMakespan(OperationsT jobs[], int x){
    int duration=0;

    for(int i=0; i<x; i++){
        if(duration<jobs[i].length+jobs[i].month)
           duration=jobs[i].length+jobs[i].month;
    }
    return duration;
}
