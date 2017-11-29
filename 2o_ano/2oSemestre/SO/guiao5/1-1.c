#include <unistd.h>  
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <stdio.h>

int main(){
    int fildes[2]; 
    char buf[100];

    pipe(fildes);

    if(fork()){
        write(1,"Pai criado!\n",strlen("Pai criado!\n"));
        read(fildes[0], buf, 100);
        printf("O meu filho mandou me a mensagem: \"%s\".\n",buf);
    }

    else{
        write(1,"Filho criado!\n",strlen("Filho criado!\n"));
        sleep(1);
        write(fildes[1],"Mensagem do filho para o pai", strlen("Mensagem do filho para o pai"));
    }
    return 0;
}
