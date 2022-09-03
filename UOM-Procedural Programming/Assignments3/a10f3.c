/*Write a program that asks the keyboard for 100 grades (double), displays the average grade
 (double) as well as the two highest grades (double) with two decimal places.*/

#include <stdio.h>

int main(){
    double grade,max1,max2,average;

    for(int i=0; i<100; i++){
        printf("Enter grade %d -> ",i+1);
        scanf("%lf", &grade);
        average +=grade;
         if(grade > max1){
           max2 = max1;
           max1 = grade;
        }
        else if(grade > max2 ){
            max2 = grade;
        }
    }
    average/=4;

      printf("Average grade: %.2f\n",average);
      printf("1st: %.2f\n",max1);
      printf("2nd: %.2f",max2);

    return 0;
}

