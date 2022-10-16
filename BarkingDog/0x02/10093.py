# https://www.acmicpc.net/problem/10093

a, b = map(int, input().split())

Big = max([a, b])
Sma = min([a, b])

if Big - Sma <= 1:
    print(0)
else:
    print(Big - Sma - 1)
    for i in range(Sma + 1, Big):
        print(i, end=" ")
