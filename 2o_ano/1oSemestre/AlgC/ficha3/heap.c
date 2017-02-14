#define PARENT(i) (i-1)/2  // os indices do array começam em 0 
#define LEFT(i) 2*i + 1
#define RIGHT(i) 2*i + 2

typedef int Elem;  // elementos da heap.

typedef struct {
 int   size;
 int   used;
 Elem  *values;
} Heap;

int OKaux(int v[], int i, int n){
    int min= v[i], left=LEFT(i),right=RIGHT(i), rL, r; 
    rL=r=0;

    if(i >= n) r = 1;
    else{
        if(left >= n || min < v[left] && OKaux(v, left, n)) rL=1;

        if(right >= n || rL && min < v[right] && OKaux(v, right, n)) r=1;
    }
    return r;
}

int minHeapOK (Heap h){ 
    return OKaux(h.values, 0, h.size);
}
    
