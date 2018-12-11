import matplotlib.pyplot as plt
import numpy as np

def fourier_series(t,N):
    
    im = 1j
    w0 = np.pi/2
    result = (1/4) * np.cos(w0*t*0)#dc component
    
    for k in range(1,N+1):
        result = result + (1/2) * np.cos(w0*t*k) * np.sin(w0*k)/(w0*k) # RE{ak exp(jkwt)}, IM is zero
        
    return result*2

t1 = np.arange(-2.0, 2.0, 0.01)

plt.figure(1)
xt = fourier_series(t1,1)
plt.plot(t1, xt, 'r')
plt.plot(t1, t1*0, 'g')
plt.plot(t1, t1*0+1, 'g')
plt.ylabel('x(t)')
plt.xlabel('t')
plt.title('N=1')
print('Overshoot value:',(np.max(xt)-1)*100,'%')

plt.figure(2)
xt = fourier_series(t1,3)
plt.plot(t1, xt, 'r')
plt.plot(t1, t1*0, 'g')
plt.plot(t1, t1*0+1, 'g')
plt.ylabel('x(t)')
plt.xlabel('t')
plt.title('N=3')
print('Overshoot value:',(np.max(xt)-1)*100,'%')

plt.figure(3)
xt = fourier_series(t1,7)
plt.plot(t1, xt, 'r')
plt.plot(t1, t1*0, 'g')
plt.plot(t1, t1*0+1, 'g')
plt.ylabel('x(t)')
plt.xlabel('t')
plt.title('N=7')
print('Overshoot value:',(np.max(xt)-1)*100,'%')

plt.figure(4)
xt = fourier_series(t1,19)
plt.plot(t1, xt, 'r')
plt.plot(t1, t1*0, 'g')
plt.plot(t1, t1*0+1, 'g')
plt.ylabel('x(t)')
plt.xlabel('t')
plt.title('N=19')
print('Overshoot value:',(np.max(xt)-1)*100,'%')

plt.figure(5)
xt = fourier_series(t1,43)
plt.plot(t1, xt, 'r')
plt.plot(t1, t1*0, 'g')
plt.plot(t1, t1*0+1, 'g')
plt.ylabel('x(t)')
plt.xlabel('t')
plt.title('N=43')
print('Overshoot value:',(np.max(xt)-1)*100,'%')

plt.figure(6)
xt = fourier_series(t1,79)
plt.plot(t1, xt, 'r')
plt.plot(t1, t1*0, 'g')
plt.plot(t1, t1*0+1, 'g')
plt.ylabel('x(t)')
plt.xlabel('t')
plt.title('N=73')
print('Overshoot value:',(np.max(xt)-1)*100,'%')