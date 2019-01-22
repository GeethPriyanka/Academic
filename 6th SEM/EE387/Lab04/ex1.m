clear all;
close all;

fp = 1000;
fs = 5000;

sampleRate = 70000;  %it is assumed that sampling rate is 70kHz

Wp = 2*pi*fp/(sampleRate/2); 
Ws = 2*pi*fs/(sampleRate/2);

[n,Wn] = buttord(Wp,Ws,3,60);

[num,den] = butter(n,Wn,'s');

H=tf(num,den)

bode(H)

