# https://www.acmicpc.net/problem/2751
# 2750번보다 더 짧은 시간복잡도

N = int(input())

num = []
for i in range(0,N):
  num += [int(input())]
num.sort()
for j in num:
  print(j)