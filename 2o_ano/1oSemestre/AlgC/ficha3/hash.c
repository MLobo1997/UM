#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define HASHSIZE    31
#define EMPTY       ""
#define DELETED     "-"
typedef char KeyType[9];
typedef void *Info;

typedef struct entry {
	KeyType  key;
	Info info;
} Entry, HashTable[HASHSIZE];

int Hash(KeyType key){
	int i, index=0;
	for(i=0; key[i]!='\0';i++)
		index+=(int) key[i];
	return (index%31);
}

char *empty(){
	char *empty = (char*) malloc(sizeof(strlen(EMPTY)));
	strcpy(empty,EMPTY);
	return empty;
}

char *deleted(){
	char *deleted = (char*) malloc(sizeof(strlen(DELETED)));
	strcpy(deleted,DELETED);
	return deleted;
}

void InitializeTable(HashTable table){
	int i;
	for(i=0;i<HASHSIZE;i++)
		table[i].info=empty();
}

int isEmpty(void *info){
	return (strcmp(info,EMPTY)==0);
}

int isDeleted(void *info){
	return (strcmp(info,DELETED)==0);
}

int nextHash(int i){
	int r;
	if(++i < HASHSIZE) r=i;
	else r=0;
	return r;
}
void InsertTable_LP(HashTable table, KeyType key, Info info){
	int i, hash;
       	i = hash = Hash(key);
	do{
		if(isEmpty(table[i].info) || isDeleted(table[i].info)){
			free(table[i].info);
			strcpy(table[i].key, key);
			table[i].info=info;
			hash=i;
		}
		else i=nextHash(i);
	}while(i!=hash);
}

void DeleteTable_LP(HashTable table, KeyType key, Info info){
	int i, hash;
       	i = hash = Hash(key);
	do{
		if(!isEmpty(table[i].info) || !isDeleted(table[i].info) || key == table[i].key){
			free(table[i].info);
			table[i].info=deleted();
			hash=i;
		}
		else i=nextHash(i);
	}while(i!=hash && isDeleted(table[i].info));
}

int RetrieveTable_LP(HashTable table, KeyType key){
	int r=-1;
	int i, hash;
       	i = hash = Hash(key);
	do{
		if(table[i].key == key)
			r=i,i=hash;
		else{
			if(isEmpty(table[i].info))
				i=hash;
			else i=nextHash(i);
		}
	}while(i!=hash);
	return r;
}
