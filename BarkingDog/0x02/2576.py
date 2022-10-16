# https://www.acmicpc.net/problem/2576

oddlist = []
for i in range(7):
    num = int(input())
    if num%2 == 1:
        oddlist += [num]
if oddlist == []:
    print(-1)
elif oddlist != []:
    print(sum(oddlist))
    print(min(oddlist))
