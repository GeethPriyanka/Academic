#include <sys/socket.h>
#include <netinet/in.h>
#include <stdio.h>
#include <string.h>
#include <netdb.h>
#include <arpa/inet.h>
#include <unistd.h>
#include <signal.h>
#include <sys/wait.h>
#include <stdlib.h>

void error(char *msg)
{
    perror(msg);
    exit(1);
}
void handle_client(int newsockfd);

int main(int argc, char *argv[])
{
     int sockfd, newsockfd, portno, clilen, pid;
     char buffer[256];
     struct sockaddr_in serv_addr, cli_addr;
     int n;
     if (argc < 2) {
         fprintf(stderr,"ERROR, no port provided\n");
         exit(1);
     }
     sockfd = socket(AF_INET, SOCK_STREAM, 0);
     if (sockfd < 0) 
        error("ERROR opening socket");
     bzero((char *) &serv_addr, sizeof(serv_addr));
     portno = atoi(argv[1]);
     serv_addr.sin_family = AF_INET;
     serv_addr.sin_addr.s_addr = INADDR_ANY;
     serv_addr.sin_port = htons(portno);
     if (bind(sockfd, (struct sockaddr *) &serv_addr,
              sizeof(serv_addr)) < 0) 
              error("ERROR on binding");
    
     listen(sockfd,5);
     clilen = sizeof(cli_addr);

     while(1){

        
        newsockfd = accept(sockfd, (struct sockaddr *) &cli_addr, &clilen);
        if (newsockfd < 0)
        {
        perror("ERROR on accept");
        exit(1);
        }
        pid = fork();
        if (pid < 0)
        {
        perror("ERROR on fork");
        exit(1);
        }
        if (pid == 0)
        {
        
        close(sockfd);
        handle_client(newsockfd);
        exit(0);
        }
        else
        
        close(newsockfd);
     //   wait(NULL);

    }
     return 0; 
}

void handle_client(int newsockfd){

    /*char buffer1[256] ;*/
    int n;
    /*bzero(buffer,256);*/
    char filename[256];
    while(1){
        n = read(newsockfd,filename,255);
        if (n < 0) error("ERROR reading from socket");
        printf("Here is the requested file: %s\n",filename);
        /*n = write(newsockfd,"I got your message",18);*/
        if (n < 0) error("ERROR writing to socket");

        filename[n-1] ='\0';
         FILE * f = fopen (filename, "r");
        char * buffer = 0;
        long length;

         
        if (f)
        {
          fseek (f, 0, SEEK_END);
          length = ftell (f);
          fseek (f, 0, SEEK_SET);
          buffer = malloc (length);
          if (buffer)
          {
            fread (buffer, 1, length, f);
          }
          fclose (f);
        }

        if (buffer)
        {
            strcat(buffer,"\r");
          
             n = write(newsockfd,buffer,sizeof(char)*length);
             if (n < 0) error("ERROR writing to socket"); 
        }

    }
}