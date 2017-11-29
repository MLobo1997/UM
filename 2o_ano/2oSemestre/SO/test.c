#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <string.h>
#include <sys/types.h>

typedef void (*sighandler_t) (int);

int sec;
pid_t parent;

void sigHandler(int signal){
    char ok[4] = "OK\n", dead[50];
    switch (signal) {
        case SIGALRM:
            alarm(3);
            write(1, ok, 3);
            sec += 3;
            break;
        case SIGCHLD:
            sprintf(dead, "Morreu um processo: %d segundos\n",sec);
            write(1, dead, strlen(dead));
            break;
    
    }
}

int main (int argc, char *argv[]){
    sec = 0;
    int i;
    pid_t *p = (pid_t*) malloc(sizeof(pid_t) * (argc - 1));
    parent = getpid();
    pid_t pip[2];

    signal(SIGCHLD, sigHandler);

    pipe(pip);
    dup2(1, pip[1]);
    close(pip[1]);

    for(i = 1 ; i < argc ; i++){
        p[i-1] = fork();
        if(p[i-1] == 0){
            
            dup2(pip[0],1);
            close(1);
            signal(SIGALRM, sigHandler);
            alarm(3);
            execlp(argv[i],argv[i],NULL);
        }
    }

    for(i = 0; i < argc - 1; i++)
        wait(p+i);

    free(p);
    exit(0);
}
