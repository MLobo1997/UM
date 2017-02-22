#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>   /* chamadas ao sistema: defs e decls essenciais */
#include <fcntl.h>    /* O_RDONLY, O_WRONLY, O_CREAT, O_* */


ssize_t readln(int fildes, char *buf, size_t maxlen){

    int i, n=1;
    char ch='\0';

    for(i=0; i < maxlen && ch !='\n' && n == 1; i++){
        n = read(fildes, &ch, 1);
        buf[i]=ch;
    }

    return i;
}

int main(){
    ssize_t cont;
    char print[100];

    do{
        cont = readln(0, print, 100);
        write(1, print, cont);
    }while(cont > 0);

    exit(cont);
}
