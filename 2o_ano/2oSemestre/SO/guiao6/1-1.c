#include <unistd.h>  
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>

int main(){
    if(mkfifo("fifo",0777) == -1){
        perror("Erro\n"); 
        exit(-1);
    }
    exit(0);
}
