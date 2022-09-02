/*Write a program that reads an array of people's ages (sequence of int numbers entered by
  the user) and finds the youngest and oldest ages. The program will continue to read ages
  until -1 is given*/

#include <stdio.h>

int main(){

     int age, big,small;

     printf("Give age: ");
     scanf("%d",&age);

     small=age;
     big=age;

     while (1){
      if(age == -1){
            break;
        }
        if (age>big){
            big = age;
        }
        if (age<=small){
            small = age;
        }
        printf("Give age: ");
        scanf("%d",&age);
        }

     printf("Largest age is: %d\n",big);
     printf("Smallest age is: %d",small);

    return 0;
 }
