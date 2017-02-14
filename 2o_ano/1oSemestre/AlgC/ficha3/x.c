void remLast(LInt *l){
    while(*l!=NULL && (*l)->next != NULL)
        l->next;
    free(*l);
    *l=NULL;
}
    
