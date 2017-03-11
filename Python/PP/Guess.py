import random
def checkint(num):
    try:
        num = int(num)
        return num
    except:
        if num == "Done":
            return num
        val = "Error"
        return val
compnum = random.randint(1,100)
guess = raw_input("Guess a number between 1 and 100: ")
guess = checkint(guess)
gcount = 1
if guess != compnum:
    while guess != compnum:
        if guess == "Done":
            quit()
        elif guess == "Error":
            guess = raw_input("Enter a number between 1 and 100! ")
            guess = checkint(guess)
            continue
        elif guess > compnum:
            guess = raw_input("Too high. Guess again: ")
            guess = checkint(guess)
            gcount += 1
            continue
        elif guess < compnum:
            guess = raw_input("Too low. Guess again: ")
            guess = checkint(guess)
            gcount += 1
            continue
    print "Congratulations! You got it in", gcount, "guesses."
else:
    print "Congratulations! You got it in 1 guess."