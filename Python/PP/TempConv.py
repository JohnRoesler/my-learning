while True:
    temp = raw_input("Enter a temperature: ")
    try: 
        temp = int(temp)
        break
    except: 
        print "Please enter a valid integer temperature!\n"
        continue 
while True:
    conv = raw_input("Would you like to covert to Fahrenheit (F) or Celcius (C)? ")
    if conv == "F":
        temp2 = 9.0/5.0*temp+32
        print temp, "C =", int(round(temp2,0)), "F"
        break
    elif conv == "C":
        temp2 = 5.0/9.0*(temp-32)
        print temp, "F =", int(round(temp2,0)), "C"
        break
    else:
        print "Please enter a valid F or C selection!\n"
        continue