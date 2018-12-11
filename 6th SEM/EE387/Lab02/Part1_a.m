clear all;
close all;


subplot(2,2,1)
X = 0:1:20;
B = -1.2;
Y1= [10*B.^X];
stem(Y1);
title('beta < -1');

subplot(2,2,2)
B = -0.8;
Y2= [10*B.^X];
stem(Y2);
title('-1 < beta < 0');

subplot(2,2,3)
B = 0.8;
Y3= [10*B.^X];
stem(Y3);
title('0 < beta < 1');

subplot(2,2,4)
B = 1.2;
Y4= [10*B.^X];
stem(Y4);
title('1 < beta');