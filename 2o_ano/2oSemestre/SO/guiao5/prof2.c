#include <unistd.h>  
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <stdio.h>
#define MAX 60

int main(){
    int p[2];
    int n, n1;
    char buf[MAX];
    pipe(p);
    if(fork()) {
        while((n=read(p[0],buf,50)) > 0)
            printf("PAI leu %d bytes: %s", n, buf);
    }
    else{
        write(p[1],"Ola MIEIs\n",11);
        wait(NULL);
    }
}
