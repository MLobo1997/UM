#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main(){
    int p;
    p = fork();
    if(p == 0) sleep(2);
    printf("pid = %d, ppid = %d\n", getpid(), getppid());
    return 0;
}
