#define MaxV 10
#define WHITE 0
#define GRAY  1
#define BLACK 2

typedef struct edge *Fringe;

typedef struct edge {
    int dest;
    int cost;
    struct edge *next;
} Edge, *Graph [MaxV];

void

int primMST (Graph g, int p[], int w[]) {
    int i, v, r=0, fsize, col [MaxV];
    Fringe f;
    newFringe (MaxV);
    for (i=0;i<MaxV;i++){
        p[i] = -1; col [i] = WHITE;
    }
    col [0] = GREY; w [0] = 0;
    f = addV (f, 0, 0);
    fsize=1;
    while (fsize) {
        fsize--;
        f = nextF(f, &v);
        col [f] = BLACK; ́
        r += w[v];
        for (x=g[v]; x; x = x->next)
            switch(col [x->dest]){
                case WHITE: col [x->dest] = GREY;
                            fsize++;
                            f = addV (f, x->dest, x->cost);
                            w[x->dest] = x->cost; p[x->dest] = v;
                            break;
                case GREY:  if (w[x->dest] > x->cost) {
                            f = updateV (f, x->dest, x->cost);
                            default
                            }
        }
    }
}
/**
void mst(GraphL g, int n, int parent[]) {


    int status[MAX];
    int fringeLink[MAX];
    int fringeWgt[MAX];
    struct edge *ptr;
    int x,y;
    int fringeList;
    int edgeCount;
    int stuck;
    int sum;

 

    x = 0;
    status[0] = INTREE;
    parent[0] = -1;

    stuck = 0;
  
    edgeCount = 0;

    fringeList = NIL;

    for (y = 1 ; y < n ; y++) status[y] = UNSEEN;

    while(edgeCount<n-1 && !stuck) {

    // ...

        edgeCount++;
    }
}
*/
