clear all;
close all;

syms t;
syms s; % make s and t symbolic

Hs0 = (s - 1)/(s.^2 + 2*s + 2);
Hs1 = (s + 5)/(s.^2 + 2*s + 3);
Hs2 = (2*s.^2 + 5*s + 12)/(s.^2 + 2*s + 10);
Hs3 = (2*s.^2 + 5*s + 12)/(s.^3 + 4*s.^2 + 14*s + 20);

x1 = sin(2*pi*(403*1*10^3)*t);
x2 = sin(2*pi*(403*2*10^3)*t);
x3 = sin(2*pi*(403*3*10^3)*t);  % 3 inputs

xs1 = laplace(x1);
xs2 = laplace(x2);
xs3 = laplace(x3);  % taking laplace of 3 inputs

fprintf('For system 0\n');
y1 = ilaplace(xs1*Hs0)
y2 = ilaplace(xs2*Hs0)
y3 = ilaplace(xs3*Hs0)  % multiply and taking inverse laplace transform 

fprintf('For system 1\n');
y1 = ilaplace(xs1*Hs1)
y2 = ilaplace(xs2*Hs1)
y3 = ilaplace(xs3*Hs1) % multiply and taking inverse laplace transform 

fprintf('For system 2\n');
y1 = ilaplace(xs1*Hs2)
y2 = ilaplace(xs2*Hs2)
y3 = ilaplace(xs3*Hs2) % multiply and taking inverse laplace transform 

fprintf('For system 3\n');
y1 = ilaplace(xs1*Hs3)
y2 = ilaplace(xs2*Hs3)
y3 = ilaplace(xs3*Hs3) % multiply and taking inverse laplace transform 