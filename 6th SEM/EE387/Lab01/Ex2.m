y = [1 2 2.5 3 3 3 2 1 0 0 0 0 0 0 0];
x = 0:3;
h = impulse(x);
x_gen = deconv(y,h);

subplot(3,1,1);
stem(x_gen)
ylabel('x generated');
subplot(3,1,2);
stem(h)
ylabel('h');
subplot(3,1,3);
stem(y)
ylabel('y');