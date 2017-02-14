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

void DFS (GraphL g, int i, int n, int tsort[], int vis[], int *p){
	struct edge *tmp=g[i];
	vis[i]=BLACK;
	while(tmp){
		if(vis[tmp->dest]==WHITE) DFS(g, tmp->dest,n,tsort, vis,p);
		tmp=tmp->next;
	}
	
	tsort[*p--]=i;
}


int topSort_Tarjan (GraphL g, int n, int tsort[]){
	int vis[MAX]={WHITE};
	int i,pos;
	pos=n-1;
	for(i=0;i<n;i++)
		if(vis[i]==WHITE) DFS(g,i,n,tsort,vis,&pos);

	return 0;
}
