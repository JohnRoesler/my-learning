import random
correct = 0
for i in range(10):
    n1 = random.randint(1,10)
    n2 = random.randint(1,10)
    prod = n1 * n2
    answer = raw_input("What's %d times %d? " % (n1, n2))
    
    