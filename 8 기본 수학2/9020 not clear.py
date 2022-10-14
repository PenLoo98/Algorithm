# https://www.acmicpc.net/problem/9020

# 소수 구하는 함수 정의
def isPrime(num):
    if num == 1:
        return False
    elif num != 1:
        for i in range(2, int(num ** 0.5) + 1):
            if num % i == 0:
                return False
        return True


# 제한 범위의 소수 구하기
primeNums = []
for i in range(4, 10000):
    if isPrime(i):
        primeNums += [i]

# 메인 동작
T = int(input())

for j in range(0, T):
    N = int(input())

    # N을 만들 수 있는 소수:
    for num1, num2 in primeNums:
        guess = []
        if num1+num2 == N:
            guess += [num1,num2]
    print(guess)


# 1. 같은 소수의 합
# 2. 합이 1개
# 3. 합이 2개 이상 + 차가 가장 적은 합 구하기
