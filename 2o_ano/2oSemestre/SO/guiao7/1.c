#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <sys/types.h>
#include <glib.h>

typedef void (*sighandler_t)(int);

GTimer *g_time;
int sec = 0;
int count = 0;

void sigHandl(int signal){
    switch(signal) {
        case SIGALRM:
            sec++;
            alarm(1);
            break;
        case SIGINT:
            printf("\n%d segundos\n",sec);
            printf("%f segundos, segundo a GLIB\n",g_timer_elapsed(g_time,NULL));
            count++;
            printf("%d vezes carregado\n",count);
            break;
        case SIGQUIT:
            printf("\n%d segundos\n",sec);
            printf("%f segundos, segundo a GLIB\n",g_timer_elapsed(g_time,NULL));
            printf("%d vezes carregado\n",count);
            _exit(0);
            break;
    }
}
int main(int argc, char **argv){
    g_time = g_timer_new();
    alarm(1);

    signal(SIGALRM,sigHandl);
    signal(SIGINT, sigHandl);
    signal(SIGQUIT, sigHandl);
    while(TRUE);
    return 0;
}
