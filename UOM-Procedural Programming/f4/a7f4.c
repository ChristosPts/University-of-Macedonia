/*Write a program that will read the values ​​of 2 integer variables x,y and contain the following functions:

  >int add(int x, int y)
  >int sub(int x, int y)
  >int mult(int x, int y)
  >int divd(int x, int y) (if the denominator is 0 it will return the value 0)

  which will respectively calculate the sum, the difference, the product and the integer quotient of two
  whole numbers. Finally, calculate the values ​​of:

  mult(add(x,y), sub(y, divd(x,y)) and
  divd(sub(mult(x, y), x), add(x, y)).

  The main program will display the values ​​of the above functions in the corresponding order.*/

#include <stdio.h>

int add(int x,int y){
    return  x+y;
}

int sub(int x,int y){
    return x-y;
}

int mult(int x,int y){
    return x*y;
}

int divd(int x,int y){
     if(y==0){
        return 0;
     }
     else
    return x/y;
}

int main(){
    int x,y;

    printf("Enter x: ");
    scanf("%d",&x);
    printf("Enter y: ");
    scanf("%d",&y);

    printf("add: %d\n", add(x,y));
    printf("sub: %d\n", sub(x,y));
    printf("mult: %d\n", mult(x,y));
    printf("divd: %d\n", divd(x,y));
    printf("exp1: %d\n",  mult(add(x,y),sub(y,divd(x,y))));
    printf("exp2: %d", divd(sub(mult(x, y),x),add(x, y)));

    return 0;

}

