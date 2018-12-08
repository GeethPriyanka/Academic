/* Sample UDP server */
#include <sys/socket.h>
#include <netinet/in.h>
#include <string.h>
#include <stdio.h>

int main(int argc, char**argv){

	
		int sockfd,n,wordToNum,i;
		struct sockaddr_in servaddr, cliaddr;
		socklen_t len;
		char mesg[1000];
		char* ack = "ack";
		char* banner = "Hello UDP client! This is UDP server";
		
		sockfd=socket(AF_INET,SOCK_DGRAM,0);	//create a socket
		
		servaddr.sin_family = AF_INET;	//address family	
		servaddr.sin_addr.s_addr=htonl(INADDR_ANY);	//IP address in the network byte order
		servaddr.sin_port=htons(32000);

		/***/

		bind(sockfd,(struct sockaddr *)&servaddr,sizeof(servaddr));
		len = sizeof(cliaddr);
		
		n=recvfrom(sockfd,mesg,1000,0,(struct sockaddr*)&cliaddr,&len);

		wordToNum = atoi(mesg);
		
		sendto(sockfd,ack,strlen(ack),0,(struct sockaddr*)&cliaddr,sizeof(cliaddr));
		mesg[n] = 0;
		
		printf("Received: %s\n",mesg);

	while(wordToNum>0){
		char mesgCap[1000];
		bind(sockfd,(struct sockaddr *)&servaddr,sizeof(servaddr));
		len = sizeof(cliaddr);
		
		n=recvfrom(sockfd,mesg,1000,0,(struct sockaddr*)&cliaddr,&len);
		i=0;
		while(mesg[i]!='\0'){
			mesgCap[i] = toupper(mesg[i]);
			i++;
		}
		
		sendto(sockfd,mesgCap,n,0,(struct sockaddr*)&cliaddr,sizeof(cliaddr));
		mesgCap[n] = 0;
		
		printf("Received: %s\n",mesg);
		wordToNum = wordToNum-1;
		memset(mesgCap,0,strlen(mesgCap));
		memset(mesg,0,strlen(mesg));
	}

		return 0;

}
