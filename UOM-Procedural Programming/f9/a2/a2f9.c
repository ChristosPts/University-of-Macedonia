/*Given the text file 'i2f9.dat' of the students of a school that includes the following
  information for each student:
   - student name, which cannot contain more than 30 characters
   - number of absences (int)
   - various student details, which cannot exceed 68 characters

  The above data for each student are separated by commas.
  Make a program that will create from the student file 'i2f9.dat' the text file 'o2f9.dat'
  with the students with more than 100 absences. The text file 'o2f9.dat' will contain the
  first and last name (30 characters) and the number of absences (int) of each student whose
  absences exceed 100. Finally, it will contain the number of all students in the school as
  well as the number of students in the school whose absences exceed 100.

  The program will:
    > open the input file 'i2f9.dat' in the main program (function main())
    > read the contents of the input file and stores them appropriately in an array of
      structures (maximum size 100), via a readInput function. Parameters of the function
      the file, the array of structures, the number of all students of the school, the
      number of students of the school whose absences exceed 100.
    > create a second text (output) file named 'o2f9.dat' in the main program
    > save in the output file 'o2f9.dat' the details of students with absences as described
    above. Saving is done via the writeOutput function. Function parameters the file , the
    current size of the struct array , the struct array , the amount of all students.

  The data will be recorded in the file 'o2f9.dat' according to the following alignment-format:

                                                     (1-30)              (31-39)
                                                  ONOMATEPWNYMO          APOYSIES
                                                  PAPANIKOLAOU KWSTAS         115
                                                  ...............................
                                                  -------------------------------
                                                  SYNOLO MATHITWN:              8
                                                  SYNOLO APONTWN:               5


*/

#include <stdio.h>
#include <string.h>
#include "simpio.h"

#define M 100
#define N 30

typedef struct{
    char name[30];
    int absences;
    char rand_info[68];
}InfoT;

int readInput(InfoT students[],FILE *infile, int *studentSum,int *abs);
void writeToFile(InfoT students[],FILE *outfile,int sum, int abs);

int main(){

    int sum,absences;

    InfoT students[M];

    FILE *infile;
    FILE *outfile;
    char inName[N] = "i2f9.dat";

    infile = fopen(inName,"r");
    if(infile == NULL){
        printf("File %s not found",inName);
        exit(1);
    }

    readInput(students,infile,&sum,&absences);

    outfile=fopen("o2f9.dat","w");
    writeToFile(students,outfile,sum,absences);

    fclose(infile);
    fclose(outfile);

    return 0;
}

int readInput(InfoT students[],FILE *infile, int *studentSum,int *abs){
    int nscan,i=0,line=0,absence;
    char termch,sName[30],rInfo[68];
    *studentSum=0;
    *abs=0;

    while(TRUE){
        nscan = fscanf(infile,"%30[^,],%ld,%68[^\n]%c",sName,&absence,rInfo,&termch);
        line++;
        if(nscan == EOF){break;}
        if(nscan != 4 || termch !='\n'){
            printf("Problem on line %d",line);
            exit(1);
        }
        if(absence>100){
            strcpy(students[*abs].name,sName);
            strcpy(students[*abs].rand_info,rInfo);
            students[*abs].absences = absence;
            (*abs)++;
        }
        (*studentSum)++;
    }
}

void writeToFile(InfoT students[],FILE *outfile,int sum, int abs){

     fprintf(outfile,"%-30s %+9s\n","ONOMATEPWNYMO","APOYSIES");
     for(int i=0; i<40; i++){fprintf(outfile,"-");}
     fprintf(outfile,"\n");
     for(int i=0; i<abs; i++){
         fprintf(outfile,"%-30s %9d\n",students[i].name,students[i].absences);
     }
     for(int i=0; i<40; i++){fprintf(outfile,"-");}
     fprintf(outfile,"\n");
     fprintf(outfile,"%-30s %9d\n","SYNOLO MATHITWN:",sum);
     fprintf(outfile,"%-30s %9d\n","SYNOLO APONTWN:",abs);

}


