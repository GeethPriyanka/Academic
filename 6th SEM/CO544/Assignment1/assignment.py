import re #regex
from nltk.corpus import stopwords
from nltk.stem import PorterStemmer

f = open("trainset.txt","r")		#opening the text file for reading
#contents = f.read()
#print(contents)
lines = f.readlines()		#reading text file into an array

Y = []
i = 0

while i < len(lines):		#doing following operation line by line
	X = lines[i].split('\t')		#split by the tab (four main attributes '<CLASS> \t <TITLE> \t <DATE> \t <BODY>')
	Y.append([])		#2D array
	for j in range(4):
		Y[i].append(X[j])		#appending all four attributes to each line
	i+=1

def preprocess(attribute):
      
    attribute = re.sub(r'([^\s\w]|_)+', '', attribute) #Remove all the special characters except space
    attribute = re.sub(r'\s+', ' ', attribute, flags=re.I)	#Substituting multiple spaces with single space
    attribute = attribute.lower()

    all_words = attribute.split()
    en_stops = set(stopwords.words('english')) #stopwords for english
    attribute = ""
    ps = PorterStemmer() 

    for word in all_words: 
        if word not in en_stops:   
            attribute +=  ps.stem(word) +" "

    return attribute


YProcessed = [] 
i = 0

while i <len(lines):
    YProcessed.append([])
    YProcessed[i].append(Y[i][0])

    processedEliment1= preprocess(Y[i][1])
    processedEliment2= preprocess(Y[i][2])
    processedEliment3= preprocess(Y[i][3])
    
    AllEliments = processedEliment1+processedEliment2+processedEliment3 #combine attributes
    
    listOfAttributesProcessed[i].append(AllEliments)

#    print(listOfAttributesProcessed[i])  
    i+=1