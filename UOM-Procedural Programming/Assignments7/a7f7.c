/*In the Scrabble game, each letter of the English alphabet is assigned specific points (points) as follows:

	Points | Letters
   -----------------------------------------
	  1    | A, E, I, L, N, O, R, S, T, U
	  2    | D, G
	  3    | B, C, M, P
	  4    | F, H, V, W, Y
	  5    | K
	  8    | J, X
	 10    | Q, Z

  Write a ScrabbleScore function that takes a word (with a maximum of 20 characters - char[21])
  as an argument and returns the score the word would get if played on the Scrabble board,
  without counting the remaining points awarded in the game . To calculate the score, you
  should ignore all non-uppercase characters. More specifically, lowercase letters should be
  considered to represent empty squares which can represent any letter but score zero points.
  Write a main program to test the ScrabbleScore function. Try the words “XI”, “HORN”,
  “SCRABBLE” and “QUIzZICAL” and make sure they return the value 9, 7, 14 and 28 respectively.
*/

#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

void removeSpaces(char word[21]);
int ScrabbleScore(char word[21]);

 int main(){
    char word[21];

    printf("Enter a word: %s",word);
    gets(word);
    removeSpaces(word);
    printf("The word is: %s",word);
    printf("\n");

    printf("Number of points: %d",ScrabbleScore(word));

   return 0;
}

void removeSpaces(char word[21]){
    int i=0, j, chk;
    while(word[i]!='\0'){
        chk=0;
        if(word[i]==' '){
            j=i;
            while(word[j-1]!='\0'){
                word[j] = word[j+1];
                j++;
            }
            chk = 1;
        }
        if(chk==0)
            i++;
    }

}

int ScrabbleScore(char word[21]){
     int count=0,i=0,sum=0,points;

     for(i = 0; word[i] != '\0'; i++){
        if(word[i]=='A' || word[i]=='E' ||
           word[i]=='I' || word[i]=='L' ||
           word[i]=='N' || word[i]=='O' ||
           word[i]=='R' || word[i]=='S' ||
           word[i]=='T' || word[i]=='U'){
           points=1;
        }
        else if(word[i]=='D' || word[i]=='G'){
            points=2;
        }
         else if(word[i]=='B' || word[i]=='C' ||
                 word[i]=='M' || word[i]=='P'){
            points=3;
        }
         else if(word[i]=='F' || word[i]=='H' ||
                 word[i]=='V' || word[i]=='W' ||
                 word[i]=='Y'){
            points=4;
        }
         else if(word[i]=='K'){
            points=5;
        }
         else if(word[i]=='J' || word[i]=='X'){
            points=8;
        }
         else if(word[i]=='Q' || word[i]=='Z'){
            points=10;
        }

        else if(word[i]>='a' || word[i]<='z'){
            points=0;
        }
        sum+=points;
    }

    return sum;


}
