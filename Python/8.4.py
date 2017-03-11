fname = raw_input("Enter file name: ")
fh = open(fname)
words = []
for line in fh:
    line = line.split()
    for i in range(len(line)):
        if line[i] in words: continue
        words.append(line[i])
words.sort()
print words