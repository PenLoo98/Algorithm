# https://www.acmicpc.net/problem/10804

numlist = list(range(1, 21))

for i in range(10):
    a, b = map(int, input().split())
    numlist = numlist[:a-1] + list(reversed(numlist[a-1:b])) + numlist[b:]

for i in numlist:
    print(i, end=' ')