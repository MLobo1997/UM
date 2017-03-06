#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <unistd.h>   /* chamadas ao sistema: defs e decls essenciais */
#include <fcntl.h>    /* O_RDONLY, O_WRONLY, O_CREAT, O_* */

void findMatch(int fildes, char *str){
    int size = strlen(str), n=size, i = 1;
    char *bufCMP = (char*) malloc(sizeof(char)*(size + 1)), *line = "Linha nº 9999: ", par = '\n';
    bufCMP[size] = '\0';

    while(n>=0){
        n = read(fildes, bufCMP, 1);

        if(n > 0 && bufCMP[0] == '\n') i++;

        if(n > 0 && bufCMP[0] == str[0]){
            n = read(fildes, bufCMP + 1, size-1);
            if(n == size - 1 && strcmp(bufCMP, str) == 0){
                sprintf(line, "Linha nº %d: ", i);
                write(1, line, strlen(line));
                write(1, bufCMP, size);
                write(1, &par, 1);
            }
        }
    }
}

int main (int argc, char **argv){
    char buf;
    int n = 1, i, filde;

    if(argc < 2) perror("At least one argument needed"), exit(-1);

    else{
        if(argc == 2){
            while(n==1){
                n = read(0, &buf, 1);
                if(n==1) n = write(1, &buf, 1);
            }
        }
        else{
            if(argc > 2){
                for(i = 2 ; i < argc ; i++){
                    filde = open(argv[i], O_RDONLY);
                    findMatch(filde, argv[1]);
                    close(filde);
                }
            }
        }
    }
}
