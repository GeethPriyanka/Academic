#include <stdio.h>

int main(){
	int size,count1,count3,count4;
	scanf("%d",&size);

	for(count1=1;count1<=size;count1++){

		
			for(count3=1;count3<=size-count1;count3++){

				printf("   ");
			}

			for(count4=1;count4<=count1;count4++){
				printf("%3d",count4);
			}

			printf("\n");


	}


	return 0;
}