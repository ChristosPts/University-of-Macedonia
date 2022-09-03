/*A company trades 5 products worth 250, 150, 320, 210 και 920 euros respectively.  The sale of
  of the above products is done through 4 sellers. The following table gives the sales made in a week:

			Salesman| Product1 | Product2 | Product3 | Product4 | Product5 
			----------------------------------------------------------------
			   1	|    10	   |	 4    |    5     |     6    |     7
			   2    |     7	   |	 0    |	  12     |     1    |     3
			   3	|     4	   |	19    |	   5     |     0    |     8
			   4	|     3	   |	 2    |	   1     |     5    |     6
				
  Write a program which:
  > Calculates and will store in a salesPerson[] array the total collection amount(int)
    for each salesperson, via a calculateSales() function
  > Calculates and will store in a productSale[] array the quantities (int) sold of each 
    product, via a calculateProductSales() function
  > Will print the total sales of each seller and the total sales of each product
    The seller with the highest sales (by revenue) and the product with the most 
    sales and how many units they sold.  
  > Uses a maxArray() function which will accept a one-dimensional array, its size 
    (number of elements) and return its maximum element and its position in the array
  > Uses a printArray() function which accepts an array, its dimensions and will print the 
    array to the screen in two columns, where the first column will be the position of the 
    element in the array and the second its value./

#include <stdio.h>
#include <stdlib.h>
#include "time.h"

#define ROWS 4
#define COLS 5

void calculateSales(int salesPerson[],int prices[],int array[ROWS][COLS]);
void calculateProductSales(int productSale[],int array[ROWS][COLS]);
void maxArray(int array[],int size, int *best, int *ammount);
void printArray(int array[],int size);

int main(){

    int array[ROWS][COLS] = {10,4,5,6,7,
                             7,0,12,1,3,
                             4,19,5,0,8,
                             3,2,1,5,6};

    int prices[COLS] = {250,150,320,210,920};

    int salesPerson[ROWS];
    int productSale[COLS];

    calculateSales(salesPerson,prices,array);
    calculateProductSales(productSale,array);

    int bestS,ammountS,bestP,ammountP;
    maxArray(salesPerson,ROWS,&bestS,&ammountS);
    maxArray(productSale,COLS,&bestP,&ammountP);

    printf("SalesMan-Sales\n");
    printArray(salesPerson,ROWS);
    printf("Best SalesMan was %d with %d sales\n",bestS,ammountS);

    printf("Product-Items\n");
    printArray(productSale,COLS);
    printf("Best Product was %d with %d items\n",bestP,ammountP);

    return 0;
}

void calculateSales(int salesPerson[],int prices[],int array[ROWS][COLS]){
    for(int i=0; i<ROWS; i++){
        salesPerson[i]=0;
        for(int j=0; j<COLS; j++){
            salesPerson[i]+=array[i][j]*prices[j];
        }
    }
}

void calculateProductSales(int productSale[],int array[ROWS][COLS]){
     for(int j=0; j<COLS; j++){
             productSale[j]=0;
        for(int i=0; i<ROWS; i++){
            productSale[j]+=array[i][j];
        }
    }
}

void maxArray(int array[],int size, int *best, int *ammount){
    *best=0;
    *ammount=0;
     for(int i=0; i<size; i++){
        if(*ammount<array[i]){
           *ammount = array[i];
           *best=i;
        }
     }
}


void printArray(int array[],int size){
     for(int i=0; i<size; i++){
        printf("%5d %5d\n",i,array[i]);
    }
}
