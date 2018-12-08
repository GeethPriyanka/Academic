/* Sample UDP client */
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <stdio.h>
#include <string.h>
#include <time.h>


int main(int argc, char**argv){
	int sockfd,n,i,stat_recv,can_send=1,set=1,counter=1;
	struct sockaddr_in servaddr;
	char recvline[1000];
	char acknum_appended[5];
	time_t start_t,end_t;
	double diff_t;
	char send_new[100];
	char ACK_1[]= "#1#_";
	char ACK_0[]= "#0#_";
	char ACK[]="#1#_";


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

	


	
	while(1){

		if(counter%2==1){
			strcpy(ACK,ACK_1);
		}else{
			strcpy(ACK,ACK_0);
		}

		printf("Type message here :");
		scanf("%s",send_new);
		strcpy(acknum_appended,ACK);
		strcat(acknum_appended,send_new);
		sendto(sockfd,acknum_appended,strlen(acknum_appended),0,(struct sockaddr*)&servaddr,sizeof(servaddr));

		n=0;
		while(1){	
			//timer starts now
			time(&start_t);
			while(diff_t<2 && n==0){
				n=recvfrom(sockfd,recvline,10000,0,NULL,NULL);
				time(&end_t);
				diff_t=difftime(end_t,start_t);
			}

			if(n!=0){
				stat_recv = atoi(recvline);
				if(stat_recv==counter%2){
					printf("ack received : %s\n", recvline);
					recvline[n]=0;
					break;
				}
				
			}else{
				printf("Resending....\n");
				sendto(sockfd,acknum_appended,strlen(acknum_appended),0,(struct sockaddr*)&servaddr,sizeof(servaddr));
			}
		}

		


		counter++;

	}	
	
	return 0;
	
}
