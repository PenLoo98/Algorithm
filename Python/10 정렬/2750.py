# https://www.acmicpc.net/problem/2750
#

N = int(input())
nlist = []
for num in range(0,N):
  n = int(input())
  nlist += [n]
nlist.sort()

for i in nlist:
  print(i)