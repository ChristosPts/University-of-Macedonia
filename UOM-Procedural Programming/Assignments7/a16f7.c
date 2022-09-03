/*Write a program that will accept an alphanumeric character up to 99 characters (you will declare a
  table of 100 characters) and display the digits contained within the alphanumeric and their sum.
  If there is no digit, then the message "No digits in input" is displayed.*/

#include<stdio.h>
#include<string.h>
#include<ctype.h>

int main(){
    char str[100];
    int sum=0,x=0;
    int a[100];

    printf("Insert a String: ");
    gets(str);

        for(int i=0;str[i] != '\0';i++){
            if(isdigit(str[i])){
                a[x]= str[i] - 48;
                x++;
            }
        }

        for(int i=0;i<x;i++){
            sum+=a[i];
        }
        if(x==0){
            printf("No digits in input.");
        }
        else {
            for(int i=0;i<x-1;i++){
                printf("%d + ",a[i]);
            }
             printf("%d",a[x-1]);
			 printf(" = %d",sum);
        }
   return 0;
}
