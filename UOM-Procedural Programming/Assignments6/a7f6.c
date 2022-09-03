/*A cinema chain has summer cinemas in cities in Greece and Cyprus (1 screen/city) although
  it is considering expanding its cinema network to other Balkan countries. This company wants
  to develop a program to record receipts and calculate and display various simple statistics
  (per country). The monthly receipts of each hall for a summer are entered in a two-dimensional
  array (cities, months). The program will perform the following 6 operations using functions:

  1) A function that will read the monthly receipts of each city and store them in a 2-dimensional array.
     In the summer, the cinemas are open all 3 months. The function will have parameters the dimensions
     of the table, the table and the price of the ticket. It will read the number of tickets of each
     city for each summer month and calculate the corresponding collection based on the specified ticket price.
  2) Function that will calculate the average monthly collection for each city.
  3) Function that will calculate the average monthly collection for each month
  4) Function that will calculate the smallest monthly collection and in which city and in which month was held.
  5) Function that will display the cinema receipts for each city and each month.
  6) Function that will display the average monthly collection for each room, the average monthly collection
     for each month, the smallest monthly collection and in which city and in which month it took place

  The price of the ticket in Greece is 7.5 euro and in Cyprus 8.5 euro. Overall there are 5 screens in Greece
  and 2 in Cyprus.*/

#include <stdio.h>

#define MONTHS 3
#define Gr 5
#define Cy 2

void inputs(int row,int col,int array[row][col],float price,float revenue[row][col]){
    for(int i=0; i<row; i++){
        for(int j=0; j<col; j++){
            printf("Give tickets: [%d][%d]: ",i,j);
            scanf("%d",&array[i][j]);
            revenue[i][j] = (double)array[i][j]*price;
        }
    }
}

void avgCity(int row,int col,float revenue[row][col],float cityArr[row]){
     for(int i=0; i<row; i++){
        cityArr[i] = 0;
        for(int j=0; j<col; j++){
             cityArr[i] += revenue[i][j]/col;

        }
     }
}

void avgMonth(int row,int col,float revenue[row][col],float monthArr[col]){

    for(int j=0; j<col; j++){
      monthArr[j] = 0;
       for(int i=0; i<row; i++){
             monthArr[j] += revenue[i][j] /row;

        }
     }
}

float findMin(int row,int col,float revenue[row][col],int *city, int *month){
    *city = 0;
    *month = 0;
    float minRev = revenue[0][0];
    for(int i=0; i<row; i++){
        for(int j=0; j<col; j++){
           if(minRev>revenue[i][j]){
              minRev=revenue[i][j];
             *city = i;
             *month = j;
           }
        }
    }
    return minRev;
}

void print1(int row,int col,float revenue[row][col]){
    for(int i=0; i<row; i++){
        printf("City %d: ",i);
        for(int j=0; j<col; j++){
            printf("%.2f ",revenue[i][j]);
        }
        printf("\n");
    }
}

void print2(int row,int col,float cityArr[row],float monthArr[col],float min,int city, int month){
    printf("Cities average revenues\n");
    for(int i=0;i<row;i++){
        printf("City %d: %.2f\n",i,cityArr[i]);
    }
    printf("Months average revenues\n");
    for(int j=0;j<col;j++){
        printf("Month %d: %.2f \n",j, monthArr[j]);
    }
    printf("Min revenue: %.2f\nCity: %d\nMonth: %d",min,city,month);
}

int main(){

    int cyArray[Cy][MONTHS],grArray[Gr][MONTHS];
    float cyRevenue[Cy][MONTHS],grRevenue[Gr][MONTHS];
    float cyCityAvg[Cy],grCityAvg[Gr];
    float cyMonthAvg[Cy],grMonthAvg[Gr];
    int month,city;
    float min;

    printf("Tickets in Greece\n");
    inputs(Gr,MONTHS,grArray,7.5,grRevenue);
    printf("Tickets in Cyprus\n");
    inputs(Cy,MONTHS,cyArray,8.5,cyRevenue);

    printf("Cinema Revenues in Greece\n");
    print1(Gr,MONTHS,grRevenue);

    avgCity(Gr,MONTHS,grRevenue,grCityAvg);
    avgMonth(Gr,MONTHS,grRevenue,grMonthAvg);

    min = findMin(Gr,MONTHS,grRevenue,&city,&month);
    print2(Gr,MONTHS,grCityAvg,grMonthAvg,min,city,month);



    printf("\nCinema Revenues in Cyprus\n");
    print1(Cy,MONTHS,cyRevenue);

    avgCity(Cy,MONTHS,cyRevenue,cyCityAvg);
    avgMonth(Cy,MONTHS,cyRevenue,cyMonthAvg);

    min = findMin(Cy,MONTHS,cyRevenue,&city,&month);

    print2(Cy,MONTHS,cyCityAvg,cyMonthAvg,min,city,month);


    return 0;
}

