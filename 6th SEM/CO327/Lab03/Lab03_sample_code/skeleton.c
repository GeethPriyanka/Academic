
#include <unistd.h>
#include <stdio.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <string.h>
#include <stdlib.h>
#include <pthread.h>

typedef struct connection{
int sockfd;
struct sockaddr_in client_addr;
unsigned int client_len;

} connection_t;
 
void* handle_client(void*);

int main()
{
    int listenfd;
    int *connfd;
    struct sockaddr_in servaddr,cliaddr;
    socklen_t clilen;

    listenfd=socket(AF_INET,SOCK_STREAM,0);

    servaddr.sin_family = AF_INET;
    servaddr.sin_addr.s_addr=htonl(INADDR_ANY);
    servaddr.sin_port=htons(32000);

    bind(listenfd,(struct sockaddr *)&servaddr,sizeof(servaddr));

    listen(listenfd,5);

    clilen = sizeof(cliaddr);
    while (1)
    {
        connfd = malloc(sizeof(int));
        *connfd = accept(listenfd, (struct sockaddr *) &cliaddr, &clilen);
        /* now create a new thread, pass it the socket and run the thread. */

        pthread_t* thread =(pthread_t *)malloc (sizeof(pthread_t));
        connection_t *connect =malloc(sizeof(connection_t));

        connect->sockfd =*connfd;
        connect->client_addr =cliaddr;
        connect->client_len =clilen;

        if(pthread_create( thread, NULL, handle_client, connect)){  //connection details are passed here as connect variable
            printf("error creating thread.");
            abort();
        }
        free(thread);
        free(connfd);
        

    }
    exit(0);
}

void* handle_client(void* connfd)
{
   
    char * msg ="Hello from the server\n";
    char buff[500];
    int n;

    connection_t* connect =(connection_t*) connfd ;

    int newsockfd =connect->sockfd;

    struct sockaddr_in cli_addr=connect->client_addr;

    unsigned int clilen = connect->client_len;

    n=recvfrom(newsockfd,buff,1000,0,(struct sockaddr *)&cli_addr ,&clilen);
    buff[n-1] ='\0';

    printf("%s\n",buff);
    sendto(newsockfd ,msg,strlen(msg),0,(struct sockaddr *)&cli_addr ,clilen);
    close(newsockfd);

    free(connfd);
    return NULL;
}
