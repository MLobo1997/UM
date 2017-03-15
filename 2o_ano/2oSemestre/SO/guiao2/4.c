#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main(){
    int i, parent = getpid(), r;
    pid_t p,pL[10];

    for(i=0; i<10; i++)
        if(parent == getpid()) p = pL[i] = fork(), r = i;

    if(p == 0){
        printf("pid: %d; ppid: %d.\n", getpid(), getppid());
        _exit(r);
    }

    else{
        for(i = 0 ; i<10; i++){
            wait(pL + i);
            if(WIFEXITED(pL[i]) != 0){
                r = WEXITSTATUS(pL[i]);
                printf("FILHO Nº %d\n", r);
            }
            else printf("FODEU"), exit(-1);
        }
    }

}
