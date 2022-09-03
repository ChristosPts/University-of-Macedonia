/*Body Mass Index (BMI) is calculated from the formula B/Y^2 where B is the weight
  in kilograms and Y is the height in meters. Depending on the BMI value a person
  is classified according to the table below.

					BMI 				|	Description
			------------------------------------------------
			less than 18.5 				|	Underweight
			from 18.5 and less than 25 	|	   Normal
			from 25 and less than 30 	|    Overweight
			from 30 and over 			|	   Obese

  Write a program that will ask to enter (double) weight and (double) height, it will
  calculate the BMI and display the person's characterization (e.g. overweight). The
  program will stop when a value of 0 is given for either weight or height. The
  calculation of BMI should is implemented by a function. The results should be displayed
  from a second function.

*/


#include <stdio.h>

double calcBMI(double height, double weight);
void printResults(double BMI);

int main(){
    int amount,taxCategory;
    double height,weight;

    while(1){
        printf("Give height (in meters): ");
        scanf("%lf",&height);
        if(height==0){
            break;
        }

        printf("Give weight (in kg): ");
        scanf("%lf",&weight);
        if(weight == 0){
            break;
        }
        else
        printResults(calcBMI(height,weight));
    }


   return 0;
}

double calcBMI(double height, double weight){
    return weight/(height*height);
}

void printResults(double BMI){
    if(BMI<18.5){
        printf("Underweight\n");
    }
    else if(BMI>=18.5 && BMI<25){
        printf("Normal\n");
    }
    else if(BMI>=25 && BMI<30){
         printf("Overweight\n");
    }
    else if(BMI>=30){
         printf("Obese\n");
    }
}
