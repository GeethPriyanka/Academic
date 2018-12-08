/* Sample UDP client */
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <stdio.h>
#include <string.h>


int main(int argc, char**argv){
	int sockfd,n,i,stat=1,stat_recv,can_send=1,set=1;
	struct sockaddr_in servaddr;
	
	char recvline[1000];
	char initial_sign[]="#initial#_";

	//check for input arguments	
	if (argc != 2){
		printf("usage:%s <IP address> \n",argv[0]);
		return -1;
	}
	
	/***/
	sockfd=socket(AF_INET,SOCK_DGRAM,0);
	
	bzero(&servaddr,sizeof(servaddr));

	servaddr.sin_family = AF_INET;
	servaddr.sin_addr.s_addr=inet_addr(argv[1]);
	servaddr.sin_port=htons(32000);
	/***/

	//Sending initial packet
	char sendline1[100];
	printf("Type message here :");
	scanf("%s",sendline1);
	strcat(initial_sign,sendline1);
	sendto(sockfd,initial_sign,strlen(initial_sign),0,(struct sockaddr*)&servaddr,sizeof(servaddr));

	//receiving initial packet 
	n=recvfrom(sockfd,recvline,10000,0,NULL,NULL);
	printf("ack received : %s\n", recvline);
	stat_recv = atoi(recvline);
	recvline[n]=0;

	while(1){
		if(stat_recv == can_send){
			char sendline1[100];
			printf("Type message here :");
			scanf("%s",sendline1);
			sendto(sockfd,sendline1,strlen(sendline1),0,(struct sockaddr*)&servaddr,sizeof(servaddr));
			set =1;
		}else{
			printf("some error occured\n");
			break;
		}
		while(set){
			n=recvfrom(sockfd,recvline,10000,0,NULL,NULL);
			if(n!=0){
				stat_recv = atoi(recvline);
				printf("ack received : %s\n", recvline);
				recvline[n]=0;
				stat = stat+1;
				can_send = stat%2;
				set = 0;
			}
		}

	}	
	
	return 0;
	
}
