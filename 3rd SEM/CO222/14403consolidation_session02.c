//Consolidation session 2
//Wimalasiri KPGP // E14403 // Group 30
//This program print envelops by stars in given sizes

#include <stdio.h>

int main(){
	int size,count,count1,count2,count3,count4,odd;
	printf("Insert envelop size:");
	scanf("%d",&size);
	odd=size%2;
	if(size<=4){
		printf("Invalid input!!");
	}else if(odd==0){
		size=size+3;
		for(count=1;count<=size;count++){
			printf("* ");
		}	
			printf("\n");
		for(count2=0;count2<=(size-6);count2++){
			printf("* ");
				for(count1=1;count1<=(size-(size-count2));count1++){
					printf("  ");
				}
				for(count3=1;count3<=(size-(2*count2+2));count3++){
					printf("* ");
				}
			if((count3-1)>(size-(2*count2+2))){
				for(count4=1;count4<=(size-count1-1);count4++){
					printf("  ");
				}
			}else{
				for(count4=1;count4<=(size-(size-count2));count4++){
					printf("  ");
				}
			}
				printf("* ");
				printf("\n");
		}		
			for(count=1;count<=size;count++){
				printf("* ");
			}
	}else{
		size=size+2;
		for(count=1;count<=size;count++){
			printf("* ");
		}	
			printf("\n");
		for(count2=0;count2<=(size-5);count2++){
			printf("* ");
				for(count1=1;count1<=(size-(size-count2));count1++){
					printf("  ");
				}
				for(count3=1;count3<=(size-(2*count2+2));count3++){
					printf("* ");
				}
			if((count3-1)>(size-(2*count2+2))){
				for(count4=1;count4<=(size-count1-1);count4++){
					printf("  ");
				}
			}else{
				for(count4=1;count4<=(size-(size-count2));count4++){
					printf("  ");
				}
			}
				printf("* ");
				printf("\n");
		}
			for(count=1;count<=size;count++){
			printf("* ");
			}
	}
	
	return 0;
}