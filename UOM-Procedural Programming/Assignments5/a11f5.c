/*E.M.Y. records every 8 hours the temperatures of 10 cities in Greece (the names of the cities are
  coded with numbers: 0=Thessaloniki, 1=Athens etc). Write a program that will read the
  temperatures(double) of a twenty-four hour period for each city then calculate and display:
  >the national average temperature (double type variable) and
 > for each city its average temperature and its maximum deviation from the national average
  (variables of type double).

 The results should appear in the following format:
  national average temperature
  City 0 city 0 average temperature_city 0's maximum deviation from the national average
  City 1 1st city average temperature_1st city's maximum deviation from the national average
  ......................................
  City 9 average city 9 temperature_maximum deviation of the 9th city from the national average*/

#include <stdio.h>
#include "stdlib.h"
#include "math.h"

#define CITIES 10
#define PERIODS 3


void ReadData(double temps[CITIES][PERIODS]);
double CalculateAverage(double temps[CITIES][PERIODS]);
void CalculateCity(double temps[CITIES][PERIODS], double average[]);
void CalculateMaxDeviation(double natavg, double average[], double deviation[]);
void Print(double natavg, double average[], double deviation[]);


int main(){

    double temps[CITIES][PERIODS], nationalAvg, cityAvg[CITIES], deviation[CITIES];

    ReadData(temps);
    nationalAvg = CalculateAverage(temps);
    CalculateCity(temps,cityAvg);
    CalculateMaxDeviation(nationalAvg,cityAvg,deviation);
    Print(nationalAvg,cityAvg,deviation);

    return 0;
 }


void ReadData(double temps[CITIES][PERIODS]){
    for(int i=0; i<CITIES; i++){
        for(int j=0; j<PERIODS; j++){
        printf("Temp of City %d During %d 8-hour period: ",i,j);
        scanf("%lf",&temps[i][j]);
        }
    }
}

double CalculateAverage(double temps[CITIES][PERIODS]){
    double natAvg;
    for(int i=0; i<CITIES; i++){
        for(int j=0; j<PERIODS; j++){

        natAvg += temps[i][j];
        }
    }
    natAvg/=CITIES*PERIODS;
    return natAvg;
}

void CalculateCity(double temps[CITIES][PERIODS], double average[]){

    for(int i=0; i<CITIES; i++){
        average[i]=0;
        for(int j=0; j<PERIODS; j++){
             average[i]+=temps[i][j]/PERIODS;
        }
     }

}

void CalculateMaxDeviation(double natavg, double average[], double deviation[]){
     for(int i=0; i<CITIES; i++){
        for(int j=0; j<PERIODS; j++){
             deviation[i] = fabs(average[i] - natavg);
        }
     }
}


void Print(double natavg, double average[], double deviation[]){
      printf("National average temperature: %.1f\n",natavg);
       for(int i=0; i<CITIES; i++){
        printf("City %d: %2.1f | Deviation: %2.1f \n",i,average[i],deviation[i]);
       }
}


