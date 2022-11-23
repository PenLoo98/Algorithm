# https://www.acmicpc.net/problem/5622

Word = input()
Time = 0

for i in Word:
    if i in 'ABC':
        Time += 3
    elif i in 'DEF':
        Time += 4
    elif i in 'GHI':
        Time += 5
    elif i in 'JKL':
        Time += 6
    elif i in 'MNO':
        Time += 7
    elif i in 'PQRS':
        Time += 8
    elif i in 'TUV':
        Time += 9
    elif i in 'WXYZ':
        Time += 10

print(Time)