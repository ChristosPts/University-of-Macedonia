/*Write a program that will accept an amount of money in € and display the converted value of the money.
  Use the following rates:
    1 US dollar = 0,89 €
    1 British Pound = 0,618 €
    1 Swiss Franks = 1,5465 €
    1 Canadian Dollars = 1,3565 €
    1 Yen = 109,22 €

  The program will be developed using:
  a)function to display the following menu and read the user's choice (int), which will be returned by the function

    1. Convert to American Dollars
    2. Convert to British Pound
    3. Convert to Swiss Franks
    4. Convert to Canadian Dollars
    5. Convert to Yen
    6. Exit

  b)function that will accept as input the user's choice and the amount in € (double) and will
  return the value (double) in the currency selected by the user.
  The amount in € and the display of its value in the currency chosen by the user will be done by the main
  program.*/


#include <stdio.h>

int menu();
float convert(int choice,float amount);

int main(){
   int choice;
  float amount;

   while(1){
    choice = menu();
    if(choice == 6){ break;}

    if(choice <1 || choice >6 ){
        printf("Wrong input, please try again \n");
    }
    else if(choice >=1 || choice <=6 ){
        printf("Give amount to convert: ");
        scanf("%f",&amount);
        float conversion = convert(choice,amount);
        printf("%.3f\n",conversion);
    }
   }

   return 0;
}

int menu(){
    int num;

    printf("1. Convert to American Dollars\n");
    printf("2. Convert to British Pound\n");
    printf("3. Convert to Swiss Franks\n");
    printf("4. Convert to Canadian Dollars\n");
    printf("5. Convert to Yen\n");
    printf("6. Exit\n");

    printf("Select (1-6): ");
    scanf("%d",&num);

   return num;

}

float convert(int choice,float amount){

    if(choice == 1){
        return amount*0.89;
    }
    else if(choice == 2){
        return amount*0.618;
    }
    else if(choice == 3){
        return amount*1.5465;
    }
    else if(choice == 4){
        return amount*1.3565;
    }
    else if(choice == 5){
        return amount*109.2;
    }


}
