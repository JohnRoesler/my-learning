fname = raw_input("Enter file name: ")
if len(fname) < 1: fname = "mbox-short.txt"
fh = open(fname)
ecount = dict()
maxsender = ""
maxcount = 0
for line in fh:
    if not line.startswith("From "): continue
    line = line.split()
    ecount[line[1]] = ecount.get(line[1],0)+1
#for sender in ecount:
    #if not ecount[sender] > maxcount: continue
    #maxcount = ecount[sender]
    #maxsender = sender
#print maxsender, maxcount
print max(ecount,key=ecount.get), max(ecount.values())