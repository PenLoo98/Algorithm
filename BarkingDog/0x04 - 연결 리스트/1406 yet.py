# https://www.acmicpc.net/problem/1406

import sys
input = sys.stdin.readline

S = list(input().strip())
N = len(S)
M = int(input())
for _ in range(M):
    cmd = input().strip()
    if cmd == 'L':
        if S:
            S.pop()
    elif cmd == 'D':
        if S:
            S.append(S.pop())
    elif cmd == 'B':
        if S:
            S.pop()
    else:
        S.append(cmd[2])
