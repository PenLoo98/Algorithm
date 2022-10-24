# https://www.acmicpc.net/problem/18258
import sys
N = int(sys.stdin.readline())
queue = []
for _ in range(N):
    cmd = sys.stdin.readline().split()
    if cmd[0] == 'push':
        queue.append(cmd[1])
    elif cmd[0] == 'pop':
        if queue:
            print(queue.pop(0))
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