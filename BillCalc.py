#import anything needed
import glob
import csv
#Define the global variables needed
resultdict = dict()
listnames = list()
minutes = dict()
messages = dict()
megabytes = dict()
device = 0
rawminutes = ""
rawmessages = ""
rawmegabytes = ""
#Create a dictionary full of dictionaries for each person with usage bill and one for total
def create_name_dictionary():
    global listnames
    global resultdict
    listnames[:] = []
    inputnames = raw_input("Input the names in the bill separated by commas e.g. Bob, Jane, Bill:\n")
    if inputnames == "":
        while True:
            inputnames = raw_input("Please enter at least one name, or multiple separated by commas. Or type 'quit' to exit:\n")
            if inputnames == "": continue
            elif inputnames == "quit":
                quit()
            break
    elif inputnames == "quit": quit()
    nameconvert = inputnames.split(",")
    for i in nameconvert:
        listnames.append(i.strip())
    listnames.append("Total")
    resultdict = {x:{} for x in listnames}
#Define billing usage buckets as: usage limit, cost in dollars
def billing_usage_buckets():
    global minutes
    minutes['small'] = (100,3.0)
    minutes['medium'] = (500,9.0)
    minutes['large'] = (1000,18.0)
    minutes['xlarge'] = (2100,35.0)
    minutes['extra'] = (2100,0.019)
    global messages
    messages['small'] = (100,3.0)
    messages['medium'] = (1000,5.0)
    messages['large'] = (2000,8.0)
    messages['xlarge'] = (4100,11.0)
    messages['extra'] = (4100,0.0025)
    global megabytes
    megabytes['small'] = (100,3.0)
    megabytes['medium'] = (500,12.0)
    megabytes['large'] = (1000,19.0)
    megabytes['xlarge'] = (2000,29.0)
    megabytes['extra'] = (2000,0.015)
    global device
    device = 6
    allowedvariance = 0
#Open files throug user input, or default to standard names if blank - will add user input later
def open_usage_files():
    global rawminutes, rawmessages, rawmegabytes
    pathmin = "minutes*.csv"
    pathmsg = "messages*.csv"
    pathmb = "megabytes*.csv"
    for filename in glob.glob(pathmin):
        rawminutes = open(filename)
    for filename in glob.glob(pathmsg):
        rawmessages = open(filename)
    for filename in glob.glob(pathmb):
        rawmegabytes = open(filename)
#Check files for names input to confirm if any are not in the files
def error_check(fname1,fname2,fname3,var1,var2,var3):
    while True:
        counter = 0
        name_error = list()
        global checklist
        checklist = list()
        name_list_error_check(fname1,var1)
        name_list_error_check(fname2,var2)
        name_list_error_check(fname3,var3)
        for i in listnames:
            if i != "Total":
                if i not in checklist:
                    counter +=1
                    name_error.append(i)
        if counter != 0: 
            print "You input the following names that are not in the bill files: %s." % name_error
            print "Please re-input the names in the billing file."
            create_name_dictionary()
            name_error[:] = []
        else: return
def name_list_error_check(fname,var):
    for lines in fname:
        sline = lines.split(",")
        checklist.append(sline[var])
    fname.seek(0, 0)
#Take bill information as inputs: total bill
def take_bill_info():
    while True:
        billinput = raw_input("Please enter the total bill as 00.00:\n")
        if billinput == "q":
            quit()
        else: 
            try:
                billinput = float(billinput)
                break
            except: 
                print "Invalid input. You may press q to quit."
                continue
    global resultdict
    resultdict["Total"]["costtotal"] = billinput
#Loop through usage files and sum by person and total
def sum_usage_by_person():
    global resultdict
    for line in rawminutes:
        splitline = line.split(",")
        for i in listnames:
            if splitline[4] == i:
                resultdict[i]["min"] = resultdict[i].get("min",0) + int(splitline[12])
                resultdict["Total"]["min"] = resultdict["Total"].get("min",0) + int(splitline[12])
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
    global resultdict
    for i in bucket:
        if resultdict["Total"][type] <= bucket[i][0]:
            resultdict["Total"][cost] = resultdict["Total"].get(cost,0) + bucket[i][1]
            resultdict["Total"][size] = resultdict["Total"].get(size,"") + i
            break
        elif i == "extra":
            resultdict["Total"][cost] = resultdict["Total"].get(cost,0) + round(bucket[i][1] * (resultdict["Total"][type] - bucket[i][0]) + bucket["xlarge"][1],2)
            resultdict["Total"][size] = resultdict["Total"].get(size,"") + i
            break
def calc_cost_sum_unit_to_total():
    global resultdict
    calc_cost_unit(minutes,"min","sizemin","costmin")
    calc_cost_unit(messages,"msg","sizemsg","costmsg")
    calc_cost_unit(megabytes,"mb","sizemb","costmb")
    resultdict["Total"]["fees"] = resultdict["Total"]["costtotal"] - resultdict["Total"]["costmin"] - resultdict["Total"]["costmsg"] - resultdict["Total"]["costmb"] - device * (len(listnames)-1)
#calculate cost per usage category to each person in the dictionary
def calc_cost_category_person(cost, type, person):
    global resultdict
    resultdict[person][cost] = resultdict[person].get(cost,0) + round((resultdict["Total"][cost] * resultdict[person][type] / resultdict["Total"][type]),2)
def calc_cost_person():
    global resultdict
    for i in listnames:
        if i == "Total": continue
        calc_cost_category_person("costmin","min",i)
        calc_cost_category_person("costmsg","msg",i)
        calc_cost_category_person("costmb","mb",i)
        resultdict[i]["costtotal"] = round(resultdict[i]["costmin"] + resultdict[i]["costmsg"] + resultdict[i]["costmb"] + device + resultdict["Total"]["fees"] / 6,2)
#export the results to a csv file
def export_to_csv():
    with open("monthlybill.csv", "wb") as csvfile:
        fieldnames = ["Name", "Minutes", "Messages", "Megabytes", "Total Cost"]
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()
        for i in listnames:
            writer.writerow({"Name": i, "Minutes": resultdict[i]["min"], "Messages": resultdict[i]["msg"], "Megabytes": resultdict[i]["mb"], "Total Cost": resultdict[i]["costtotal"]})
create_name_dictionary()
billing_usage_buckets()
open_usage_files()
error_check(rawminutes,rawmessages,rawmegabytes,5,4,3)
take_bill_info()
sum_usage_by_person()
calc_cost_sum_unit_to_total()
calc_cost_person()
export_to_csv()
