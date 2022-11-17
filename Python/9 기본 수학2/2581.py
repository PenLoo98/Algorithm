# https://www.acmicpc.net/problem/2581

M = int(input())
N = int(input())
sosu = []

# M이상 N이하 자연수
for i in range(M, N + 1):
    # 소수 찾기
    cnt = 0
    for j in range(2, i + 1):
        if (i % j == 0):
            cnt += 1
        else:
            pass
    if cnt == 1:
        sosu += [i]

if sosu == []:
    print(-1)
else:
    # sum에 더하기+출력
    sum = 0
    for k in sosu:
        sum += k
    print(sum)

    # 소수 중 최솟값 구하기+출력
    print(min(sosu))