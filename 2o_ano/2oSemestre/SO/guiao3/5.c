#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main(int argc, char **argv){
    int i, exec;
    pid_t p, parent, *pL;
    p = parent = getpid();
    pL = (pid_t *) malloc(argc * sizeof(pid_t));

    for(i=0 ; i < argc ; i++)
        if(parent == getpid()) pL[i] = p = fork(), exec = i+1;

    if(p == 0)
        execlp(argv[exec],"bla", NULL);

    else
        for(i=0;i<argc;i++)
            wait(pL + i);

    return 0;
}
