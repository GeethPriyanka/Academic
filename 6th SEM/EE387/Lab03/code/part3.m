clear all;
close all;

omega = linspace(-20,20,200);
sigma = linspace(-5,5,200);
b = [2 2 17];   % Numerator coefficients from part 2
a = [1 4 104];  % Demoninator coefficients from part 2

[sigmagrid,omegagrid] = meshgrid(sigma,omega);

sgrid = sigmagrid+j*omegagrid;

H1 = polyval(b,sgrid)./polyval(a,sgrid);
mesh(sigma,omega,20*log10(abs(H1)));