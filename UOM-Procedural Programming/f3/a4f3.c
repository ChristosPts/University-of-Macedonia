/*In a travel agency certain "movements" happen every day referring to seat reservations
  for a journey with total cost of 20000 euros. The ticket for one person costs 350 euros
  and there is a 10% discount per person for groups of more than 10 people. For each movement
  are given: the movement code (1=reserve seat, 2=termination of movement entries) (int).
  If the code is not 1 or 2, it will print an error message.
  Write a program that will calculate and display the cost (long) from each booking and finally
  the net profit (long) of the agency for this trip. If there is loss, the result will be negative.
  There is no need to check number of people we assume that the user gives valid values.
*/

#include <stdio.h>
#include "math.h"
#include "genlib.h"

int main(){

    int passengers,code;
    long cost,profit=0;

    while(1){
    printf("Enter code: ");
    scanf("%d",&code);
    while(code != 1 && code!=2){
        printf("Wrong input\n");
        printf("Enter code: ");
        scanf("%d",&code);
    }
    if(code==2){
        break;
    }

    printf("Give number of passengers: ");
    scanf("%d",&passengers);

    cost = passengers*350;
    if(passengers>10){
        cost -= cost*0.1;
    }
    profit+=cost;
    printf("Cost: %d\n",cost);

    }

    profit -= 20000;
    printf("Profit/Loss: %ld\n",profit);

    system("PAUSE");
    return 0;
 }

