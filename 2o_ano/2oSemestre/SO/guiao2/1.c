#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main(){
    printf("pid = %d, ppid = %d\n", getpid(), getppid());
    getchar();
    return 0;
}
