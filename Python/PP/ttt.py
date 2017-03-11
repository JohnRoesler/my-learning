#http://www.practicepython.org/
size = 3
players = dict()
players["1"] = "X"
players["2"] = "O"
players["0"] = " "
game = list()
game = [[0,0,0],[0,0,0],[0,0,0]]
wincom1 = [1,1,1]
wincom2 = [2,2,2]
def bhorizon():
    print (" ---") * size
def bvert(var):
    if var == 0 or var == 1 or var == 2:
        if var == 0: lst = [1,2,3]
        elif var == 1: lst = [3,4,5]
        elif var == 2: lst = [5,6,7]
        print ("| %s | %s | %s |" % (str(var+lst[0]),str(var+lst[1]),str(var+lst[2])))
    else:
        print ("| %s " % var )*size + "|"
#initialize game board
def initgame():
    print "\nThe positions on the game board are numbered as follows:"
    for i in range(size):
        bhorizon()
        bvert(i)
    bhorizon()
#print the game board
def printgame(var):
    print "\nPlayer %s's turn:" % "1"
    for i in range(size):
        bhorizon()
        bvert(var)
    bhorizon()
def drawboard(board):
    print " --- --- ---"
    print '| ' +board[0]+ ' | ' +board[1]+ ' | ' +board[2] + " |"
    print " --- --- ---"
    print '| ' +board[3]+ ' | ' +board[4]+ ' | ' +board[5] + " |"
    print " --- --- ---"
    print '| ' +board[6]+ ' | ' +board[7]+ ' | ' +board[8] + " |"
    print " --- --- ---"
def chkwin():
    #check rows
    for i in range(3):
        lst = []
        for j in range(3):
            lst.append(game[i][j])
        if lst == wincom1 or lst == wincom2:
            print lst
    #check columns
    for i in range(3):
        lst = []
        for j in range(3):
            lst.append(game[j][i])
        if lst == wincom1 or lst == wincom2:
            print lst
    #check diagonals
    lst = []
    for i in range(3):
        lst.append(game[i][i])
    if lst == wincom1 or lst == wincom2:
        print lst
    lst = []
    for i in range(3):
        lst.append(game[i][(2-i)])
    if lst == wincom1 or lst == wincom2:
        print lst
drawboard([' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '])