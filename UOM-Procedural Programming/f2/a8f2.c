/*The vice president of an airline wants to calculate whether the estimates for the time (minutes) 
  required for each flight are reliable or not. It considers the  predicted time of 
  each flight and calculates its difference from the actual time. The longer the predicted 
  time of a flight, the greater the deviation from it can be. It therefore the predicted 
  time is considered as too short, acceptable or too long according to the  following table:
  
                          Predicted flight time       Acceptable difference
                                30-59                           2
                                60-89                           3
                                90-119                          4
                                120-179                         6
                                180-239                         8
                                240-359                         13
                                360 and above                   17
  
  Write a program that will read a predicted time (int) and an actual time (int) and display the accepted 
  difference (int) (according to the table above), the difference of the entered values (int) and the 
  corresponding display ' BIG' (if the forecast time is greater than the acceptable forecast time), 
  'SMALL' (if the forecast time is less than the acceptable forecast time) or 'GOOD' (if the difference 
  we calculated is within the acceptable difference). There is no need to check if the predicted time and 
  the actual time are less than 0, i.e. we consider that the user gives valid values >=0.
*/


#include <stdio.h>
#include "genlib.h"
#include "math.h"

int main(){
   int estimatedTime,realTime,apodextiDiafora,diaforaEisodou;

    printf("Problepomenos xronos: ");
    scanf("%ld",&estimatedTime);

     printf("real xronos: ");
    scanf("%ld",&realTime);

    if(estimatedTime<30){
        apodextiDiafora = 1;
    }
    else if(estimatedTime>=30 && estimatedTime<60){
         apodextiDiafora = 2;
    }
    else if(estimatedTime>=30 && estimatedTime<60){
          apodextiDiafora = 3;
    }
    else if(estimatedTime>=60 && estimatedTime<120){
         apodextiDiafora = 4;
    }
    else if(estimatedTime>=120 && estimatedTime<180){
         apodextiDiafora = 6;
    }
    else if(estimatedTime>=180 && estimatedTime<240){
         apodextiDiafora = 8;
    }
    else if(estimatedTime>=240 && estimatedTime<360){
         apodextiDiafora = 13;
    }
    else if(estimatedTime>=360 ){
         apodextiDiafora = 17;
    }

    diaforaEisodou = estimatedTime - realTime;
    printf("Aodexti Diafora: %d\n",apodextiDiafora);
    printf("Diafora isodou: %d\n",diaforaEisodou);

    if(fabs(diaforaEisodou)==apodextiDiafora ){
          printf("GOOD");
    }
    else if( diaforaEisodou<apodextiDiafora ){
          printf("SMALL");
    }
    else if( diaforaEisodou>apodextiDiafora ){
          printf("BIG");
    }



   return 0;
}
