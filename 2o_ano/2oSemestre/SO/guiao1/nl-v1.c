#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <unistd.h>   /* chamadas ao sistema: defs e decls essenciais */
#include <fcntl.h>    /* O_RDONLY, O_WRONLY, O_CREAT, O_* */


ssize_t readln(int fildes, char *buf, size_t maxlen){

    int i, n;
    char ch;

    i=0;
    do{
        n = read(fildes, &ch, 1);
        buf[i]=ch;
        if(n==1) i++;
    }while(i < maxlen && ch !='\n' && ch != '\0' && ch != EOF && n == 1);

    return i;
}

int main (int argc, char **argv){
    int count=-1, line=1, fildes;
    char print[1000], l[100];

    if(argc == 1){
        do{
            count = readln(0, print, 1000);

            sprintf(l, "%d\t", line);
            write(1, l, strlen(l));
            write(1, print, count);

            line++;
        }while(count > 0);
    }

    if(argc == 2){
        fildes = open(argv[1], O_RDONLY);
        if(fildes < 0) perror("FILE NOT FOUND\n"), exit(-1);
        do{
            count = readln(fildes, print, 1000);

            if(count > 0){sprintf(l, "%d\t", line);
                write(1, l, strlen(l));
                write(1, print, count);
            }

            line++;
        }while(count > 0);
    }
    exit(count);
}
