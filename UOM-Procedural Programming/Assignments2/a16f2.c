/*A mobile phone company charges for SMS according to the following table:
                           
                            SMS Ammount       | Price per SMS
                           -----------------------------------
                            the first 10      | 2 cent
                            the next 50       | 1,5 cent
                            the next 100      | 1,2 cent
                            all the following | 1 cent
                            
  Write a program that asks the user to enter the number of SMS(int) we sent, calculate and display in Euros, 
  the total amount we have to pay.*/           

#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

int main (){
    int num;
    float price,payment;

    printf("Give number of messages: ");
    scanf("%d",&num);

    if(num >=0 && num<11){
        price = 0.02*num;
    }
    else if(num >10 && num<=60){
        price = (10*0.02)+0.015*(num-10);
    }
    else if(num >60 && num<=160){
        price = (10*0.02)+(50*0.015)+0.012*(num-60);
    }
    else if(num>160){
        price = (10*0.02) + (50*0.015) + (100*0.012) + 0.01*(num-160);
    }

    printf("price of messages in euro: %f",price);

 return 0;
}

