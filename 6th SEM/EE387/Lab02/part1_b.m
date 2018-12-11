clear all;
close all;

subplot(2,1,1)
hold on;

Xn = 0:5:100;
Y1= [cos(2*pi*Xn/12)];
stem(Xn,Y1);
Xt = 0:0.01:100;
Y2= [cos(2*pi*Xt/12)];
plot(Xt,Y2,'r');
title('x[n] = cos(2*pi*n/12)and x(t) = cos(2*pi*t/12)');

subplot(2,1,2)
hold on;
Y3 = [cos(8*pi*Xn/12)];
stem(Xn,Y3);
Y4= [cos(8*pi*Xt/12)];
plot(Xt,Y4,'r');
title('x[n] = cos(8*pi*n/31)and x(t) = cos(8*pi*t/31)');