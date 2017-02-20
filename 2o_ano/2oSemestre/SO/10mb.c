#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>   /* chamadas ao sistema: defs e decls essenciais */
#include <fcntl.h>    /* O_RDONLY, O_WRONLY, O_CREAT, O_* */

int main(int argc, char **argv){

    int file, i;
    char c='a';

    if(argc == 2){
        
        file = open(argv[1], O_CREAT | O_WRONLY, 0600);
        if (file == -1) perror("RIP"), exit(-1);

        for(i=0 ; i < 10 * 1024 * 1024 ; i++)
            write(file, &c, 1);

        exit(0);
    }

    else exit(-1);
}



