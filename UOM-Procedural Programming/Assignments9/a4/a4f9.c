/*Given the text file 'i4f9.dat' of a company's salespeople with the following information:
   > vendor code (11 or 12 or 13 or 14) (int)
   > seller name (maximum 25 characters)
   > value of goods sold by the seller (long)

  The above information for each seller is separated by a comma. It is requested to create
  a second text file named 'o4f9.dat' and notation: seller name( 1-24 )commission amount(25-31)
  The seller's commission amount is proportional to their code:
	- if code = 11 then commission rate = 3%
	- if code = 12 then commission rate = 5%
	- if code = 13, then commission rate = 8%
	- if code = 14 then commission rate = 11%
*/

#include <stdio.h>
#include <string.h>
#include "simpio.h"

#define N 30
#define M 100

typedef struct{
    int sellerCode;
    char name[25];
    long price;
}InfoT;

int readInfo(InfoT sellers[],FILE *infile);
void calcCommission(InfoT sellers[],int count,long comArray[]);
void writeToFile(InfoT sellers[],FILE *outfile,int count,long comArray[]);

int main(){

    InfoT sellers[M];

    FILE *infile;
    FILE *outfile;
    char inName[N] = "i4f9.dat";

    infile = fopen(inName,"r");
    if(infile == NULL){
        printf("File %s not found",inName);
        exit(1);
    }

    int sellerCount = readInfo(sellers,infile );

    long comArray[sellerCount];
    calcCommission(sellers,sellerCount,comArray);

    outfile=fopen("o4f9.dat","w");
    writeToFile(sellers,outfile,sellerCount,comArray);


    fclose(infile);
    fclose(outfile);

    return 0;
}

int readInfo(InfoT sellers[],FILE *infile){
    int nscan,i=0,line=0;
    char termch;


    while(TRUE){
        nscan = fscanf(infile,"%d,%25[^,],%ld%c",&sellers[i].sellerCode,
                       sellers[i].name,&sellers[i].price,&termch);
         line++;

        if(nscan == EOF){break;}
        if(nscan != 4 || termch !='\n'){
            printf("Problem on line %d",line);
            exit(1);
        }
        i++;
    }
    return i;
}

void calcCommission(InfoT sellers[],int count,long comArray[]){

    for(int i=0; i<count; i++){
        comArray[i] = 0;
        if(sellers[i].sellerCode == 11){
            comArray[i]=sellers[i].price*0.03;
        }
        else if(sellers[i].sellerCode == 12){
            comArray[i]=sellers[i].price*0.05;
        }
        else if(sellers[i].sellerCode == 13){
            comArray[i]=sellers[i].price*0.08;
        }
        else if(sellers[i].sellerCode == 14){
            comArray[i]=sellers[i].price*0.11;
        }
    }

}

void writeToFile(InfoT sellers[],FILE *outfile,int count,long comArray[]){

     fprintf(outfile,"%-24s %7s\n","Seller Name","Commission");
     for(int i=0; i<35; i++){fprintf(outfile,"-");}
     fprintf(outfile,"\n");
     for(int i=0; i<count; i++){
         fprintf(outfile,"%-24s %10ld\n",sellers[i].name,comArray[i]);
     }

}
