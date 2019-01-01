clear all;
close all;

omega = linspace(-20,20,200); % taking 200 points between -20 and 20

b0 = [1 -1]; % Numerator coefficients
a0 = [1 2 2]; % Demoninator coefficients

b1 = [1 5]; % Numerator coefficients
a1 = [1 2 3]; % Demoninator coefficients

b2 = [2 5 12]; % Numerator coefficients
a2 = [1 2 10]; % Demoninator coefficients

b3 = [2 5 12]; % Numerator coefficients
a3 = [1 4 14 20]; % Demoninator coefficients

h0 = tf(b0,a0); % taking denominator and the nominator for bode function
subplot(2,2,1);
bode(h0,omega)

h1 = tf(b1,a1); % taking denominator and the nominator for bode function
subplot(2,2,2);
bode(h1,omega)

h2 = tf(b2,a2); % taking denominator and the nominator for bode function
subplot(2,2,3);
bode(h2,omega)

h3 = tf(b3,a3); % taking denominator and the nominator for bode function
subplot(2,2,4);
bode(h3,omega)
