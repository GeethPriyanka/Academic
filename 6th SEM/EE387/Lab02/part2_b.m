clear all;
close all;

X = -50:1:50;
xn = ((0.5).^(X)).*uStep(X);
hn = uStep(X);

yn = convolution(xn,hn);

subplot(3,1,1);
stem(X,xn);
title('Graph of x[n]');

subplot(3,1,2);
stem(X,hn);
title('Graph of h[n]');

subplot(3,1,3);
stem(yn);
title('Graph of x[n]');