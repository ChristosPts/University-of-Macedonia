/*Write a menu-driven program that converts
  various sizes from one kind of units to another, with the help of functions:

  >function that accepts minutes (double) and returns hours (double)
  >function that accepts feet (double) and returns meters (double)
  >function that accepts degrees Celsius (double) and returns degrees Fahrenheit (double)
  >function that accepts degrees Fahrenheit (double) and returns degrees Celsius (double).

  Use a function to display the following options menu and read the user's selection
    AVAILABLE OPTIONS:
    1. CONVERT MINUTES TO HOURS
    2. CONVERT FEET TO METERS
    3. CONVERT DEGREES CELSIUS TO DEGREES FAHRENHEIT
    4. CONVERT DEGREES FAHRENHEIT TO DEGREES CELSIUS
    5. QUIT
  When the user selects one of the menu options then it will ask the corresponding value for
  conversion. The result of the conversion will be displayed in the main program and not in the function.
*/


#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

int options();
double minToHour(double y);
double fToM(double y);
double CtoF(double y);
double FtoC(double y);

int main(){

    double number;
     int x = 0;

    while (x!=5){
        x = options();
        if(x==1){
            printf("Give minutes: ");
            number = GetReal();
            printf("%.2f hours\n",minToHour(number));
        }

        if(x==2){
            printf("Give feet: ");
            number = GetReal();
            printf("%.2f meters\n",fToM(number));
        }

        if(x==3){
            printf("Give celcious: ");
            number = GetReal();
            printf("%.2f degrees\n",CtoF(number));
        }

        if(x==4){
            printf("Give farenheit: ");
            number = GetReal();
            printf("%.2f degrees\n",FtoC(number));
        }
    }
        return 0;
}

int options(){
    int x;

    printf("AVAILABLE OPTIONS:\n");
    printf("1. CONVERT MINUTES TO HOURS\n");
    printf("2. CONVERT FEET TO METERS\n");
    printf("3. CONVERT DEGREES CELSIUS TO DEGREES FAHRENHEIT\n");
    printf("4. CONVERT DEGREES FAHRENHEIT TO DEGREES CELSIUS\n");
    printf("5. QUIT\n");

    printf("Select (1-5): ");
    x = GetInteger();

    return x;
}


double minToHour(double y){
    double hours;
    hours = y/60;
    return hours;
}

double fToM(double y){
    return y*0.3048;
}

double CtoF(double y){
    return (1.8*y)+32;
}

double FtoC(double y){
    return (y-32)*5/9;
}

