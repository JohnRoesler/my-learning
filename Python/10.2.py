#open the text file & create dictionary
fname = raw_input("Enter file name: ")
if len(fname) < 1 : fname = "mbox-short.txt"
fhandle = open(fname)
hcount = dict()
#loop through file, split text, and populate dictionary with hour & count
for line in fhandle:
    if not line.startswith("From "): continue
    line = line.split()
    time = line[5].split(":")
    hour = time[0]
    if hour not in hcount: hcount[hour] = 1
    else: hcount[hour] += 1
#loop through dictionary, move tuples into list, and sort by hour and print key and value
lst = list()
lst = sorted([(key,val) for key,val in hcount.items()])
for key,val in lst:
    print key, val