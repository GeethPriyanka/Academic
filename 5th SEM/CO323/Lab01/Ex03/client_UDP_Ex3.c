/* Sample UDP client */
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <stdio.h>
#include <string.h>


int main(int argc, char**argv){
	int sockfd,n,wordsToNum,i;
	struct sockaddr_in servaddr;
	char sendline[] = "Hello UDP server! This is UDP client";
	char recvline[1000];

	char number[10]; 

	if (argc != 3){
		printf("usage:%s <IP address> <number of words>\n",argv[0]);
		return -1;
	}
	strcpy(number,argv[2]) ;
	wordsToNum = atoi(number);
	
	/***/
	sockfd=socket(AF_INET,SOCK_DGRAM,0);
	
	bzero(&servaddr,sizeof(servaddr));

	servaddr.sin_family = AF_INET;
	servaddr.sin_addr.s_addr=inet_addr(argv[1]);
	servaddr.sin_port=htons(32000);
	/***/
		
	sendto(sockfd,number,strlen(number),0,(struct sockaddr*)&servaddr,sizeof(servaddr));

	n=recvfrom(sockfd,recvline,10000,0,NULL,NULL);

	if(!strcmp(recvline,"ack")){
		
		recvline[n]=0;
		printf("Received: %s\n",recvline);

		for(i=0;i<wordsToNum;i++){
			char sendline1[100];
			scanf("%s",sendline1);
			
			sendto(sockfd,sendline1,strlen(sendline1),0,(struct sockaddr*)&servaddr,sizeof(servaddr));
			n=recvfrom(sockfd,recvline,10000,0,NULL,NULL);
			recvline[n]=0;
			printf("Capitalized: %s\n",recvline);
		}

	}

	
	return 0;

	
	

	
	
}
