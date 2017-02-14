#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define HASHSIZE    31
typedef char KeyType[9];
typedef void *Info;

typedef struct entry {
	KeyType  key;
	Info info;
	struct entry *next;
} Entry, *HashTable[HASHSIZE];

int Hash(KeyType key){
	int i, index=0;
	for(i=0; key[i]!='\0';i++)
		index+=(int) key[i];
	return (index%31);
}

void InitializeTable(HashTable table){
	int i;
	for(i=0;i<HASHSIZE;i++){
		table[i]=NULL;
	}
}	

void freeList(struct entry *LEntry){
	while(LEntry){
		free(LEntry);
		LEntry=LEntry->next;
	}
}

void CleanTable(HashTable table){
	int i;
	for(i=0;i<HASHSIZE;i++){
		freeList(table[i]);
		table[i]=NULL;
	}
}

struct entry *newEntry(KeyType key, Info info){
	struct entry *r = (struct entry *) malloc(sizeof(struct entry));
	if(r){
		strcpy(r->key,key);
		r->info=info;
	}
	return r;
}

void InsertTable(HashTable table, KeyType key, Info info){
	struct entry **tmp = &(table[Hash(key)]);
	while(*tmp)
		tmp=&((*tmp)->next);
	*tmp=newEntry(key,info);
}

void DeleteTable(HashTable table, KeyType key){
	struct entry **tmp = &(table[Hash(key)]);
	struct entry *tmp1;
	while(*tmp && strcmp((*tmp)->key, key) == 0)
		tmp=&((*tmp)->next);
 	if(*tmp){
		tmp1=*tmp;
		*tmp=(*tmp)->next;
		free(tmp1);
	}
}
		
Entry * RetrieveTable(HashTable table, KeyType key){
	Entry *tmp = table[Hash(key)];
	while(tmp && strcmp(tmp->key,key) != 0)
		tmp=tmp->next;
	return tmp;
}

