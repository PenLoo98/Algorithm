# https://www.acmicpc.net/problem/1065

import sys
input = sys.stdin.readline

sequence = []
for i in range(1,1001):
    if i<100:
        sequence.append(i)
    elif i<1000:
        if (i%100)%10 - (i%100)//10==(i%100)//10 - i//100:
            sequence.append(i)
    else:
        break

N = int(input())
cnt = 0

for i in sequence:
    if i <= N:
        cnt +=1

print(cnt)

