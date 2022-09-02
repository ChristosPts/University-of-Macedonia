/*A shipping company carries household appliances of standard size and uses specifically
containers each of which holds 1, 5, 20 or 50 household appliances. Write a
program which accepts the given number of household appliances to be transported, 
and calculates and displays the required number of transport boxes for each
size so that the transfer is carried out in the most economical way (the least possible
number of shipping boxes without unused space).*/

#include <stdio.h>

int main(){
     int num,cont50,cont20,cont5,cont1,remainder;

     printf("Give amount of devices:");
     scanf("%d",&num);

     cont50 = num/50;
     printf("50: %d\n",cont50);
     remainder = num-cont50*50;

     cont20 = remainder/20;
     printf("20: %d\n",cont20);

     remainder = num-cont20*20-cont50*50;

     cont5 = remainder/5;
     printf("5: %d\n",cont5);

     remainder = num-cont5*5-cont20*20-cont50*50;
     cont1 = remainder/1;
     printf("1: %d",cont1);


   return 0;
}
