# https://www.acmicpc.net/problem/1978
N = int(input())
count = 0
nums = map(int, input().split())

for i in nums:
    cnt = 0
    # 1은 소수가 아니라 제외
    if i == 1:
        continue

    for j in range(2, i + 1):
        # cnt=1이면 소수
        if (i % j == 0):
            cnt += 1
    if cnt == 1:
        count += 1

print(count)