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

int grauEntradaLine(GraphL g, int n, int v[n]){
    int i;
    struct edge *tmp;
    for(i=0;i<n;i++){
        tmp=g[i];
        while(tmp){
            v[tmp->dest]++;
            tmp=tmp->next;
        }
    }
    return 0;
}

void incSeqAux(GraphL g, int i, int v[],int vis[]){
    struct edge *tmp=g[i];
    vis[i]=BLACK;
    while(tmp){
        if(vis[tmp->dest]==WHITE){
            v[tmp->dest]--;
            incSeqAux(g,tmp->dest,v,vis);
        }
        tmp=tmp->next;
    }
}

void incSeq (GraphL g, int i, int v[]){
    int vis[MAX]={WHITE};
    incSeqAux(g,i,v,vis);
}

int topSort_Kahn (GraphL g, int n, int tsort[]){
    int i=0, i1, v[MAX]={0}, vtmp[MAX]={0};
    grauEntradaLine(g, n, v);
    for(i=0;i<n;i++){
        for(i1=0;i1<n;i1++)
            if(v[i1]==0){
                tsort[i++]=i1;
                incSeq(g, i1, vtmp);
                vtmp[i1]=-1;
            }
        for(i1=0;i1<n;i1++) v[i1]=vtmp[i1];
    }
    return 0;
}
