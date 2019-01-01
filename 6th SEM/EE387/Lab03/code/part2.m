clear all;
close all;

b = [2 2 17];   % Numerator coefficients
a = [1 4 104];  % Demoninator coefficients
omega = linspace(-20,20,200); % taking 200 points between -20 and 20
H = freqs(b,a,omega);   %evaluate the frequency response of a Laplace transform.

magnitude = abs(H); % taking the absolute value
phase = angle(H);   % taking the phase
phaseDegree = phase*180/pi; % converting phase from radians to degree

subplot(2,1,1);
plot(omega,magnitude);      % plotting the magnitude 
title('Magnitude of the frequency response')
xlabel('omega')
ylabel('magnitude(units)')

subplot(2,1,2);
plot(omega, phaseDegree);   % plotting the phase
title('Phase of the frequency response')
xlabel('omega')
ylabel('phase(degree)')

figure
h = tf(b,a);    % taking denominator and the nominator for bode function
bode(h,omega)   % plotting the bode diagram