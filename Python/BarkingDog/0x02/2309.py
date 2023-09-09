# https://www.acmicpc.net/problem/2309
from itertools import combinations
heightlist = []
sumValue = 0
for i in range(9):
    height = int(input())
    heightlist += [height]
    sumValue += height

list7 = list(combinations(heightlist, 7))

for i in list7:
    if sum(i) == 100:
        dwarfList = list(i)
dwarfList.sort()
for j in dwarfList:
    print(j)

