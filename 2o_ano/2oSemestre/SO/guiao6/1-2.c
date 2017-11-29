#include <unistd.h>  
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>

int main(){
    char buf[100];
    int n = 1, fildes;
    fildes = open("fifo", O_WRONLY);
    while(n > 0){
        n = read(0,buf,100); 
        write(fildes,buf, n);
    }
    exit(0);
}
