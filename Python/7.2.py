fname = raw_input("Enter file name: ")
fh = open(fname)
total = 0
count = 0
for line in fh:
    if not line.startswith("X-DSPAM-Confidence:"): 
        continue
    line = line.strip()
    count = count + 1
    total = total + float(line[line.find(":")+2:])
avg = total/count
print "Average spam confidence:",avg