# https://www.acmicpc.net/problem/5597

import sys
input = sys.stdin.readline

students = [0] * 30
for _ in range(28):
    students[int(input())-1] = 1
for i in range(30):
    if students[i] == 0:
        print(i+1)