#include <unistd.h>  
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <stdio.h>

int main(){
    int fildes[2]; 
    char buf[100];
    char endofile[1];

    *endofile = EOF;
    pipe(fildes);

    if(fork()){
        write(1,"Pai criado!\n",strlen("Pai criado!\n"));
        while(read(fildes[0],buf,100) > 0)
            printf("O meu filho mandou me a mensagem: \"%s\".\n",buf);
        write(1,"Morreu o pai!\n", 15);
        _exit(0);
    }

    else{
        write(1,"Filho criado!\n",strlen("Filho criado!\n"));
        for(int i =3 ; i--;){
            write(fildes[1],"Mensagem do filho para o pai", strlen("Mensagem do filho para o pai"));
            sleep(1);
        }
        write(fildes[1],endofile,1);
        write(1,"Morreu o filho!\n", 15);
        _exit(0);
    }
    return 0;
}
