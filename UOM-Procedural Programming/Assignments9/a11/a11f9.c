/*Given a text file 'i11f9.dat' of the points of a basketball team with the following information:
   -player number (int)
   -Player name (max 28 characters)
   -Number of points scored in the match
  The above data for each player are separated by commas. It is requested to develop a program which:
	(a) "opens" the input file ('i11f9.dat') in the main program (function main())
	(b) reads the contents of the input file and stores them in a structure array (maximum size 100),
	    via a readFromFile function,
	(c) creates a second text (output) file named 'baso11f9.dat' in the main program
	(d) saves in the output file the name and number of points of each player. Also the total points of
	    all players as well as the number of players who have more than 10 points. Saving is done via the
	    writeToFile function.
	(e) "closes" the input and output files

  After running the program the output file should contain the following content:
    	ONOMATEPWNYMO 		     PONTOI
	-----------------------------------
	Giannis Petridis 		12
	Spiros Papaloukas		 4
	Dakis Lelos 			 1
	Giorgos Pasas 			15
	Dimitris Dimitriou 		11
	Aggelos Kanlis 			12
	Giannis Samaras 		 5
	Charis louloukos 		 3
	Kostas Mpakas 			 1
	Petros Papadopoulou 		 1
	-----------------------------------
	SYNOLO PONTWN 			65
	SYNOLO PAIKTVN >= 10 		 4

*/

#include <stdio.h>
#include <string.h>
#include "simpio.h"

#define N 30
#define M 100

typedef struct{
    int playerNum;
    char name[28];
    int points;
}InfoT;

int readInfo(InfoT scores[],FILE *infile,int *pointSum, int *over10);
void writeToFile(InfoT scores[],FILE *outfile,int sum, int over10,int count);

int main(){

    InfoT scores[M];

    FILE *infile;
    FILE *outfile;
    char inName[N] = "i11f9.dat";

    infile = fopen(inName,"r");
    if(infile == NULL){
        printf("File %s not found",inName);
        exit(1);
    }

    int sum,over10;
    int playerCount = readInfo(scores,infile,&sum,&over10);

    outfile=fopen("baso11f9.dat","w");

    writeToFile(scores,outfile,sum,over10,playerCount);

    fclose(infile);
    fclose(outfile);

    return 0;
}

int readInfo(InfoT scores[],FILE *infile,int *pointSum, int *over10){
    int nscan,i=0,line=0;
    char termch;
    *pointSum=0;
    *over10=0;

    while(TRUE){
        nscan = fscanf(infile,"%d,%28[^,],%d%c",&scores[i].playerNum,
                       scores[i].name,&scores[i].points,&termch);
         line++;

        if(nscan == EOF){break;}
        if(nscan != 4 || termch !='\n'){
            printf("Problem on line %d",line);
            exit(1);
        }
        i++;
    }

    for(int j=0; j<i; j++){
        *pointSum+=scores[j].points;
        if(scores[j].points>10){
            (*over10)++;
        }
    }

    return i;
}

void writeToFile(InfoT scores[],FILE *outfile,int sum, int over10, int count){

     fprintf(outfile,"%-28s %+11s\n","ONOMATEPWNYMO","PONTOI");
     for(int j=0; j<40; j++){fprintf(outfile,"-");}
     fprintf(outfile,"\n");
     for(int j=0; j<count; j++){
         fprintf(outfile,"%-28s %11d\n",scores[j].name,scores[j].points);
     }
     for(int j=0; j<40; j++){fprintf(outfile,"-");}
     fprintf(outfile,"\n");
     fprintf(outfile,"%-28s %11d\n","SYNOLO PONTWN",sum);
     fprintf(outfile,"%-28s %11d\n","SYNOLO PAIKTVN >= 10",over10);

}
