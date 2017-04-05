#include <unistd.h>  
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <stdio.h>

int main(int argc, char **argv){
   int file, fError;

   file = open("saida.txt", O_CREAT | O_TRUNC | O_WRONLY, 0777);
   fError = open("error.txt", O_CREAT | O_TRUNC | O_WRONLY, 0777);

   dup2(file,1);
   dup2(fError, 2);
   close(file);
   close(fError);

   printf("TA LA DENTRO\n");
   fprintf(stderr,"ERROU MAS TA LA DENTRO\n");
   return 0;
}
