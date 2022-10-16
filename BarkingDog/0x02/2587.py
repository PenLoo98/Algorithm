# https://www.acmicpc.net/problem/2587

numlist = []
for i in range(5):
    num = int(input())
    numlist += [num]
print(int(sum(numlist)/5))
numlist.sort()
print(numlist[2])