#include <stdio.h>
#include <stdlib.h>

#define WHITE 0
#define GRAY 1
#define BLACK 2

#define INTREE 0
#define FRINGE 1
#define UNSEEN 2

#define NIL -1

#define NE 0

#define MAX 100

typedef int WEIGHT;

struct edge {
    int dest;
    WEIGHT weight;
    struct edge *next;
};

typedef struct edge *GraphL[MAX];

typedef WEIGHT GraphM[MAX][MAX];

void inDegrees (GraphL g, int n, int inD[]){
    struct edge *tmp;
    int i;
    for(i=0;i<n;i++)inD[i]=0;
    for(i=0;i<n;i++){
        tmp=g[i];
        while(tmp){
            inD[tmp->dest]++;
            tmp=tmp->next;
        }
    }
}

void decEntAux(GraphL g, int i, int inD[], int checked[]){
    struct edge *tmp=g[i];

    checked[i]=BLACK;
    inD[i]--;
    while(tmp)
        if(checked[tmp->dest]==WHITE)
            decEntAux(g, tmp->dest, inD, checked);
}

void decEnt(GraphL g, int n, int i, int inD[]){
    struct edge *tmp=g[i];
    int i1, checked[MAX];
    for(i1=0;i1<n;i1++)checked[i1]=WHITE;

    checked[i]=BLACK;
    while(tmp){
        decEntAux(g, tmp->dest, inD, checked);
        tmp=tmp->next;
    }

}

int topSort_Kahn (GraphL g, int n, int tsort[]){
    int inD[n], tmp[n],i1, i2;

    inDegrees(g,n,inD);
    for(i1=0;i1<n;i1++) tmp[i1]=inD[i1];

    for(i1=0;i1<n;i1++)
        for(i2=0;i2<n;i2++){
            if(inD[i2]==0){
                tsort[i1++]=i2;
                tmp[i2]=-1;
                decEnt(g, n, i2, tmp);
            }
        for(i2=0;i2<n;i2++)inD[i2]=tmp[i2];
        }
    
    return 0;
}
