import sys
from collections import deque 
input = sys.stdin.readline


N=int(input())
queue = deque()

for _ in range(N):
    commands = list(input().split())
    if commands[0]=='push':
        queue.append(commands[1])
    elif commands[0]=='pop':
        if queue:
            # print(queue.pop(0))
            print(queue.popleft())
        else:
            print(-1)
    elif commands[0]=='size':
        print(len(queue))
    elif commands[0]=='empty':
        if(len(queue)==0):
            print(1)
        else:
            print(0)
    elif commands[0]=='front':
        if queue:
            print(queue[0])
        else:
            print(-1)
    elif commands[0]=='back':
        if queue:
            print(queue[-1])
        else:
            print(-1)