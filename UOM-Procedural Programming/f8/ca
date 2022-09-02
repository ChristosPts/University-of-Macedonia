/*A car rental company keeps the following data for each rental:
   -Rental number
   -Brand
   -Capacity (cc)
   -Tenant name
   -Rental days
   -Price per day
   
   Write a program that will perform the following functions:
	1. Enter the number of rentals
	2. Enter the details of each rental
	3. Calculation of detailed payment statement.
	4. Calculation of the rental with the greatest profit
	5. Show detailed status
	6. Display the data (Brand, Cubic, Total Amount) for the rental with the highest profit.
 
  The above data will be entered into a structure array (maximum arrat dimension N=20). 
  The rental number will be automatically given by the program.	
 */


#include <stdio.h>
#include "simpio.h"
#include <string.h>

typedef struct{
    int leaseNum;
    char brand[20];
    char name[40];
    int capacity;
    int days;
    float price;
    float total_price;
}CarsT;

void infoInput(CarsT info[], int num);
float calcSales(CarsT info[], int num);
CarsT findBest(CarsT info[], int num);
void print_data(CarsT info[], int num,float total,CarsT best);

int main(){
    CarsT leaseInfo[20],bestCar;
    int num;

    printf("Give ammount of car rents: ");
    scanf("%d",&num);
    infoInput(leaseInfo,num);

    float overalTotal = calcSales(leaseInfo,num);

    bestCar =findBest(leaseInfo,num );

     print_data(leaseInfo,num,overalTotal,bestCar);

    system("PAUSE");
    return 0;
}

void infoInput(CarsT info[], int num){
    for(int i=0; i<num; i++){
        info[i].leaseNum=i;
        printf("\nGive information for renter %d\n",i);

        printf("Give brand: ");
        getchar();
        gets(info[i].brand);

        printf("Give capacity: ");
        scanf("%d",&info[i].capacity);

        printf("Give renters name: ");
        getchar();
        gets(info[i].name);

        printf("Give renting days: ");
        scanf("%d",&info[i].days);

        printf("Give price per day: ");
        scanf("%f",&info[i].price);
    }
}

float calcSales(CarsT info[], int num){
    float total=0;

    for(int i=0; i<num; i++){
         info[i].total_price = 0;
         info[i].total_price = info[i].days*info[i].price;
         total+=info[i].total_price;
    }

    return total;
}

CarsT findBest(CarsT info[],int num){
    CarsT best;
    strcpy(best.brand, info[0].brand);
    best.capacity=info[0].capacity;
    best.total_price=info[0].total_price;

    for(int i=0; i<num; i++){
        if(best.total_price<info[i].total_price){
            strcpy(best.brand, info[i].brand);
            best.capacity=info[i].capacity;
            best.total_price=info[i].total_price;
        }
    }

    return best;
}

void print_data(CarsT info[], int num,float total,CarsT best){

	printf("\n%-7s %-16s %-12s %-13s %-10s %-10s %-10s\n",
		   "Number","Name","Type","CC","Days","Price","Total");
	for(int i=0; i<90; i++){printf("-");}
	printf("\n");

	for(int i=0; i<num; i++){
		printf("%-7d %-16s %-12s %-13d %-10d %-10.2f %-10.2f\n",
			   info[i].leaseNum,
			   info[i].name,
			   info[i].brand,
			   info[i].capacity,
			   info[i].days,
			   info[i].price,
			   info[i].total_price);
	}

	for(int i=0; i<90; i++){printf("-");}
	printf("\n%+68s %15.2f\n","Total",total);
	printf("Best car: %s %d rented %.2f Euros.\n",best.brand,best.capacity,best.total_price);

}
