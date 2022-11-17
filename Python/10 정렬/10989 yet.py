# https://www.acmicpc.net/problem/10989

import sys
input = sys.stdin.readline
N = int(input())
nums = [int(input()) for _ in range(N)]
nums.sort()
print('\n'.join(map(str, nums)))
