#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main(){
    int p = fork();
    
    if(p == 0) execlp("ls","ls","-la", NULL);
    else wait(&p), printf("--------------------------\nAgora sim, morre o pai!\n"), _exit(0);

    return 0;
}

