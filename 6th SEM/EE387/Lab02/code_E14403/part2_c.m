clear all;
close all;

xn = [1 1 1 1 1 0 0 0 0 0 0 0 0 0 0];
hn = [2 4 8 16 32 64 0 0 0 0 0 0 0 0 0];

yn = convolution(xn,hn);
yn2 = conv(xn,hn);

subplot(4,1,1);
stem(xn);
title('Graph of x[n]');

subplot(4,1,2);
stem(hn);
title('Graph of h[n]');

subplot(4,1,3);
stem(yn);
title('Graph of convolution(x[n],h[n])');

subplot(4,1,4);
stem(yn2);
title('Graph of conv(x[n],h[n])');