# https://www.acmicpc.net/problem/1267

N = int(input())
times = list(map(int, input().split()))

y = 0
m = 0
for i in times:
    y += (i//30+1)*10
    m += (i//60+1)*15
if y < m:
    print("Y", y)
elif y > m:
    print("M", m)
else: # y == m
    print("Y M", y)
