# https://www.acmicpc.net/problem/4948
# https://velog.io/@iillyy/%EB%B0%B1%EC%A4%80-4948%EB%B2%88-%ED%8C%8C%EC%9D%B4%EC%8D%AC

# 소수 구하는 함수
def isPrime(num):
    if num == 1:
        return False
    elif num != 1:
        for i in range(2, int(num**0.5)+1):
            if num % i == 0:
                return False
        return True

# 제한 범위의 모든 소수를 구함
PrimeNums = []
for i in range(2, 246912):
    if isPrime(i):
        PrimeNums.append(i)

while True:
    N = int(input())
    if N == 0:
        break
    count = 0
    for i in PrimeNums:
        if N < i <= 2*N:
            count += 1
    # for number in range(N + 1, 2 * N + 1):
    #     if number in PrimeNums:
    #         count += 1
    print(count)

