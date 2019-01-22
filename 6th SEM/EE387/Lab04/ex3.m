clear all; 
close all;

sampleRate = 70000;

N = 4;

Rp = 2;

fp = 1000;

Wn = 2*pi*fp/(sampleRate/2); 

[num,den] =	chebyl(N,Rp,Wn,'s');

H=tf(num,den)

bode(H)
