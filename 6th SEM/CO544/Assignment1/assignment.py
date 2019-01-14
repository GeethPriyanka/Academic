import re 
import nltk
#nltk.download()
from nltk.corpus import stopwords
from nltk.stem import PorterStemmer
import csv
import numpy as np
import pandas as pd
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.model_selection import train_test_split
from sklearn.naive_bayes import MultinomialNB
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.metrics import classification_report
from sklearn import metrics

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
      
    attribute = re.sub(r"[^a-zA-Z0-9]+", ' ', attribute)	#Remove all the special characters except space
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

    title= preprocess(Y[i][1])
    date= preprocess(Y[i][2])
    body= preprocess(Y[i][3])
    
    YProcessed[i].append(title+date+body)

    #print(YProcessed[i])  
    i+=1


with open("YProcessed.csv", "w") as file:
    writer = csv.writer(file)
    writer.writerows(YProcessed)


df=pd.read_csv('YProcessed.csv',sep=',',names=['class','data'])
df_x=df["data"]
df_y=df["class"]
x_train, x_test, y_train, y_test = train_test_split(df_x, df_y, test_size=0.333, random_state=0)

cv = TfidfVectorizer(min_df=0.05, max_df=0.8) 
x_traincv=cv.fit_transform(x_train)

clf = MultinomialNB()
clf.fit(x_traincv,y_train)
x_testcv=cv.transform(x_test)
predictions=clf.predict(x_testcv)

actual=np.array(y_test)
accuracy = metrics.accuracy_score(actual, predictions)
print('Accuracy: ',accuracy)

text_file = open("testsetwithoutlabels.txt", "r")
test_line = text_file.readlines()
test=cv.transform(test_line)
predict=clf.predict(test)

#output = open("e14403.txt","w+")

i=0
while i < len(test_line):
    #f.write("%f" %predict[i])
    print(predict[i])
    i+=1

