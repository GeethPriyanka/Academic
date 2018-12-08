/*
Author:K.P.G.P.Wimalasiri / E/14/403 / CO222 / lab 02
**This program shows the winner of Scissor paper rock lizard spoak game.
Input C-Scissor P-Paper R-Rock L-Lizard S-Spoak (Only the uppercase) for 
player 1 & 2 respectively.**
*/
#include<stdio.h>

int main(){
	char p_1,p_2;
	scanf("%c %c",&p_1,&p_2);	
	if(p_1==76 || p_1==82 || p_1==80 || p_1==83 || p_1==67){
		if(p_2==76 || p_2==82 || p_2==80 || p_2==83 || p_2==67){
			if(p_1==p_2){
				printf("Tie");
			}else if(p_1==82){
				if(p_2==76 || p_2==67){
					printf("Player 1 wins");
				}else{
					printf("Player 2 wins");
				}
			}else if(p_1==80){
				if(p_2==82 || p_2==83){
					printf("Player 1 wins");
				}else{
					printf("Player 2 wins");
				}
			}else if(p_1==67){
				if(p_2==80 || p_2==76){
					printf("Player 1 wins");
				}else{
					printf("Player 2 wins");
				}
			}else if(p_1==83){
				if(p_2==82 || p_2==67){
					printf("Player 1 wins");
				}else{
					printf("Player 2 wins");
				}
			}else{
				if(p_2==80 || p_2==83){
					printf("Player 1 wins");
				}else{
					printf("Player 2 wins");
				}
			}
		}else{
			printf("Wrong input");
		}
	}else{
		printf("Wrong input");
	}
		
	return 0;
}