clear all;
x1 = [1,2,4];
h1 = [1,1,1,1,1];
y1 = conv(x1,h1);
subplot(3,3,1);
stem(x1)
title('Group 1:x1=[1,2,4] & h1=[1,1,1,1,1]');
ylabel('x1');
subplot(3,3,4);
stem(h1)
ylabel('h1');
subplot(3,3,7);
stem(y1)
ylabel('y1');


x2 = [1,2,3,4,5];
h2 = [1];
y2 = conv(x2,h2);
subplot(3,3,2);
stem(x2)
title('Group 2:x2=[1,2,3,4,5] & h2=[1]');
ylabel('x2');
subplot(3,3,5);
stem(h2)
ylabel('h2');
subplot(3,3,8);
stem(y2)
ylabel('y2');


x3 = [1,2,0,2,1];
h3 = [1,2,0,2,1];
y3 = conv(x3,h3);
subplot(3,3,3);
stem(x3)
title('Group 3:x3=[1,2,0,2,1] & h3 = [1,2,0,2,1]');
ylabel('x3');
subplot(3,3,6);
stem(h3)
ylabel('h3');
subplot(3,3,9);
stem(y3)
ylabel('y3');