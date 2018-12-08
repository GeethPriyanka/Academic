import matplotlib
import numpy as np
import matplotlib.pyplot as plt
matrix = np.array([0,1,2,3,4,5,6,7,8,9,10])
#print(matrix)
step = np.random.randint(0,2)
if step == 0:
    num = matrix[0]
else:
    num = matrix[10] 

P = [0 for i in range(500)]
for x in range (500):
         
    step = np.random.randint(0,2)

    if step==1:
        num += 1
    else:
        num -= 1
    num = num%11
    
    P[x] = matrix[num]
    #P.append(x,matrix[num])
    
    #print(x," ",matrix[num])
plt.plot(P)
plt.show()