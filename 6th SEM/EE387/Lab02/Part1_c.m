figure

subplot(3,3,1)
X = linspace(-2*pi,2*pi,50)';
Y1= [cos(0*X)];
stem(Y1);
title('x[n] = cos(0.n)');

subplot(3,3,2)
X = linspace(-2*pi,2*pi,50)';
Y2= [cos(pi*X/8)];
stem(Y2);
title('x[n] = cos(pi*n/8)');

subplot(3,3,3)
X = linspace(-2*pi,2*pi,50)';
Y3= [cos(pi*X/4)];
stem(Y3);
title('x[n] = cos(pi*n/4)');

subplot(3,3,4)
X = linspace(-2*pi,2*pi,50)';
Y4= [cos(pi*X/2)];
stem(Y4);
title('x[n] = cos(pi*n/2)');

subplot(3,3,5)
X = linspace(-2*pi,2*pi,50)';
Y5= [cos(pi*X)];
stem(Y5);
title('x[n] = cos(pi*n)');

subplot(3,3,6)
X = linspace(-2*pi,2*pi,50)';
Y6= [cos(3*pi*X/2)];
stem(Y6);
title('x[n] = cos(3*pi*n/2)');

subplot(3,3,7)
X = linspace(-2*pi,2*pi,50)';
Y7= [cos(7*pi*X/4)];
stem(Y7);
title('x[n] = cos(7*pi*n/4)');

subplot(3,3,8)
X = linspace(-2*pi,2*pi,50)';
Y8= [cos(15*pi*X/8)];
stem(Y8);
title('x[n] = cos(15*pi*n/8)');

subplot(3,3,9)
X = linspace(-2*pi,2*pi,50)';
Y9= [cos(2*pi*X)];
stem(Y9);
title('x[n] = cos(2*pi*n)');








