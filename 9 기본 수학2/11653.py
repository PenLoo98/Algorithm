# https://www.acmicpc.net/problem/11653

# 정수 N 입력
N = int(input())
i=2
# N을 소인수분해 및 출력
while N!=1:
  if N%i==0:
    N/=i
    print(i)
  else:
    i+=1