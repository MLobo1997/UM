#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <string.h>

int mysystem(char *command){
    char *cmd[100];
    const char s[2] = " ";
    int i=0;

    cmd[i] = strtok(command, s);

    for(i++ ; cmd[i-1] != NULL ; i++){
        cmd[i] = strtok(NULL, s);
    }
    cmd[i]=NULL;

    return execvp(cmd[0], cmd);

}

int main(int argc, char **argv){
    char c[100]="ls -l ";
    return mysystem(c);

}
