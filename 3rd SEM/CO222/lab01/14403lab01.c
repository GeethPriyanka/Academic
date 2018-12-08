// Author: K.P.G.P. Wimalasiri (E/14/403)
#include <stdio.h>
	int main(){
		int var1;
		float var2;
		
		scanf("%d",&var1);
		
			if (var1<0)
			{
				printf("-1");
				}
			else if (var1<=30)
			{
				var2 = (30.00+(2.50*var1));
				printf("%.2f\n",var2);
				}
			else if (var1<=60)
			{
				var2 = (60.00+(2.50*30)+(4.85*(var1-30)));
				printf("%.2f\n",var2);
				}
			else if (var1<=90)
			{	
				var2 = (90.00+(7.85*60)+(10.00*(var1-60)));
				printf("%.2f\n",var2);
				}
			else if (var1<=120)
			{
				var2 = (90.00+(7.85*60)+(10.00*30)+(27.75*(var1-90)));
				printf("%.2f\n",var2);
				}
			else if (var1<=180)
			{
				var2 = (90.00+(7.85*60)+(10.00*30)+(27.75*30)+(32.00*(var1-120)));
				printf("%.2f\n",var2);
				}
			else
			{
				var2 = (90.00+(7.85*60)+(10.00*30)+(27.75*30)+(32.00*60)+(45.00*(var1-180)));
				printf("%.2f\n",var2);
				}
			
		return 0 ;
	}