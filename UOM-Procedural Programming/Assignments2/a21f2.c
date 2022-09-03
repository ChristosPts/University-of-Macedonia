/*Write a program that will calculate the child benefit (float) that an employee is entitled 
  to based on the salary (int) he receives.
  for one child: 4%
  for two children: 9%
  for three children: 15%
  for four children and more: 15% for the first 3 and an additional 4% for each subsequent child. 
  There is no need to check the input data, we consider that the user gives acceptable values ​​for 
  the basic salary and for the number of children (>=0).*/

#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

int main (){
    int kids,salary;
    float subsity;
    printf("Give salary: ");
    scanf("%d",&salary);
    printf("Give number of kids: ");
    scanf("%d",&kids);

    if(kids ==1){
        subsity = (double)salary*0.04;
    }
    else if(kids == 2){
        subsity = (double)salary*0.09;
    }
    else if(kids == 3){
         subsity = (double)salary*0.15;
    }
    else if(kids >= 4){
        subsity = (double)salary*3*0.15 + (double)salary*(kids-3)*0.04;
    }
    else subsity =0;

    printf("Subsity for %d kids is %.2f",kids,subsity);

 return 0;
}

