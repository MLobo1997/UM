#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int lineCheck(int n, int mat[3][3], int N, int l){
    int i;

    for(i=0 ; i < N && mat[l][i] != n ; i++);

    return (i < N);
}

int main(){
    pid_t parent = getpid(), p;
    int l, lE;

    int mat [3][3] = {{1,2,7},
                     {9,9,6},
                     {9,8,9}};

    for(l = 0 ; l < 3 && parent == getpid(); l++)
        p = fork(), lE = l;

    if(p == 0 && lineCheck(7 , mat, 3, lE)) printf("Existe!\n");

    return 0;




}
