/*Write a program that displays averages of somatometric data of a group of N people
 (N is "constant" and is determined with the corresponding define command). N is equal to 5.
 The program will perform the following operations using the following functions

 > It will read N quadruplets of integers and insert them into a two-dimensional array
   Each tetrad refers to the elements of a person, which are in order the following:
     1)gender (0 if male, 1 if female)
     2)the weight (in kilograms, integer value)
     3)the height (in centimeters, integer value)
     4)the age (in years, integer value)

  > It will display the average weight, height and age for both males and females
    Calculating the average for each element will be done with the help of one function void FindMean
    In addition to the other parameters that you will define in the function, it will also have as a
    parameter an index (values 1,2,3). The subscript will point to the corresponding element of the
    quartet, whose average is calculated on the specific call, i.e. the appropriate column of the 2D array.

  In the main() function the above functions/procedures will be called appropriately in order to
  read the data and then display the averages of weight, height and age of men and women. Averages
  will be displayed to one decimal place.*/


#include <stdio.h>

#define N 5
#define M 4

void readData(int array[N][M]);
void FindMean(int array[N][M],int x,float *mAvg,float *fAvg);

int main(){

    int array[N][M];
    float maleAvg,femaleAvg,x;

    readData(array);
    FindMean(array,1,&maleAvg,&femaleAvg);
    printf("Average weight for men: %.1f\n",maleAvg);
    printf("Average weight for women: %.1f\n\n",femaleAvg);

    FindMean(array,2,&maleAvg,&femaleAvg);
    printf("Average height for men: %.1f\n",maleAvg);
    printf("Average height for women: %.1f\n\n",femaleAvg);

    FindMean(array,3,&maleAvg,&femaleAvg);
    printf("Average age for men: %.1f\n",maleAvg);
    printf("Average age for women: %.1f\n",femaleAvg);
    return 0;
}

void readData(int array[N][M]){

    for(int i=0; i<N; i++){
            printf("Enter Gender (Male=0)-(Female=1): ");
            scanf("%d",&array[i][0]);
            printf("Enter Weight: ");
            scanf("%d",&array[i][1]);
            printf("Enter Height: ");
            scanf("%d",&array[i][2]);
            printf("Enter Age: ");
            scanf("%d",&array[i][3]);
            printf("-------------\n");
     }
}

void FindMean(int array[N][M],int x,float *mAvg,float *fAvg){
    *mAvg = array[0][0];
    *fAvg = array[0][0];
    int mcount=0,fcount=0;

    for(int i=0; i<N; i++){
            if(array[i][0]==1){
                *fAvg +=(double)array[i][x];
                 fcount++;
            }
            if(array[i][0]==0){
                *mAvg +=(double)array[i][x];
                mcount++;
            }
     }
    *fAvg/=fcount;
    *mAvg/=mcount;

}

