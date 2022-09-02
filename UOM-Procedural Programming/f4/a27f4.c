/*In the case of codes consisting of a large number of digits (e.g. bank accounts,
  payment codes etc) for the security of transactions there should be an easy way
  ensuring that the user does not type the digits incorrectly. The way is to add to the codes,
  check digits. A simple way to do the above is to add 2 check digits to the end of it
  code thus creating the final code.

  The check digits of a prime N (long )code are given by the formula:
  Check digits = (98 - (N*100) % 97) % 97

  The validity check of a final ΕΝ (final code) is easily calculated by checking if the ΕΝ
  transaction % 97 has as result 1.

  Implement:
  (a) An encode function which accepts an initial code (long) and returns the corresponding final
  code (long).
  (b) a check function which accepts a final code and returns TRUE if it is valid and
  FALSE if it isn't valid;

  (c) a program which accepts from the user two limits of initial codes (long) and displays for each
  code between these two limits the initial code, the final code and whether it is valid or not.
  The display of the messages will be done through the main function.
  Assume that the user always gives limits greater than 0 and that the lower limit will always be
  less than or equal to the upper limit (upper limit)). No control required.

  Note: If your program is correct, then all final codes displayed will be valid */

#include <stdio.h>
#include "genlib.h"
#include "math.h"

long encode(long code);
bool check(long newCode);

int main(){
   long lLimit, ULimit;
   printf("Lower Limit: ");
   scanf("%ld",&lLimit);

   printf("Upper Limit: ");
   scanf("%ld",&ULimit);


   for(int i=lLimit; i<=ULimit; i++){
       long newCode = encode(i);
       printf("Code: %ld Encoding: %ld Is valid: %s\n",i,newCode,check(newCode)?"yes":"no");
   }


   return 0;
}


long encode(long code){
     long newCode;
     int checkDigits = (98 -(code*100) % 97) % 97;
     newCode = code*100 + checkDigits;
     return newCode;
}

bool check(long newCode){

    if(newCode%97 == 1){
        return 1;
    }
        else return 0;

}
