/* This is a bitmap image color inverting program.
	Author	:	WIMALASIRI KPGP ; E/14/403
	Subject	:	CO-222 ; Lab03
	Date	:	05/02/2017
*/

#include<stdio.h>

int main(){

	int var1, var2, count, count1, count2, r, g, b, padval, pad1;

		scanf("%d %d", &var1, &var2);
		printf("%d %d\n",var1,var2);

			for(count=1;count<=var2;count++){

				for(count1=1;count1<=var1;count1++){

					scanf("%d %d %d\n",&r,&g,&b);

					b = 255-b;
					g = 255-g;
					r = 255-r;
					
					printf("%d %d %d\n",r,g,b);
				}
					padval = 4-((3*var1)%4);

			if(padval==4){

			}else{
				for(count2=1;count2<=padval;count2++){

					scanf("%d\n",&pad1);
					printf("%d\n",pad1);
				}				
			}
			}

	return 0;
}
