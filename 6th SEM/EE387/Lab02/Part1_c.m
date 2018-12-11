clear all;
close all;

figure

subplot(3,3,1)
X = 0:1:100;
Y1= [cos(0*X)];
stem(Y1);
title('x[n] = cos(0.n)');

subplot(3,3,2)
Y2= [cos(pi*X/8)];
stem(X,Y2);
title('x[n] = cos(pi*n/8)');

subplot(3,3,3)
Y3= [cos(pi*X/4)];
stem(X,Y3);
title('x[n] = cos(pi*n/4)');

subplot(3,3,4)
Y4= [cos(pi*X/2)];
stem(X,Y4);
title('x[n] = cos(pi*n/2)');

subplot(3,3,5)
Y5= [cos(pi*X)];
stem(X,Y5);
title('x[n] = cos(pi*n)');

subplot(3,3,6)
Y6= [cos(3*pi*X/2)];
stem(X,Y6);
title('x[n] = cos(3*pi*n/2)');

subplot(3,3,7)
Y7= [cos(7*pi*X/4)];
stem(X,Y7);
title('x[n] = cos(7*pi*n/4)');

subplot(3,3,8)
Y8= [cos(15*pi*X/8)];
stem(X,Y8);
title('x[n] = cos(15*pi*n/8)');

subplot(3,3,9)
Y9= [cos(2*pi*X)];
stem(X,Y9);
title('x[n] = cos(2*pi*n)');








