#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <sys/types.h>

typedef void (*sighandler_t)(int);

int main(int argc, char **argv){
    for(int i = 1 ; i <= argc ; i++){
        alarm(1);
        if(fork()==0)
            execlp(argv[i],argv[i],NULL);
        pause();
    }
    return 0;
}
