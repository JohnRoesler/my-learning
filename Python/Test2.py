import string
fname = raw_input("Enter file name: ")
if len(fname)<1: fname = "words.txt"
fh = open(fname)
wordcount = dict()
#put all words into dictionary with count of each word
for line in fh:
    line = line.translate(None, string.punctuation)
    line = line.lower()
    words = line.split()
    for word in words:
        if word not in wordcount:
            wordcount[word] = 1
        else: wordcount[word] += 1
#sort words by count and print top 10
lst = list()
for key,val in wordcount.items():
    lst.append((val,key))
lst.sort(reverse=True)
for key,val in lst[:10]:
    print key,val