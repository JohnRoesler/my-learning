import time
import sys
import random
#http://www.practicepython.org/
#define the variables needed for the program
#additional comment for testing git
players = dict()
players["1"] = "X"
players["2"] = "O"
dic = dict()
game = dict()
wincom1 = ["X","X","X"]
wincom2 = ["O","O","O"]
turncount = 1
#overall gameplay function - this starts and calls the appropriate functions
def playgame(var):
    initgame()
    for i in range (1,10):
        taketurn(var)
        winner = chkwin()
        if winner == "winner": break
        var += 1
    if winner != "winner": winner = "tie"
    endgame(winner,var)
#initialize game board
def initgame():
    randprint("\nWelcome to Tic Tac Toe!\n")
    randprint("This is a game for two players, X and O, \nwho take turns marking the spaces in a 3x3 grid. \nThe player who succeeds in placing three of their marks in \na horizontal, vertical, or diagonal row wins the game.\n")
    randprint("\nPlayer 1 is X and Player 2 is O. Is that ok? (y/n) ")
    playersetup = raw_input("")
    if playersetup == "n":
        players["1"] = "O"
        players["2"] = "X"
        print "\nOk. Player 1 is O and Player 2 is X."
    elif playersetup == "y":
        
    else: 
        randprint("\nYou entered an incorrect y/n selection. Player 1 is X and Player 2 is O.\n")
    randprint("\nThe positions on the game board are numbered as follows:\n")
    for i in range(1,10):
        dic[str(i)] = str(i)
        game[str(i)] = " "
    drawboard(dic)
#print the game board
def drawboard(board):
    time.sleep(0.75)
    print(" --- --- ---")
    print("| " +board["1"]+ " | " +board["2"]+ " | " +board["3"] + " |")
    print(" --- --- ---")
    print("| " +board["4"]+ " | " +board["5"]+ " | " +board["6"] + " |")
    print(" --- --- ---")
    print("| " +board["7"]+ " | " +board["8"]+ " | " +board["9"] + " |")
    print(" --- --- ---")
#print for turn
def taketurn(var):
    time.sleep(0.5)
    turn = whosturn(var)
    print "\nPlayer %s's turn (%s's):" % (turn, players[turn])
    drawboard(game)
    move = raw_input("\nPlease select the position you want to mark: ")
    while True:
        if move == "Q": quit()
        elif move not in game:
            print "\nThe positions on the game board are numbered as follows:"
            drawboard(dic)
            move = raw_input("\nPlease select the position you want to mark, or enter Q to quit: ")
            continue
        elif game[move] != " ":
            move = raw_input("\nThat position is taken! Please select again: ")
            continue            
        else:    
            game[move] = players[turn]
            break   
#evaluate who's turn based on turn count
def whosturn(var):
    if var % 2 == 0:    
        turn = "2"
    else: 
        turn = "1"
    return turn
#check if a winner
def chkwin():
    #check rows
    lst = []
    for i in ["1","2","3"]:
        lst.append(game[i])
    if lst == wincom1 or lst == wincom2:
        return "winner"
    lst = []
    for i in ["4","5","6"]:
        lst.append(game[i])
    if lst == wincom1 or lst == wincom2:
        return "winner"
    lst = []
    for i in ["7","8","9"]:
        lst.append(game[i])
    if lst == wincom1 or lst == wincom2:
        return "winner"
    #check columns
    lst = []
    for i in ["1","4","7"]:
        lst.append(game[i])
    if lst == wincom1 or lst == wincom2:
        return "winner"
    lst = []
    for i in ["2","5","8"]:
        lst.append(game[i])
    if lst == wincom1 or lst == wincom2:
        return "winner"
    lst = []
    for i in ["3","6","9"]:
        lst.append(game[i])
    if lst == wincom1 or lst == wincom2:
        return "winner"
    #check diagonals
    lst = []
    for i in ["1","5","9"]:
        lst.append(game[i])
    if lst == wincom1 or lst == wincom2:
        return "winner"
    lst = []
    for i in ["3","5","7"]:
        lst.append(game[i])
    if lst == wincom1 or lst == wincom2:
        return "winner"
#handle the end of game, winner identified or tie
def endgame(var,var1):
    turn = whosturn(var1)
    drawboard(game)
    time.sleep(0.5)
    if var == "winner":
        print "Player %s won the game!" % turn
    elif var == "tie":
        print "The game was a tie."
#used to make printed lines look typed
def randprint(var):
    for char in var:
        sys.stdout.write(char)
        sys.stdout.flush()
        time.sleep((random.random() * 0.01))
playgame(turncount)
#Additional testing of git using this file for updates