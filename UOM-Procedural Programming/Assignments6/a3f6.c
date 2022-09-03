/*Write a program that will read three integer variables A, B, C, and will sort them 
  in ascending order alternating their values between variables using the swap(x,y) function, 
  so that A<B<C. Finally it will display them sorted values of variables A, B and C. 
  The function swap(int *x, int *y) will compare and swap the values of 2 integer variables x and y 
  (the value of x will be given to the variable y and the value of y to x).*/

#include <stdio.h>

void swap(int *x, int *y);

int main(){

    int A,B,C;

    printf("Give A: ");
    scanf("%d",&A);
    printf("Give B: ");
    scanf("%d",&B);
    printf("Give C: ");
    scanf("%d",&C);

    swap(&A,&B);
    swap(&A,&C);
    swap(&B,&C);

    printf("%d<%d<%d",A,B,C);

    return 0;
}

void swap(int *x, int *y){
    int k;
    if(*x>*y){
        k=*x;
        *x=*y;
        *y=k;
    }
}
