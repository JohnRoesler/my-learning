fname = "2016VAERSData.csv"
fh = open(fname)
headers = []
mydictionary = dict()
for line in fh:
    if not line.startswith("VAERS_ID"): continue
    line = line.strip()
    line = line.split(",")
    headers = line
    for header in headers:
        mydictionary[header] = None
print mydictionary