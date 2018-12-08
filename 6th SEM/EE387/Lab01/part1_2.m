clear all;
Ts=0.01; t= -5:Ts:5;
x1 = 3*exp(-t);
x2 = cos(4*pi*t);
x = x1.*x2;
h = hilbert(x);
hold on;
plot(t, x, 'k');grid
plot(t,-abs(h),'b', t,abs(h),'b');
hold off;
