#include <stdio.h>
#include <math.h>

int main(){
	int y, count, p, x1, x2, R  ;
	printf("Enter the radius :");
	scanf("%d",&R);
	for(y=1;y<=(3*R);y++){
		p=3*R*y-pow(y,2);
		x1=(4*R-sqrt(p));
		x2=(4*R+sqrt(p));
		
			for(count=0;count<x1;count++){
				putchar(' ');
			}
			for(count=x1;count<x2;count++){
				putchar('*');
			}
			for(count=x2;x2<count;count++){
				putchar(' ');	
			}
			
		putchar('\n');
	}
	
	
	
	return 0;
}
