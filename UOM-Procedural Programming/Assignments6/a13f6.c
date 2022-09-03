/*Write a decompose function(void), which will accept as an argument an integer (long) 
  and inform the calling function about the following:
   > the number of its digits,
   > the average of its digits,
   > its maximum digit.
  Implement a program which in the main() function will prompt the user for a number 
  (non-negative integer - no validation required), and uses the above function to display 
  (from the main() function) the above elements of the number. The average will be displayed 
  with 3 precision  decimal places.
*/

#include <stdio.h>

void decompose(long num,int *max,int *count,float *avg){
    *count=0;
    int remainder;
    *max=0;

   while (num != 0){
      remainder = num % 10;
      (*avg) +=remainder;
      num = num/10;
       if(*max<remainder){
         (*max)=remainder;
        }
      (*count)++;
   }
    (*avg)/=(*count);

}

int main(){

    long num;
    printf("Please insert non-negative number: ");
    scanf("%d",&num);

    int max,count;
    float avg;
    decompose(num,&max,&count,&avg);
   printf("Digits: %d\nAverage %.3f\nMax: %d",count,avg,max);


    return 0;
}

