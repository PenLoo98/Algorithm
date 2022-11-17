# https://www.acmicpc.net/problem/2751
# 2750번보다 더 짧은 시간복잡도

import sys
input = sys.stdin.readline
N = int(input())

nums = [int(input()) for _ in range(N)]
nums.sort()
for num in nums:
    print(num)
