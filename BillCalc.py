#import anything needed
import glob
import csv
#Define billing usage buckets as: usage limit, cost in dollars
minutes = dict()
minutes['small'] = (100,3)
minutes['medium'] = (500,9)
minutes['large'] = (1000,18)
minutes['xlarge'] = (2100,35)
minutes['extra'] = (2100,0.019)
messages = dict()
messages['small'] = (100,3)
messages['medium'] = (1000,5)
messages['large'] = (2000,8)
messages['xlarge'] = (4100,11)
messages['extra'] = (4100,0.0025)
megabytes = dict()
megabytes['small'] = (100,3)
megabytes['medium'] = (500,12)
megabytes['large'] = (1024,19)
megabytes['xlarge'] = (2048,29)
megabytes['extra'] = (2048,0.015)
device = 6
allowedvariance = 0
#Take bill information as inputs: total bill, fees - ADD ERROR CHECKING
billtotal = raw_input("Please enter the total bill as 00.00: ")
feetotal = raw_input("Please enter the fee total as 00.00: ")
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
#Create dictionaries for each person with usage bill and one for total
Dad = dict()
Mom = dict()
Marcus = dict()
Noah = dict()
Joseph = dict()
John = dict()
#Loop through usage files and sum by person and total

#Add cost per usage category to dictionaries