/*A company trades 5 products worth 25000, 15000, 32000, 21000 and 9200 euros respectively. The sale of
  of the above products is done through 4 sellers. The following table gives the sales made in a week:

			Salesman| Product1 | Product2 | Product3 | Product4 | Product5
			----------------------------------------------------------------
			   1	|    10	   |	 4    |    5     |    6    |     7
			   2	|    7	   |	 0    |	   12    |    1    |     3
			   3	|    4	   |	 9    |	   5     |    0    |     8
			   4	|    3	   |	 2    |	   1     |    5    |     6


  Write a program that will calculate:
  a)the total sales amount (long) for each seller. The display of amounts for all sellers
    will be on the same line with space between each amount.
  b)the total commission (double) for each seller, each seller has a commission of 10%.
    The display of commissions for all sellers will be done in the same line with a space
	character between each amount.
  c)the quantities (int) sold of each product. The display of quantities for all
    products will be made on the same line with a blank character between each amount.

*/

#include <stdio.h>

#define ROWS 4
#define COLS 5



 int main(){

    int array[ROWS][COLS] = {10,4,5,6,7,
                             7,0,12,1,3,
                             4,9,5,0,8,
                             3,2,1,5,6};

    int prices[COLS] = {25000,15000,32000,21000,9200};

    long sumSales[ROWS];
    float commission[ROWS];
    int quantities[COLS];

    printf("Overal Sales Ammount/Seller:");
    for(int i=0; i<ROWS; i++){
        sumSales[i] = 0;
        for(int j=0; j<COLS; j++){
        sumSales[i] += array[i][j]*prices[j];
        }
        printf(" %d ",sumSales[i]);
     }

     printf("\nCommissions:");
     for(int i=0; i<ROWS; i++){
        commission[i] = (double)sumSales[i]*0.1;
        printf(" %.2f ", commission[i]);
     }

    printf("\nQuantities sold:");
     for(int j=0; j<COLS; j++){
        quantities[j] = 0;
        for(int i=0; i<ROWS; i++){
        quantities[j] += array[i][j];
        }
        printf(" %d ",quantities[j]);
     }

    return 0;
 }
