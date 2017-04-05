#include <unistd.h>  
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <stdio.h>

int main(int argc, char **argv){
    int i,cmd = 1, size;
    char **args;

    if(argc > 1){
        if(strcmp(argv[1],"-i") == 0){
            if(strcmp(argv[3],"-o") == 0){
                cmd =5;
            }
        }
        for(size = 0, i = cmd; i < argc ; i++)
            size += strlen(argv[i]) + 1;

        args = (char**) malloc(sizeof(char) * size);

        for(int i1 =0, i = cmd; i < argc ; i++, i1++)
            strcpy(args[i1], argv[i]);
        args[i]=NULL;

        execvp(args[0],args);
    }
    else fprintf(stderr,"Tem de receber pelo menos um argumento!"), exit(-1);
}
