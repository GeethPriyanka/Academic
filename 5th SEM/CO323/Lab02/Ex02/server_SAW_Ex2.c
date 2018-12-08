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
		char ACK_1[]= "#1#_";
		char ACK_0[]= "#0#_";
		char ACK_STAT0[]="0";
		char ACK_STAT1[]="1";
		char mesg[1000];
		char stat[100];
		char buf[5];
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
		// status = (ack%2);
		char tmp[100];
		sscanf(mesg, "%4s %s",buf,tmp );
		
		
		if(!strcmp(buf,ACK_1)){
			memset(mesg,0,strlen(mesg));
			strcpy(mesg,tmp);
			printf("Received: %s\n",mesg);
			sendto(sockfd,ACK_STAT1,n,0,(struct sockaddr*)&cliaddr,sizeof(cliaddr));
			printf("ack sent : %s\n",ACK_STAT1);
		}else if(!strcmp(buf,ACK_0)){
			memset(mesg,0,strlen(mesg));
			strcpy(mesg,tmp);
			printf("Received: %s\n",mesg);
			sendto(sockfd,ACK_STAT0,n,0,(struct sockaddr*)&cliaddr,sizeof(cliaddr));
			printf("ack sent : %s\n",ACK_STAT0);
		}else{
			printf("Some Error Occured!\n");
			return -1;
		}
		
	}

		return 0;

}
