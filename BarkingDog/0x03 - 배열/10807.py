# https://www.acmicpc.net/problem/10807

N = int(input())
nums = list(map(int, input().split()))
v = int(input())
count = 0
for i in nums:
    if i == v:
        count += 1
print(count)