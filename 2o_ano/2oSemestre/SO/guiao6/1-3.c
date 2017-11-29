#include <unistd.h>  
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>

int main(){
    char buf[100];
    int fildes, n=1;
    fildes = open("fifo",O_RDONLY);
    while(n > 0){
        n = read(fildes, buf, 100);
        write(1, buf, n);
    }
    exit(0);
}
