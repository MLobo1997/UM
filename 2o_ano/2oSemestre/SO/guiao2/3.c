#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main(){
    int i,p=0, status, s;


    for(i=0; i < 10 ; i++)
        if(p==0) p=fork(), status = i;

    if(p==0){
        printf("pid = %d, ppid = %d\n", getpid(), getppid());
        _exit(i);
    }
    else{
        wait(&p);
        if(WIFEXITED(p) != 0){
            s = WEXITSTATUS(p);
            printf("exist status do filho pid = %d\n", s);
            printf("pid = %d, ppid = %d\n", getpid(), getppid());
            _exit(status);
        }
        else printf("FODEU");
    }
}
