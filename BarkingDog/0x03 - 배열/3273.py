# https://www.acmicpc.net/problem/3273
# 모범답안: https://ddggblog.tistory.com/212
import sys
input = sys.stdin.readline

n = int(input())
nums = list(map(int, input().split()))
nums = set(nums)
nums = sorted(nums)
x = int(input())
count = 0
sp = 0
ep = len(nums) - 1

while sp != ep:
    if nums[sp]+nums[ep] == x:
        count += 1
        sp += 1
    elif nums[sp]+nums[ep] != x:
        if nums[sp]+nums[ep] > x:
            ep -= 1
        elif nums[sp] + nums[ep] < x:
            sp += 1
print(count)
