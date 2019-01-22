clear all;
close all;

fp = 1000;

sampleRate = 70000;

N = 4;

Wn = 2*pi*fp/(sampleRate/2); 

[num,den] = butter(N,Wn,'s');

H=tf(num,den)

bode(H)


