# https://www.acmicpc.net/problem/2675

T = int(input())
for i in range(0,T):
  R,S = input().split()
  result = ""
  for j in S:
    result+=int(R)*j
  print(result)