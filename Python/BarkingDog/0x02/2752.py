# https://www.acmicpc.net/problem/2752

sortlist = []
a, b, c= map(int, input().split())
sortlist += [a]
sortlist += [b]
sortlist += [c]
sortlist.sort()
for i in sortlist:
    print(i, end=" ")