#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define N 9

typedef struct colElem{
	int n;
	struct colElem *next;
}*colEsp;

typedef struct line{
	int n;
	colEsp col;
	struct line *next;
}*Mat;

typedef int **matrixAdj;

typedef struct aresta{
	int dest;
	int weight;
	struct aresta *next;
}*Grafo[N];

colEsp newCol(int n, colEsp next){
	colEsp r = (colEsp) malloc(sizeof(struct colElem));
	if(r){
		r->n=n;
		r->next=next;
	}
	return r;
}

Mat newLine(int n, colEsp col, Mat next){
	Mat r = (Mat) malloc(sizeof(struct line));
	if(r){
		r->n = n;
		r->col = col;
		r->next = next;
	}
	return r;
}



Mat MatrixToList(matrixAdj m){
	int l,c;
	Mat r, *tmp;
	r=NULL, tmp = &r;
	colEsp col, *tmpCol;
	tmpCol=&col;
		
	for(l=0;l<N;l++){
		for(c=0;c<N;c++){
			if(m[l][c]==1){
				if(tmp==NULL){
					col = newCol(c, NULL);
					tmpCol = &col;
					*tmp = newLine(l, col, NULL);
				}
				else
					*tmpCol = newCol(c, NULL);
				tmpCol = &((*tmpCol)->next);
			}
		}
		if(*tmp) tmp = &((*tmp)->next);
	}
	return r;
}

void initializeMatrix(matrixAdj m){
	int x, y;

	for(x=0;x<N;x++)
		for(y=0;y<N;y++)
			m[x][y]=0;
}

matrixAdj ListToMatrix(Mat list){
	matrixAdj r;
	r= (matrixAdj) malloc(sizeof(int[N][N]));
	initializeMatrix(r);
	colEsp col;
	while(list){
		col=list->col;
		while(col){
			r[list->n][col->n]=1;
			col=col->next;
		}
		list=list->next;
	}
	return r;
}

int grauSaidaMatrix(matrixAdj m, int v){
	int i, r=0;
	for(i=0;i<N;i++)
		if(m[v][i]==1)
			r++;
	return r;
}

int grauEntradaMatrix(matrixAdj m, int v){
	int i, r=0;
	for(i=0;i<N;i++)
		if(m[i][v]==1)
			r++;
	return r;
}

int grauSaidaLine(Mat l, int v){
	int r=0;
	colEsp col;
	while(l && l->n != v)
		l=l->next;
	if (l){
		col=l->col;
		while(col){
			r++;
			col=col->next;
		}
	}
	return r;
}

int grauEntradaLine(Mat l, int v){
	int r=0;
	colEsp col;
	while(l){
		col=l->col;
		while(col && col->n != v)
			if(col)r++;
		l=l->next;
	}
	return r;
}

int capacidadeSaida(Grafo g, int v){
	int r=0;
	struct aresta *tmp = g[v];
	while(tmp){
		r+=tmp->weight;
		tmp=tmp->next;
	}
	return r;
}

int capacidadeEntrada(Grafo g, int v){
	int i, r=0;
	struct aresta *tmp;
	for(i=0;i<N;i++){
		for (tmp=g[i]; tmp && tmp->dest != v; tmp=tmp->next);
		if(tmp)r+=tmp->weight;
	}
	return r;
}

int capacidade (Grafo g, int v){
	int r=0;
	r=capacidadeSaida(g,v);
	r+=capacidadeEntrada(g,v);
	return r;
}

int max(int v[], int NE){
	int i, r=0;
	for(i=0;i<NE;i++)
		if(v[i]>v[r])r=i;
	return r;
}

int maxCap(Grafo g){
	int i, count[N]={0};
	struct aresta *tmp;
	for(i=0;i<N;i++){
		tmp=g[i];
		while(tmp){
			count[i]+=tmp->weight, count[tmp->dest]+=tmp->weight;
			tmp=tmp->next;
		}
	}	
	return max(count,N);
}


