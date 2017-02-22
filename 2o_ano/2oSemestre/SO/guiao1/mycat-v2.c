#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>   /* chamadas ao sistema: defs e decls essenciais */
#include <fcntl.h>    /* O_RDONLY, O_WRONLY, O_CREAT, O_* */

int main(int argc, char **arg){
    int N, cont, n;
    char *print;

    cont = n = N = atoi(arg[1]);

    print = (char*) malloc(N*sizeof(char));

    if(argc != 2) perror("É necessário apenas um argumento!\n"), exit(-1);

    while(cont > 0){
        cont = read(0, print, N);
        write(1, print, N);
    }
    free(print);
    exit(cont);
}
