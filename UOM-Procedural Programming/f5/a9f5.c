/*Write a program that will read 2 numbers (int) M and N, and then:

  >using a Read_Array procedure will read the MxN (rows x columns) elements
  (long) of a two-dimensional matrix A (maximum dimension 50x50).
  >using a Find_Min_of_Rows procedure will find and store in one
  one-dimensional array B (maximum dimension 50) the minimum term of each row of array A.
  >using a Print_Min_Array procedure will display the one-dimensional array that
  created in the previous procedure.

  The procedures will be called from main in the above order*/

#include <stdio.h>
#include "stdlib.h"

#define ROWS 50
#define COLS 50

void Read_Array(int row,int col,long array[row][col]);
void Find_Min_of_Rows(int row,int col,long array[row][col],long minArray[]);
void Print_Min_Array(int row,long minArray[]);

int main(){

    long array[ROWS][COLS],minArray[ROWS];
    int row,col;

    printf("Give amount of rows for array: ");
    scanf("%d",&row);
    printf("Give amount of columns for array: ");
    scanf("%d",&col);

    Read_Array(row,col,array);
    Find_Min_of_Rows(row,col,array,minArray);
    Print_Min_Array(row,minArray);

    return 0;
 }

void Read_Array(int row,int col,long array[row][col]){

    for(int i = 0; i<row; i++){
        for(int j = 0; j<col; j++){
           printf("Row %d element %d: ",i+1,j);
           scanf("%ld",&array[i][j]);
        }
    }

}

void Find_Min_of_Rows(int row,int col,long array[row][col],long minArray[]){

     for(int i = 0; i<row; i++){
            minArray[i]=array[i][0];
        for(int j = 0; j<col; j++){
           if(minArray[i]>array[i][j])
           minArray[i] = array[i][j];
        }
    }
}

void Print_Min_Array(int row,long minArray[]){

    for(int i = 0; i<row; i++){
        printf("min of row %d: %d\n",i+1,minArray[i]);
    }

}

