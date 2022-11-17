# https://www.acmicpc.net/problem/1929

# 소수 구하는 함수 정의
def isPrime(num):
  if num==1:
    return False
  elif num!=1:
    for i in range(2,int(num**0.5)+1):
      if num%i==0:
        return False
    return True

M,N = map(int,input().split())

# M<=number<=N 범위의 수를 하나씩 꺼냄
for number in range(M, N+1):
  if isPrime(number):
    print(number)

