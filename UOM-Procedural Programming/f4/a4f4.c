/*Write a program that reads the values of three integers a,b,c and calculates and displays
  the value of the following expression y=(2*max(a,b)+3*gr(a,b,c))/4.

  >max(a,b) returns the maximum of the numbers a and b
  >gr(a,b,c) returns the maximum of the numbers a,b and c

  Reading the three numbers and the display of y will be done in the main program.
  The result will be displayed with 2 decimal places*/


#include <stdio.h>

int max(int a,int b);
int gr(int a,int b,int c);

int main(){
    int a,b,c;
    float y;

    printf("Insert a: ");
    scanf("%d",&a);
    printf("Insert b: ");
    scanf("%d",&b);
    printf("Insert c: ");
    scanf("%d",&c);

    y = (2*max(a,b)+ 3*gr(a,b,c))/4;
    printf("y = %.2f",y);

   return 0;
}


int max(int a,int b){
    if(a>b)
       return a;
     else
        return b;
}

int gr(int a,int b,int c){
    if(a>b && a>b){
        return a;
    }
    else if(b>a && b>c){
        return b;
    }
    else return c;
}
