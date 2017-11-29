
#include <unistd.h>  
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <stdio.h>
#define MAX 60

int main(){
    int p[2];
    char buf[MAX];
    int n, n1;

    pipe(p);

    if(!fork()){
        n = read(p[0], buf, 11);
        printf("FILHO leu %d bytes: %s \n", n, buf);
    }
    else{
        sleep(3);
        write(p[1],"Ola MIEIs\n",10);
    }
}
