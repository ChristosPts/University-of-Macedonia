/*The text file 'i12f9.dat' of salaries is given with the following information:
   - VAT number (long)
   - Name (up to 28 characters)
   - Annual Remuneration (float)
  The above employee details are separated by commas. A second text file named
  'Foro12f9.dat' is requested to be created and formatted as shown below, containing
  the VAT number, full name and tax to be paid by each taxpayer.

  The amount of tax that must be paid is proportional to the amount of the salary and the tax scale to which it belongs (taxes are calculated on the total amount):
   - if amount <=10,000, then 14% tax
   - if amount >10,000 and <=23,000, then 19% tax
   - if amount >23,000 and <=55,000, then 23% tax
   - if amount >55,000, then 28% tax

  The program to be developed will:
  (a) open the input file ('i12f9.dat') in the main program (function main())
  (b) read the contents of the input file and store them in an appropriate array
      of structures (maximum size 100), via a readDataFromFile function
  (c) creates a second text (output) file named 'Foro12f9.dat' in the main program
  (d) save in the output file 'Foro12f9.dat' the details of the taxpayers, their tax
      and the total tax. Saving is done via the writeToFile function
  Note: more functions can be created if needed

  The format of the output file:
  AFM      ONOMATEPWNYMO                    FOROS
 ------------------------------------------------
 245987653 Dimitriadou Sonia              4180.00
 254687954 Salonikidis Apostolis          2850.00
 655436367 Papadakis Gerasimos            6440.00
 233432245 Makridou Theano                1372.00
 112223345 Pantelidis Giorgos            17080.00
 234233423 Akritidou Maria                7590.00
 233244456 Kalfa Panagiota                4085.00
 465738399 Stoltidis Mpampis              2432.00
 242342323 Paraskevas Dimitris            3420.00
 544333352 Kiritsi katerina              10120.00
 ------------------------------------------------
 SYNOLO FOROY                            59569.00

*/


#include <stdio.h>
#include <string.h>
#include "simpio.h"

#define N 30
#define M 100

typedef struct{
    long AFM;
    char name[28];
    float salary;
}InfoT;

int readDataFromFile(InfoT taxPayers[],FILE *infile);
float calcTaxes(InfoT taxPayers[], int count, float taxArray[]);
void writeToFile(InfoT taxPayers[], int count, float taxArray[],float sum,FILE *outfile);

int main(){

    InfoT taxPayers[M];

    FILE *infile;
    FILE *outfile;
    char inName[N] = "i12f9.dat";


    infile = fopen(inName,"r");
    if(infile == NULL){
        printf("File %s not found",inName);
        exit(1);
    }

    int count = readDataFromFile(taxPayers,infile);
    float taxArray[count],sum;

    outfile = fopen("Foro12f9.dat","w");
    sum = calcTaxes(taxPayers,count,taxArray);

    writeToFile(taxPayers,count,taxArray,sum,outfile);


    fclose(infile);
    fclose(outfile);

    return 0;
}


int readDataFromFile(InfoT taxPayers[],FILE *infile){
    int nscan,line=0,i=0;
    char termch;

    while(TRUE){
        nscan = fscanf(infile,"%ld,%28[^,],%f%c",
                       &taxPayers[i].AFM,taxPayers[i].name,
                       &taxPayers[i].salary,&termch);
        line++;

        if(nscan == EOF){break;}
        if(nscan != 4 || termch != '\n'){
            printf("Problem on line %d",line);
            exit(1);
        }
        i++;
    }

    return i;
}

float calcTaxes(InfoT taxPayers[], int count, float taxArray[]){
    float sum=0;

    for(int i=0; i<count; i++){
            taxArray[i]=0;
        if(taxPayers[i].salary<=10000){
            taxArray[i] = taxPayers[i].salary*0.14;
        }
        if(taxPayers[i].salary>10000 && taxPayers[i].salary<=23000 ){
            taxArray[i] = taxPayers[i].salary*0.19;
        }
        if(taxPayers[i].salary>23000 && taxPayers[i].salary<=50000 ){
            taxArray[i] = taxPayers[i].salary*0.23;
        }
        if(taxPayers[i].salary>50000){
            taxArray[i] = taxPayers[i].salary*0.28;
        }
        sum+=taxArray[i];
    }
    return sum;
}

void writeToFile(InfoT taxPayers[], int count, float taxArray[],float sum,FILE *outfile){

    fprintf(outfile,"%-10s %-28s %+9s\n","AFM","ONOMATEPWNYMO","FOROS");
    for(int i=0; i<50; i++){
        fprintf(outfile,"-");
    }
    fprintf(outfile,"\n");

    for(int i=0; i<count; i++){
       fprintf(outfile,"%ld %-28s %10.2f\n",taxPayers[i].AFM,taxPayers[i].name,taxArray[i]);
    }

    for(int i=0; i<50; i++){
        fprintf(outfile,"-");
    }
    fprintf(outfile,"\n");
    fprintf(outfile,"%-38s %10.2f","SYNOLO FOROY",sum);

}
