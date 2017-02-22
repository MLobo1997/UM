#include <stdlib.h>
#include <stdio.h>
#include <string.h>
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

int main (int argc, char **argv){
    int count=1, line=1;
    char print[1000], l[100];

    if(argc == 1){
        while(count > 0){
            count = readln(0, print, 1000);

            sprintf(l, "%d\t", line);
            write(1, l, strlen(l));
            write(1, print, count);

            line++;
        }
    }

    exit(count);
}
