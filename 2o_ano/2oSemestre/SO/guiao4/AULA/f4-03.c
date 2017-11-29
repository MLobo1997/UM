#include <unistd.h>  
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <stdio.h>
// ainda nao esta feito
# define MAX 64
int main () {
	int n,p,f;
	char b[MAX]; 
	//redir output
	f=open("saida.txt",O_CREAT|O_WRONLY | O_TRUNC,0666);
	//if (f==-1){perror("Nao consegui criar o ficheiro"); exit (-1);}

	dup2(f,1);
	close(f);
	
	if (!fork()){
	execlp("wc","wc",NULL);
}
}