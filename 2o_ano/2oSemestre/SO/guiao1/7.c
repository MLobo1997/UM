#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <unistd.h>   /* chamadas ao sistema: defs e decls essenciais */
#include <fcntl.h>    /* O_RDONLY, O_WRONLY, O_CREAT, O_* */

int create_buffer (int fildes, struct buffer_t *buffer, size_t nbyte){
    
