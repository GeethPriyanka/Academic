import re
from sklearn import tree

f = open("trainset.txt","r")
#contents = f.read()
#print(contents)
X = []
Y = []

f_line = f.readlines()

for x in f_line:
	values = x.split("\t")
	class_value = values[0]
	Y.append(class_value)
	data = values[1:3]
	X.append(data)

#print(X)

#print(data)
