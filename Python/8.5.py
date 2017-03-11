fname = raw_input("Enter file name: ")
fh = open(fname)
count = 0
emails = []
for line in fh:
    if not line.startswith("From "): continue
    line = line.split()
    emails.append(line[1])
    count = count + 1
for i in range(len(emails)):
    print emails[i]
print "There were", count, "lines in the file with From as the first word"