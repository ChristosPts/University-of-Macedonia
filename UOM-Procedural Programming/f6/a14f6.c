/*A student is considered to have failed when his grade average in all subjects is less than 9.5, 
  while he is considered to have excelled when his grade average is greater than or equal to 18.5. 
  Write a program that implements the following 4 functions
  1)A function that will generate random grades on a scale of 0..20 for a given number of 
    students and courses and enter them into an appropriate array. Function parameters 
	dimensions of array and the array.
  2)A function that will accept for a specific number of students and courses their grades and 
    will calculate the average grade of each student and register it in a suitable array.
  3)A function that will display for each student his scores as well as his corresponding average.
  4)A function that will calculate and "return" the number and percentage of students who failed 
    as well as the number and percentage of students  which were excellent
  In the main program the above functions will be called and the display of what function 4 
  calculates will be done in the main program. Assume you have 30 students and 3 courses.*/

#include <stdio.h>
#include <stdlib.h>
#include "time.h"

#define COL 3
#define ROW 30


void readInputs(int array[ROW][COL]);
void sumGrades(int array[ROW][COL],float sum[ROW]);
void printGrades(int array[ROW][COL],float sum[ROW],int passed,int failed,float fperc,float pperc);
void evaluation(float sum[ROW],int *passed,int *failed,float *fperc,float *pperc);

int main(){

    int array[ROW][COL], passed,failed;
    float sum[ROW],fperc, pperc;

    readInputs(array);
    sumGrades(array,sum);
    evaluation(sum,&passed,&failed,&fperc,&pperc);
    printGrades(array,sum,passed,failed,fperc,pperc);

    return 0;
 }

void readInputs(int array[ROW][COL]){

    srand(time(NULL));
     for(int i=0; i<ROW; i++){
        for(int j=0; j<COL; j++){
            array[i][j] =  rand()%21;
        }
     }
 }

void sumGrades(int array[ROW][COL],float sum[ROW]){

     for(int i=0; i<ROW; i++){
            sum[i]=0;
        for(int j=0; j<COL; j++){
            sum[i] += (array[i][j]);
        }
       sum[i]/=COL;
     }
}

void printGrades(int array[ROW][COL],float sum[ROW],int passed,int failed,float fperc,float pperc){
        for(int i=0; i<ROW; i++){
            printf("%2d: ",i+1);
        for(int j=0; j<COL; j++){
           printf("%3d",array[i][j]);
        }
            printf(": %.1f ",sum[i]);
        printf("\n");
     }

      printf("Amount of students which failed: %d\n",failed);
      printf("Percentage of students which failed: %.2f%%\n",fperc);

      printf("Amount of honor students %d\n",passed);
      printf("Percentage of honor students: %.2f%%\n",pperc);

}

void evaluation(float sum[ROW],int *passed,int *failed,float *fperc,float *pperc){
    *passed = 0;
    *failed = 0;
    for(int i=0; i<ROW; i++){
        if(sum[i]>=18.5){
            (*passed)++;
        }
        if(sum[i]<9.5){
            (*failed)++;
        }
    }
     *fperc = ((double)*failed/COL)*10;
     *pperc = ((double)*passed/COL)*10;
}
