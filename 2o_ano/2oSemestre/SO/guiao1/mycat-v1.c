#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>   /* chamadas ao sistema: defs e decls essenciais */
#include <fcntl.h>    /* O_RDONLY, O_WRONLY, O_CREAT, O_* */

int main(){
    int error = 1; 
    char *print;

    while (error == 1){
        error = read(0, print, 1);
        write(1, print, 1);
    }

    exit(error);
}
