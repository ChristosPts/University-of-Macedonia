/*Let there be two text files, “bank_new.dat” and bank_old.dat, which contain records
  with bank account information. Each record includes the last name of the account holder,
  the amount of the balance, as well as the current interest rate, and the date the account
  was "opened". The maximum name length of an account holder is 40 characters.

  Write a program that:
    1. will update an array of structures, with the depositor details from the file bank_new.dat.
       The array will have a maximum size of 100.
    2. will update a second array of structures, with the depositor details from the file bank_old.dat.
       The table will have a maximum size of 100.
    3. it will print on the screen those depositors that appear in the bank_new.dat file and do not appear
       in the bank_old.dat file. The comparison should be based on the depositor's name.
    4. it will store in a file named “mztfgm.dat” all the depositors who opened an account from 2000 and
       after from the bank_new.dat file, with the same notation as the above files.
    5. it will print on the screen 40% of the sum of the deposits of the bank_new.dat file elements,
    6. it will print on the screen 40% of the sum of the deposits of the bank_old.dat file elements,
    7. will print on the screen the name of the depositor with the largest deposit from the bank_new.dat
       file as well as the year he opened an account
    8. will print on the screen the name of the depositor with the largest deposit from the bank_old.dat
       file as well as the year he opened an account

  Use functions. All printing to the screen should be done by the main function, with appropriate return
  values from the corresponding functions */

#include <stdio.h>
#include <string.h>
#include "simpio.h"

#define N 30
#define M 100

typedef struct{
    char lastName[40];
    long balance;
    float interest;
    int year;
}AccountT;

int readInput(char inFileName[N], AccountT newData[]);
int findMissing(AccountT nData[],AccountT oData[],AccountT mData[],int nCount,int oCount);
void after2000(AccountT nData[],int nCount);
float sum40percent(AccountT data[],int count);
void maxDeposit(AccountT data[],int count,int *year, char nameMax[]);

int main(){

    AccountT newData[M],oldData[M],missingData[M];

    int newCount = readInput("bank_new.dat",newData);
    int oldCount = readInput("bank_old.dat",oldData);

    int mCount = findMissing(newData,oldData,missingData,newCount,oldCount);
     printf("Clients in List New not in Old\n");
        for(int i=0; i<mCount; i++){
            printf("--%s %ld\n",missingData[i].lastName,missingData[i].balance);
        }

    after2000(newData,newCount);
    after2000(oldData,oldCount);

    float newSum = sum40percent(newData,newCount);
    float oldSum = sum40percent(oldData,oldCount);
    printf("Expected Tax New %.2f\nExpected Tax Old %.2f\n",newSum,oldSum);


    int yearNew,yearOld;
    char nameNew[40],nameOld[40];
    maxDeposit(newData,newCount,&yearNew,nameNew);
    printf("Max in New: %s %d\n",nameNew,yearNew);

    maxDeposit(oldData,oldCount,&yearOld,nameOld);
    printf("Max in Old: %s %d\n",nameOld,yearOld);

    return 0;
}


int readInput(char inFileName[N], AccountT data[]){
    int nscan,line=0,i=0;
    char termch;
    FILE *infile;

    infile = fopen(inFileName,"r");
    if(infile == NULL){
        printf("File %s not found",inFileName);
        exit(1);
    }


    while(TRUE){
        nscan = fscanf(infile,"%40[^,], %ld, %f, %d%c",
                       data[i].lastName,&data[i].balance,
                       &data[i].interest,&data[i].year,&termch);
        line++;

        if(nscan == EOF){break;}
        if(nscan != 5 || termch != '\n'){
            printf("Problem on line %d",line);
            exit(1);
        }
        i++;
    }
    fclose(infile);
    return i;
}

int findMissing(AccountT nData[],AccountT oData[],AccountT mData[],int nCount,int oCount){
    int mCount=0,flag;

    for(int i=0; i<nCount; i++){
        flag=0;
        for(int j=0; j<oCount; j++){
            if(strcmp(nData[i].lastName,oData[j].lastName)==0){
                flag=1;
                break;
            }
        }
        if(flag==0){mData[mCount++]=nData[i];}
    }

    return mCount;
}

void after2000(AccountT nData[],int nCount){
    FILE *outfile;
    outfile = fopen("mztfgm.dat","w");

    for(int i=0; i<nCount; i++){
       fprintf(outfile,"%s, %ld, %f, %d\n",
               nData[i].lastName,nData[i].balance,
               nData[i].interest,nData[i].year);
    }

    fclose(outfile);
}

float sum40percent(AccountT data[],int count){
    int sum=0;

    for(int i=0; i<count; i++){
        sum+=data[i].balance;
    }


    return sum*0.4;
}

void maxDeposit(AccountT data[],int count,int *year, char nameMax[]){
    int max;
    max = data[0].balance;
    *year=data[0].year;

    for(int i=0; i<count; i++){
        if(max<data[i].balance){
             max = data[i].balance;
            *year = data[i].year;
            strcpy(nameMax,data[i].lastName);
        }
    }
}
