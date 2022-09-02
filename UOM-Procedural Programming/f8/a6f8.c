/*For each patient of a clinic, the following information is maintained: last name (char [20]),
  first name (char [15]), address (char [30]) and payment amount (int). The above data are
  entered into a array of structures (maximum array dimension N=50).
  Write a program that will perform the following functions:
  1. Input of patient data (function parameters: array of patients, number of patients)
  2. Display all clinic patients (analytic status) (function parameters: name of clinic,
  array of patients,number of patients)
  3. Find and return the patient with the highest payment(function parameters: array of patients,
     number of patients).
  4. Calculation of the total receipts of the clinic (function parameters: array of patients,
     number of patients. Returns the total payment)
  5. Display a patient (all elements of the patient) (function parameters: the patient)
  6. Search patient (function parameters: array of patients, number of patients, the patient.
     Returns TRUE (Boolean) if the patient is found and FALSE otherwise). The search will be
	 done by the last name and first name that will be read (given by the user) inside the
	 function. The full details of the patient will be "returned" by the corresponding
	 parameter of the function.

  Check the above functions for 2 clinics eg GALINOS clinic with 3 patients and ELPIS with
  2 patients (for each clinic you will create a separate table).

*/

#include <stdio.h>
#include <string.h>
#include "genlib.h"
#include "simpio.h"

#define M 50

typedef struct{
    char lastName[20];
    char firstName[15];
    char address[30];
    int payment;
}PatientsT;

void ReadPatientInfo(PatientsT info[], int num,char name[M]);
void printPatientInfo(PatientsT info[], int num,char name[M]);

PatientsT FinMaxPatient(PatientsT info[], int num,long *sum);
void otherInfo(PatientsT max, int num,char name[M],long sum);

PatientsT findPatient(PatientsT info[], int num, char name[M]);
void printPatientSearch(PatientsT search);

int main(){

    PatientsT hospital1[M],hospital2[M], maxH1,maxH2,searchH1,searchH2;
    int h1,h2;
    long sum1,sum2;

    printf("Total patients for GALINOS: ");
    scanf("%d",&h1);
    printf("Total patients for ELPIS: ");
    scanf("%d",&h2);

    ReadPatientInfo(hospital1,h1,"GALINOS");
    ReadPatientInfo(hospital2,h2,"ELPIS");

    printPatientInfo(hospital1,h1,"GALINOS");
    maxH1 = FinMaxPatient(hospital1,h1,&sum1);
    otherInfo(maxH1,h1,"GALINOS",sum1);


    printPatientInfo(hospital2,h2,"ELPIS");
    maxH2 = FinMaxPatient(hospital2,h2,&sum2);
    otherInfo(maxH2,h2,"ELPIS",sum2);

    searchH1 = findPatient(hospital1,h1,"GALINOS");
    printPatientSearch(searchH1);

    searchH2 = findPatient(hospital2,h2,"ELPIS");
    printPatientSearch(searchH2);


    return 0;
}

void ReadPatientInfo(PatientsT info[], int num,char name[M]){

    printf("---- %s ----\n",name);
    for(int i=0; i<num; i++){
        printf("Give data patient %d\n",i);

        printf("Last Name: ");
        getchar();
        gets(info[i].lastName);

        printf("First Name: ");
        gets(info[i].firstName);

        printf("Address: ");
        gets(info[i].address);

        printf("Amount: ");
        scanf("%d",&info[i].payment);
        printf("-------------------\n");
     }

}

void printPatientInfo(PatientsT info[], int num,char name[M]){

    printf("\n--------|%s|--------\n",name);
    printf("%-20s %-15s %-30s %+10s\n","Last Name","First Name","Address","Amount");

    for(int i=0; i<80; i++) printf("-");
    printf("\n");

    for(int i=0; i<num; i++){
        printf("%-20s %-15s %-30s %10d\n",
                info[i].lastName,info[i].firstName,
                info[i].address,info[i].payment);
    }
     for(int i=0; i<80; i++){printf("-");}
     printf("\n");

}


//Calculate sum of payments and find which patient payed the most
PatientsT FinMaxPatient(PatientsT info[], int num,long *sum){
    PatientsT maxPatient = info[0];
    *sum = 0;

    for(int i=0; i<num; i++){
       //largest payment
       if(maxPatient.payment<info[i].payment){
        maxPatient=info[i];
       }
       //sum of payments
        (*sum) += info[i].payment;
    }
    return maxPatient;
}


void otherInfo(PatientsT max, int num,char name[M],long sum){
    printf("Max Payment in %s from: \n",name);
    printf(">%s: %s\n>%s %s\n>%s %s\n>%s %d\n",
           "Last Name",max.lastName,
           "First Name",max.firstName,
           "Address",max.address,
           "Amount",max.payment);

     printf("-Total Income in %s: %ld\n",name,sum);
}

PatientsT findPatient(PatientsT info[], int num, char name[M]){
     PatientsT search;
     search = info[0];

     printf("\nSearch for Patient in %s\n",name);
     printf("Last name: ");
     getchar();
     gets(search.lastName);
     printf("First name: ");
     gets(search.firstName);

     for(int i=0; i<num; i++){
        if((strcmp(search.lastName,info[i].lastName)==0) && (strcmp(search.firstName,info[i].firstName)==0)){
            search = info[i];
            return search;
        }
        else printf("patient not found\n");
     }
        return search;
}

void printPatientSearch(PatientsT search){
    printf("\n%-20s %-15s %-30s %+10s\n","Last Name","First Name","Address","Amount");

    for(int i=0; i<80; i++) printf("-");
    printf("\n");

        printf("%-20s %-15s %-30s %10d\n",
                search.lastName,search.firstName,
                search.address,search.payment);
     for(int i=0; i<80; i++){printf("-");}
     printf("\n");

}
