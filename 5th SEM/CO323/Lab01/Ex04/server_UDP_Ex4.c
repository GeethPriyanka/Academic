/* Sample UDP server */
#include <sys/socket.h>
#include <netinet/in.h>
#include <strings.h>
#include <stdio.h>
#include <time.h>

int main(int argc, char**argv){

	
		int sockfd,n;
		struct sockaddr_in servaddr, cliaddr;
		socklen_t len;
		char mesg[1000];
		char* banner = "Hello UDP client! This is UDP server";
		
		sockfd=socket(AF_INET,SOCK_DGRAM,0);	//create a socket
		
		servaddr.sin_family = AF_INET;	//address family	
		servaddr.sin_addr.s_addr=htonl(INADDR_ANY);	//IP address in the network byte order
		servaddr.sin_port=htons(32000);

		
		bind(sockfd,(struct sockaddr *)&servaddr,sizeof(servaddr));
		len = sizeof(cliaddr);
		
		n=recvfrom(sockfd,mesg,1000,0,(struct sockaddr*)&cliaddr,&len);
		if(!strcmp(mesg,"time")){

			while(1){

				
				time_t rawtime;
				struct tm*timeinfo;
				time(&rawtime);
				timeinfo = localtime(&rawtime);
				//printf("%s",asctime(timeinfo));
				
				strcpy(mesg,asctime(timeinfo));
				printf("%s",mesg);
				sendto(sockfd,mesg,1000,0,(struct sockaddr*)&cliaddr,sizeof(cliaddr));
				mesg[n] = 0;
				memset(mesg,0,strlen(mesg));
				sleep(1);
			
			}
		}
		return 0;

}
