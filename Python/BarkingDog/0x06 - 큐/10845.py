# https://www.acmicpc.net/problem/10845

import sys
input = sys.stdin.readline
N = int(input())
queue = []
cnt = 0
for _ in range(N):
    cmd = input().split().strip()
    if cmd[0] == 'push':
        queue.append(int(cmd[1]))
    elif cmd[0] == 'pop':
        if queue:
            print(queue.pop(cnt))
            cnt += 1
        elif not queue:
            print(-1)
    elif cmd[0] == 'size':
        print(len(queue))
    elif cmd[0] == 'empty':
        if queue:
            print(0)
        elif not queue:
            print(1)
    elif cmd[0] == 'front':
        if queue:
            print(queue[0])
        elif not queue:
            print(-1)
    elif cmd[0] == 'back':
        if queue:
            print(queue[-1])
        elif not queue:
            print(-1)