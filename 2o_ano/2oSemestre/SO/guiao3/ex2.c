#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main(){
    int p = fork();
    if(p!=0) execlp("ls","ls","-l", NULL);

    if(p==0) printf("O pai viveu\n");
    return 0;
}

