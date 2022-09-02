/*The grade in a student's course is given in integer values ​​from 0 to 20. A student is
  considered to have failed when the average of his grades in all subjects is less than 9.5,
  while he is considered to have excelled if his average is greater than or equal to 18.5.
  Write a program that reads the grades of 10 students in 3 subjects and registers them in
  an array. The program will calculate and display the number and percentage
  of students who failed, as well as the number and percentage of students who excelled*/

#include <stdio.h>
#include "simpio.h"
#include "math.h"

#define STUDENTS 10
#define SUBJECTS 3

int main(){

    int grades[STUDENTS][SUBJECTS],failed=0,honors=0;
    double sumGrades[STUDENTS];

    for(int i=0; i<STUDENTS; i++){
      sumGrades[i] = 0;
      printf("Student %d\n",i+1);
      printf("-------------\n");
        for(int j=0; j<SUBJECTS; j++){
           printf("Subject %d: ",j+1);
           scanf("%d",&grades[i][j]);
           sumGrades[i] += (double)grades[i][j]/SUBJECTS;
        }
        if(sumGrades[i] >= 18.5){
            honors++;
        }
        if(sumGrades[i] <9.5){
            failed++;
        }
        printf("\n");
    }



    printf("Failed : %d  %.2f%%\n",failed,((double)failed/STUDENTS)*100);
    printf("Honors : %d  %.2f%%",honors,((double)honors/STUDENTS)*100);

    printf("\n");
    system("PAUSE");
    return 0;
}



