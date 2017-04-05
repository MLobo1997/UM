#include <unistd.h>  
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <stdio.h>

int main(int argc, char **argv){
    int i, i1,cmd = 1;
    char **args;
    int INfile, OUTfile;

    if(argc > 1){
        if(strcmp(argv[1],"-i") == 0){
            INfile = open(argv[2], O_CREAT | O_TRUNC | O_WRONLY, 0777);
            dup2(INfile,0);
            close(INfile);
            cmd = 3;
            if(strcmp(argv[3],"-o") == 0){
                cmd = 5;
                OUTfile = open(argv[4], O_CREAT | O_TRUNC | O_WRONLY, 0777);
                dup2(OUTfile,1);
                close(OUTfile);
            }
        }
        else if(strcmp(argv[1],"-o") == 0){
            cmd = 3; 
            OUTfile = open(argv[2], O_CREAT | O_TRUNC | O_WRONLY, 0777);
            dup2(OUTfile,1);
            close(OUTfile);
        }

        args = (char**) malloc(sizeof(char*) * (argc - cmd + 1));
        for(i1 = 0, i = cmd; i < argc ; i++, i1++){
            args[i1] = (char *) malloc(sizeof(char) * (strlen(argv[i])+1));
            strcpy(args[i1], argv[i]);
        }
        args[i1]=NULL;

        execvp(args[0],args);
    }
    else fprintf(stderr,"Tem de receber pelo menos um argumento!"), exit(-1);
}
