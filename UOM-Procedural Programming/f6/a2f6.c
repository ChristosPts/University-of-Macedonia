/*Write a program that reads non-negative integers (int) from the user 
  and stores them in a one-dimensional array of maximum size 100. The program 
  accepts numbers from the user until the value -1 is given. The program displayes
  the range of the giben numbers.(It calculates the maximum and minimum element of 
  the array and displays them on the screen). 
  >Use a function which reads the numbers from the user, stores them in the array
  (except -1), and returns the number of values entered
  >Use a function which finds the largest and smallest element of the array and returns
  the two values to the main function
  >*/

#include <stdio.h>

#define M 100

int getNumbers(int array[]);
void MinMax(int array[],int *max,int *min,int count);

int main(){

    int numArray[M],max,min,count;
    printf("Enter the elements of the array, one per line.");
    printf("\nUse -1 to signal the end of the list.\n");

    count = getNumbers(numArray);
    MinMax(numArray,&max,&min,count);

    printf("The range is %d-%d",min,max);

    return 0;
}

int getNumbers(int array[]){
    int num=0,i=0;
    while(1){
        printf("? ");
        scanf("%d",&num);
        if(num==-1){
            break;
        }
        else
        array[i] = num;
        i++;
    }
    return i;
}

void MinMax(int array[],int *max,int *min,int count){
    *min =  array[0];
    *max =  array[0];
    for(int i=0; i<count; i++){
        if(*max<array[i]){
            *max=array[i];
        }
        else if(*min>array[i]){
           *min=array[i];
        }
    }
}
