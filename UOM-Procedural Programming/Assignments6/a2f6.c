/*Write a program that reads non-negative integers (int) from the user 
  and stores them in a one-dimensional array of maximum size 100. The program 
  accepts numbers from the user until the value -1 is given. The program displayes
  the range of the giben numbers.(It calculates the maximum and minimum element of 
  the array and displays them on the screen). 
  > Use a function which reads the numbers from the user, stores them in the array
   (except -1), and returns the number of values entered.
  > Use a function which finds the largest and smallest element of the array and returns
    the two values to the main function.*/

#include <stdio.h>

#define size 100

int getNumbers(int array[]){
    int i=0;
    while(1){
        printf("? ");
        scanf("%d",&array[i]);
        if(array[i]==-1){break;}
        i++;
    }
    return i;
}

void MinMax(int array[],int *low, int *high,int count){
    *low = array[0];
    *high = array[0];
    for(int i=0; i<count; i++){
        if(*low>array[i]){
            *low = array[i];
        }
        if(*high<array[i]){
            *high = array[i];
        }
    }
    printf("%d %d",*low,*high);
}

int main(){
     int array[size];
     printf("Enter the elements of the array, one per line.\nUse -1 to signal the end of the list.\n");
     int count = getNumbers(array);
     int low,high;
     MinMax(array,&low,&high,count);


    return 0;
}
