# https://www.acmicpc.net/problem/2108

import sys
input = sys.stdin.readline
N = int(input())
nums = [int(input()) for _ in range(N)]

print(round(sum(nums)/N))
nums.sort()
print(nums[N//2])
from collections import Counter
cnt = Counter(nums)
cnt = cnt.most_common()
if len(cnt) > 1 and cnt[0][1] == cnt[1][1]:
    print(cnt[1][0])
else:
    print(cnt[0][0])
print(nums[-1]-nums[0])

