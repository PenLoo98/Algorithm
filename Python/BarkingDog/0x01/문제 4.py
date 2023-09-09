# https://blog.encrypted.gg/922?category=773649
# 1강 18:00 문제4 N이하의 수 중에서
# 가장 큰 2의 거듭제곱수 반환하는 함수

# 10억 = 약 10**30
f2 = []
for num in range(1, 31):
    f2 += [2**num]

def climb2(N):
    result = []
    for i in f2:
        if i <= N:
            result += [i]
    return print(max(result))

# 결과값 4, 67108864, 1024
climb2(5)
climb2(97615282)
climb2(1024)