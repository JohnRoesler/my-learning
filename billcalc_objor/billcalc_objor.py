#should include some line allowing implicit invocation as script?

#Author - John Roesler"
#This python program calculates the individual usage and cost per user on a Ting (an MNVO) monthly bill 

#the modules used throughout
import glob
import csv

#the classes used in the program
class person:
    min = 0
    msg = 0
    mb = 0
    cost_min = 0
    cost_msg = 0
    cost_mb = 0
    cost_device = 0
    cost_total = 0
    def calc_usage(type): print ''
    def calc_cost(type): print ''


class monthly_bill:
    min = 0
    msg = 0
    mb = 0
    cost_min = 0
    cost_msg = 0
    cost_mb = 0
    cost_device = 0
    cost_fees = 0
    cost_total = 0
    def sum_usage(type): print ''
    def input_cost_total(): print ''

#the main landing page when you run the program
def init_program():
    welcome_message = open("welcome_message.txt", "r").read()
    print welcome_message
    while True:
        selected_report = raw_input("Please select a report and enter the corresponding number as an integer: ")
        if int(selected_report) in [1,2,3]: 
            selected_report = int(selected_report)
            break
        print "You entered an incorrect selection. Try again."
    if selected_report == 1: full_detail()
    elif selected_report == 2: by_person()
    elif selected_report == 3: by_type()

#the interum landing page after a report has been generated that allows the user to determine what is next
def interim_program():
    print 'Interim program'


#the report options available from the main landing page
def full_detail(): 
    print 'Full detail'
    interim_program()
    
def by_person(name): print 'By person'

def by_type(usage_type): print 'By type'

#the core functions utilized by the report options
def names(): print ''
    
    
init_program()