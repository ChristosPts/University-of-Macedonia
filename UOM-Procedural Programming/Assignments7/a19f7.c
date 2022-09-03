/*Write a program that:
  1. will request 5 names and will enter them in an appropriate character table. We consider
     that any of the names is a maximum of 19 characters.  It will then prompt the user for a character
  2. it will find the names starting with the given character
  3. it will display how many names start with the given character and display them
  Using functions is optional:*/

#include<stdio.h>
#include<string.h>
#include <stdlib.h>
#include<ctype.h>

int main(){
     int i,count=0;
     char info[5][19],ch,str[5][19];

     for( i=0;i<5; i++){
        printf("Give name %d: ",i);
        gets(info[i]);
     }

     printf("\nGive initial char: ");
     scanf("%c",&ch);

     for(i=0;i<5;i++){
       if(info[i][0]==ch){
         count++;
       }
     }

        printf("\nNames starting with %c are %d:",ch,count);

     for(i=0;i<5;i++){
       if(info[i][0]==ch){
         printf("\n%s", info[i]);
       }
     }

    return 0;

}
