/* Sample UDP server */
#include <sys/socket.h>
#include <netinet/in.h>
#include <string.h>
#include <stdio.h>

int main(int argc, char**argv){

	
		int sockfd,n,status;
		int ack = 1;
		struct sockaddr_in servaddr, cliaddr;
		socklen_t len;
		char mesg[1000];
		char stat[100];
		char buf[12];
		int return_val_sscanf;
		//char* banner = "Hello UDP client! This is UDP server";
		
		sockfd=socket(AF_INET,SOCK_DGRAM,0);	//create a socket
		
		servaddr.sin_family = AF_INET;	//address family	
		servaddr.sin_addr.s_addr=htonl(INADDR_ANY);	//IP address in the network byte order
		servaddr.sin_port=htons(32000);

		/***/

	while(1){
		
		bind(sockfd,(struct sockaddr *)&servaddr,sizeof(servaddr));
		len = sizeof(cliaddr);
		
		n=recvfrom(sockfd,mesg,1000,0,(struct sockaddr*)&cliaddr,&len);
		status = (ack%2);
		return_val_sscanf= sscanf(mesg, "%10s",buf);

		if(!strcmp(buf,"#initial#_")){
			status = 1;
			char tmp[100];
			sscanf(mesg, "%10s %s",buf,tmp );
			memset(mesg,0,strlen(mesg));
			strcpy(mesg,tmp);
			ack = 1;

		}
		sprintf(stat,"%d",status);
		sendto(sockfd,stat,n,0,(struct sockaddr*)&cliaddr,sizeof(cliaddr));
		mesg[n] = 0;
		
		printf("Received: %s\n",mesg);
		printf("ack sent : %s\n",stat );
		ack = ack+1;
		memset(mesg,0,strlen(mesg));
		
	}

		return 0;

}
