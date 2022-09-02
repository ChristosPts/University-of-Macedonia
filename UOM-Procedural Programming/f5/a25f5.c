/*The seats of a small plane are represented by a two-dimensional table (seats) like
  shown in the incomplete C program below (for simplicity the array is initialized and 
  you are also given the upDateSeats function to try other values, which you will keep in the final code).
  
	#define ROWS 12
	#define COLUMNS 4
	
	void upDateSeats(int row, int col, int tab[row][col]);
	
	int main() {
		int seats[ROWS][COLUMNS] = {{1,0, 0, 1},
					    {1,0, 0, 1},
					    {0,1, 0, 0},
					    {0,0, 1, 1},
					    {1,1, 0, 0},
					    {1,1, 0, 1},
					    {0,0, 1, 1},
					    {1,0, 0, 0},
					    {0,0, 1, 0},
					    {0,0, 0, 0},
					    {0,0, 0, 0},
					    {1,1, 0, 1}};
			upDateSeats(ROWS,COLUMNS,seats);
			
		return 0;
	}
	Function for Testing. 
	void upDateSeats(int rows, int cols, int tab[rows][cols]){
		int i,j;
		printf("Update Seats? (0/no):");
		if(!GetInteger()) return;
			for(i=0;i<rows;i++)
				for(j=0;j<cols;j++)
				tab[i][j] = (printf("seat (%2d,%2d)",i,j),GetInteger());
		printf("\n");
	}
    
  
  If the content of a position in the table has the value 0, the corresponding position of the plane is
  available. If the contents of a position of the table has the value 1, the corresponding position of 
  the plane is taken.
  >Write a function named findEmptyRows that prints the numbers of the rows that are
   completely empty. Note that plane row/column numbering starts at 0.
  >Write a function named findFirstAvailableWindow that prints the first available window seat
   (row, column).
*/


#include <stdio.h>
#include "simpio.h"
#include "genlib.h"
#include <math.h>

#define ROWS 12
#define COLUMNS 4

void upDateSeats(int row, int col, int tab[row][col]);
void findEmptyRows(int row, int col, int tab[row][col]);
void findFirstAvailableWindow(int row, int col, int tab[row][col]);

int main() {
    int seats[ROWS][COLUMNS] = {{1,0, 0, 1},
                                {1,0, 0, 1},
                                {0,1, 0, 0},
                                {0,0, 1, 1},
                                {1,1, 0, 0},
                                {1,1, 0, 1},
                                {0,0, 1, 1},
                                {1,0, 0, 0},
                                {0,0, 1, 0},
                                {0,0, 0, 0},
                                {0,0, 0, 0},
                                {1,1, 0, 1}};

    upDateSeats(ROWS,COLUMNS,seats);
    findEmptyRows(ROWS,COLUMNS,seats);
    findFirstAvailableWindow(ROWS,COLUMNS,seats);

    return 0;
}

/* Function for Testing. */
void upDateSeats(int rows, int cols, int tab[rows][cols]){
    int i,j;
    printf("Update Seats? (1/yes)(0/no):");
    if(!GetInteger()) return;
        for(i=0;i<rows;i++)
            for(j=0;j<cols;j++)
            tab[i][j] = (printf("seat (%2d,%2d)",i,j),GetInteger());
        printf("\n");
}


void findEmptyRows(int row, int col, int tab[row][col]){
    int count=0,empty[row],positions[row];

    for(int i=0; i<row; i++){
         empty[i] = 0;
        for(int j=0; j<col; j++){
            empty[i] += tab[i][j];
        }
        if(empty[i]==0){
            count++;
        }
         positions[count]=i+1;
    }

      for(int i=0; i<count; i++){
        printf("Row: %d\n",positions[i]);
      }
}

void findFirstAvailableWindow(int row, int col, int tab[row][col]){
    int seatRow=0,seatCol=0;

    for(int i=0; i<row; i++){
         if(tab[i][0]==0){
            seatRow=i;
            seatCol=0;
            break;
        }
         else if(tab[i][3]==0){
            seatRow=i;
            seatCol=3;
            break;
        }
     }

     printf("First available window seat: %d,%d",seatRow,seatCol);

}
