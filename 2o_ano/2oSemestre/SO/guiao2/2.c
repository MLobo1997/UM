#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main(){
    pid_t p;
    p = fork();
    if(p == 0) sleep(5);
    printf("pid = %d, ppid = %d\n", getpid(), getppid());
    return 0;
}
