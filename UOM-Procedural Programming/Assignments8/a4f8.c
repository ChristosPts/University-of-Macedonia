/*In a post office various shipments are registered every day. For each shipment the following information is given:
   - Firstname (char[26])
   - Recipient address (street and number,char[26])
   - Post Code (long)
   - City (char[16])
   - Country (char[16])
   - Parcel type (1 internal, 2 external) (int)
   - Weight (long)
  
  Write a program that will perform the following functions:
  1. Enter the number (int) M of the postal items.
  2. Input the data of M mails into a function.
  3. Calculation of parcel numbers (int) and total domestic and foreign amounts (double) in a function.
  4. Show parcel numbers and total domestic and foreign amounts in one function.
  
  The data of the M mailings will be stored in a one-dimensional array of N records
  (array dimension N=20 and M<=N). For the calculation of shipping amounts take into account that one
  kilo costs €0.40 for domestic parcels and €0.84 for international parcels.
  
 */


#include <stdio.h>
#include "simpio.h"
#include <string.h>

#define M 100

typedef struct{
    char name[26];
    char reciepient[26];
    long postcode;
    char city[16];
    char country[16];
    int packageType;
    long weight;
}PostsT;

void packageInputs(PostsT packages[], int num);
void calcPackages(PostsT packages[], int num, int *sumDom,int *sumFor, double *pricetDom, double *priceFor);
void printCalc(int sumDom,int sumFor, double pricetDom, double priceFor);
void search(PostsT packages[],int num);

int main(){
    PostsT packages[M];

    int num;
    int sumDomestic,sumForeign;
    double pricetDom, priceFor;

    printf("Give ammount of packages: ");
    scanf("%d",&num);

    packageInputs(packages,num);
    calcPackages(packages,num,&sumDomestic,&sumForeign,&pricetDom,&priceFor);
    printCalc(sumDomestic,sumForeign,pricetDom,priceFor);
    search(packages,num);

    return 0;
}

void packageInputs(PostsT packages[], int num){
    printf("--------------------\n");
    for(int i=0; i<num; i++){
        printf("Package num: %d\n",i+1);
        packages[i].packageType=0;
        printf("Name: ");
        getchar();
        gets(packages[i].name);

        printf("Address: ");
        getchar();
        gets(packages[i].reciepient);

        printf("Zip: ");
        scanf("%d",&packages[i].postcode);

        printf("City: ");
        getchar();
        gets(packages[i].city);

        printf("Country: ");
        getchar();
        gets(packages[i].country);

        while(packages[i].packageType!=1 && packages[i].packageType!=2){
            printf("Type <1 or 2>: ");
            scanf("%d",&packages[i].packageType);
        }

        printf("Weight: ");
        scanf("%ld",&packages[i].weight);
        printf("--------------------\n");

    }


}

void calcPackages(PostsT packages[], int num, int *sumDom,int *sumFor, double *pricetDom, double *priceFor){
      *sumDom=0;
      *sumFor=0;
      *pricetDom=0;
      *priceFor=0;
          for(int i=0; i<num; i++){
            if(packages[i].packageType == 1){
                (*sumDom)++;
                 *pricetDom += ((double)packages[i].weight)*0.4;
            }
            else{
                (*sumFor)++;
                *priceFor += ((double)packages[i].weight)*0.84;
            }

        }

}

void printCalc(int sumDom,int sumFor, double pricetDom, double priceFor){
    printf("Number of Domestic Packages %d, Shipping ammount %.2f\n",sumDom,pricetDom);
    printf("Number of Foreign Packages %d, Shipping ammount %.2f",sumFor,priceFor);
}


void search(PostsT packages[],int num){
    char name[26];
    printf("Search for package(give Name):");
    getchar();
    gets(name);

     for(int i=0; i<num; i++){
        if(strcmp(name,packages[i].name)==0){
            printf("Name: %s\nAdress: \nCity: Country:",packages[i].country);
            break;
        }


        else printf("not found");
     }


}
