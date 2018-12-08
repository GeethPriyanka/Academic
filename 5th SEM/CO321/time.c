#include <stdio.h>
#include <stdlib.h>

int Hz = 16;
int p[4] = {8,64,256,1024};

double cal(float inNum,int n,int len){
	double clock = inNum/(p[n])*Hz;
	clock = len - clock;
	//printf("%f\n",clock );
	return clock;
}

int main(int argc, char const *argv[])
{
	
	if (argc != 4){
		printf("Invalid Input\n time <period> <scale> <timer>\n scale : 1-us , 2-ms , 3-s\ntimer : 0,1,2\n");
		return 0;
	}	
	else{
		
		int len = 256,x=1,inScale,inTim;
		double max[4] = {0,0,0,0},inNum;

		inNum = atof(argv[1]);
		inScale = atoi(argv[2]);
		inTim = atoi(argv[3]);
		if(inTim == 1) len = 65535;
		if(inScale==2) inNum = inNum * 1000;
		else if(inScale==3) inNum= inNum * 1000000;
		//printf("%f\n",inNum );

		for (int i = 0; i < 4; i++)
		{
			/* code */
			max[i] = p[i] * len / Hz;

		}
/*
		for (int i = 0; i < 4; i++)
		{
			printf("Max for prescale %d : %f us\n",p[i],max[i] );
		}
*/
		if(inNum<=max[0]){
			double clock = cal(inNum,0,len);
			
			printf("prescale : 8\nclock : %.0f\n", clock);
		}else if(inNum>max[0] && inNum<=max[1]){
			
			double clock = cal(inNum,1,len);
			
			printf("prescale : 64\nclock : %.0f\n", clock);
		}else if(inNum>max[1] && inNum<=max[2]){
			double clock = cal(inNum,2,len);
			
			printf("prescale : 256\nclock : %.0f\n", clock);
		}else if(inNum>max[2] && inNum<=max[3]){
			double clock = cal(inNum,3,len);
			
			printf("prescale : 1024\nclock : %.0f\n", clock);
		}else{
			printf("Out of size\n");
		}


	}

	return 0;
}