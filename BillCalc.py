#import anything needed
import glob
import csv
#Create a dictionary full of dictionaries for each person with usage bill and one for total
listnames = ["Dad","Mom","Marcus","Noah","Joseph","John","Total"]
resultdict = {x:{} for x in listnames}
#Define billing usage buckets as: usage limit, cost in dollars
minutes = dict()
minutes['small'] = (100,3.0)
minutes['medium'] = (500,9.0)
minutes['large'] = (1000,18.0)
minutes['xlarge'] = (2100,35.0)
minutes['extra'] = (2100,0.019)
messages = dict()
messages['small'] = (100,3.0)
messages['medium'] = (1000,5.0)
messages['large'] = (2000,8.0)
messages['xlarge'] = (4100,11.0)
messages['extra'] = (4100,0.0025)
megabytes = dict()
megabytes['small'] = (100,3.0)
megabytes['medium'] = (500,12.0)
megabytes['large'] = (1000,19.0)
megabytes['xlarge'] = (2000,29.0)
megabytes['extra'] = (2000,0.015)
device = 6
allowedvariance = 0
#Take bill information as inputs: total bill, fees - ADD ERROR CHECKING
resultdict["Total"]["costtotal"] = float(raw_input("Please enter the total bill as 00.00: "))
#Open files throug user input, or default to standard names if blank - will add user input later
pathmin = "minutes*.csv"
pathmsg = "messages*.csv"
pathmb = "megabytes*.csv"
for filename in glob.glob(pathmin):
    rawminutes = open(filename)
for filename in glob.glob(pathmsg):
    rawmessages = open(filename)
for filename in glob.glob(pathmb):
    rawmegabytes = open(filename)
#Loop through usage files and sum by person and total
for line in rawminutes:
    splitline = line.split(",")
    for i in listnames:
        if splitline[5] == i:
            resultdict[i]["min"] = resultdict[i].get("min",0) + int(splitline[13])
            resultdict["Total"]["min"] = resultdict["Total"].get("min",0) + int(splitline[13])
for line in rawmessages:
    splitline = line.split(",")
    for i in listnames:
        if splitline[4] == i:
            resultdict[i]["msg"] = resultdict[i].get("msg",0) + 1
            resultdict["Total"]["msg"] = resultdict["Total"].get("msg",0) + 1
for line in rawmegabytes:
    splitline = line.split(",")
    for i in listnames:
        if splitline[3] == i:
            resultdict[i]["mb"] = resultdict[i].get("mb",0) + int(splitline[5])
            resultdict["Total"]["mb"] = resultdict["Total"].get("mb",0) + int(splitline[5])
#convert megabytes current storage of kilobytes into megabytes
for i in listnames:
    resultdict[i]["mb"] = int(round(resultdict[i]["mb"] / 1024.00))
#calculate the cost per unit
def calc_cost_unit(bucket,type,size,cost):
    for i in bucket:
        if resultdict["Total"][type] <= bucket[i][0]:
            resultdict["Total"][cost] = resultdict["Total"].get(cost,0) + bucket[i][1]
            resultdict["Total"][size] = resultdict["Total"].get(size,"") + i
            break
        elif i == "extra":
            resultdict["Total"][cost] = resultdict["Total"].get(cost,0) + round(bucket[i][1] * (resultdict["Total"][type] - bucket[i][0]) + bucket["xlarge"][1],2)
            resultdict["Total"][size] = resultdict["Total"].get(size,"") + i
            break
calc_cost_unit(minutes,"min","sizemin","costmin")
calc_cost_unit(messages,"msg","sizemsg","costmsg")
calc_cost_unit(megabytes,"mb","sizemb","costmb")
resultdict["Total"]["fees"] = resultdict["Total"]["costtotal"] - resultdict["Total"]["costmin"] - resultdict["Total"]["costmsg"] - resultdict["Total"]["costmb"] - device * (len(listnames)-1)
#calculate cost per usage category to each person in the dictionary
for i in listnames:
    if i == "Total": continue
    resultdict[i]["costmin"] = resultdict[i].get("costmin",0) + round((resultdict["Total"]["costmin"] * resultdict[i]["min"] / resultdict["Total"]["min"]),2)
    resultdict[i]["costmsg"] = resultdict[i].get("costmsg",0) + round((resultdict["Total"]["costmsg"] * resultdict[i]["msg"] / resultdict["Total"]["msg"]),2)
    resultdict[i]["costmb"] = resultdict[i].get("costmb",0) + round((resultdict["Total"]["costmb"] * resultdict[i]["mb"] / resultdict["Total"]["mb"]),2)
    resultdict[i]["costtotal"] = round(resultdict[i]["costmin"] + resultdict[i]["costmsg"] + resultdict[i]["costmb"] + device + resultdict["Total"]["fees"] / 6,2)
#export the results to a csv file
with open("monthlybill.csv", "wb") as csvfile:
    fieldnames = ["Name", "Minutes", "Messages", "Megabytes", "Total Cost"]
    writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
    writer.writeheader()
    for i in listnames:
        writer.writerow({"Name": key1, "Minutes": resultdict[key1]["min"], "Messages": resultdict[key1]["msg"], "Megabytes": resultdict[key1]["mb"], "Total Cost": resultdict[key1]["costtotal"]})
    writer.writerow({"Name": "Total", "Minutes": resultdict["Total"]["min"], "Messages": resultdict["Total"]["msg"], "Megabytes": resultdict["Total"]["mb"], "Total Cost": resultdict["Total"]["costtotal"]})
            