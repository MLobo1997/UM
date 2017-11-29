#include <unistd.h>  
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <stdio.h>


/*chamadas ao sistema: defs e decls essenciais*/
//int dup(int fd);
//int dup2(int fd1, int fd2);


// lsof -c cat
//rw_rw_rw_->110 110 110 -> 666
//ls -l
//umask
# define MAX 64
int main () {
	int n,f;
	char b[MAX]; 
	//redir output
	f=open("saida.txt",O_CREAT|O_WRONLY | O_TRUNC,0666);
	//if (f==-1){perror("Nao consegui criar o ficheiro"); exit (-1);}

	dup2(f,1);
	close(f);

	n=read (0,b,MAX);
	write (1,b,n);
	//if (f==-1)

	printf("ola gente\n");

    return 0;
}
