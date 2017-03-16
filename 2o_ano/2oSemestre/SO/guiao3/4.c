#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main(int argc, char **argv){
    char cwd [1024];
    getcwd(cwd, 1024);
    sprintf(cwd,"%s/3",cwd);
    return execlp(cwd,"olá","coiso","Como","a",NULL);
}
