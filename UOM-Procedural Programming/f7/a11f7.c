/*Write a program that:
  a)Reads from the user an e-mail address of the above format (as alphanumeric).
  b)In case there are spaces at the beginning or at the end of the original e-mail address to remove these spaces.
  c)Prints on the screen the part of the address corresponding to the name as well as the length of the name.
  d)Prints on the screen the part of the address corresponding to the address of the mail server.*/

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void removeSpaces(char word[21]);

int main(){

	int i,i2=0;
	char word[21],name[21],server[21];

	printf("Please enter an email: ");
	scanf("%s", word);

    removeSpaces(word);
    printf("The word is: %s",word);


    sscanf(word, "%[^@]@", name);
    while(name[i]!='\0'){
        i++;
    }

    // to %*[^@] agnoi ta panta prin apo auto
    // to 2o @ dixni na pari ta panta meta apo auto
    // to %[^\0] dixni mexri pote na sinexisi se auti tin
    // periptosi mexri to keno
    sscanf(word, "%*[^@]@%[^\0]", server);


     printf("\nThe mail1 is: %s %d\n",name,i);
     printf("The server is: %s",server);
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
