/*The VAT of a product belongs to one of the following categories

			Category 	VAT Rate
				1 		  0.00
				2 		  0.06
				3 		  0.13
				4 		  0.19

  Write a program that will ask to enter the count(int), the unit value(double) and the VAT category(int)
  for 5 products. The program should show the total cost of the expenditure as well as the total VAT for all
  the products. The VAT calculation must be implemented by a function to which it will be transferred the total
  amount per product as well as the category in which belongs. If the user gives  the wrong VAT category, then
  the function will display an error message, and it will returns a value of 0. In this case, the total expense
  cost is calculated as normal of the product, which was entered with the wrong VAT, as shown in the right image below

*/

#include <stdio.h>
#include "simpio.h"

double calcVat(int amount, double price,int vatCategory);

int main(){
    int amount,vatCategory;
    double price,sum=0,vat=0,overalVat=0;

    for(int i =0; i<5; i++){
        printf("Product %d\n",i+1);
        printf("Enter amount of packages: ");
        scanf("%d",&amount);

        printf("Enter the price: ");
        scanf("%lf",&price);

        printf("Enter Vat Category: ");
        scanf("%d",&vatCategory);


        vat = calcVat(amount,price,vatCategory);
        overalVat+=vat;

        sum += vat +((double)amount*price);
        printf("---------------------\n");

    }

    printf("Overal cost is %.2f\n",sum);
    printf("Overal vat is %.2f",overalVat);


   return 0;
}

double calcVat(int amount, double price,int vatCategory){
    double vat;

    if(vatCategory==1){
        return vat=0;
    }
    else if(vatCategory==2){
        return vat=0.06*(double)amount*price;
    }
    else if(vatCategory==3){
        return vat=0.13*(double)amount*price;
    }
    else if(vatCategory==4){
         return vat=0.19*(double)amount*price;
    }
    else{
         printf("Category doesn't exist\n");
         return vat=0;}

}
