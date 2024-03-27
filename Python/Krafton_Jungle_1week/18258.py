import sys
input = sys.stdin.readline


N=int(input())
queue = []
point = 0

for _ in range(N):
    commands = list(input().split())
    if commands[0]=='push':
        queue.append(commands[1])
    elif commands[0]=='pop':
        if len(queue)>point:
            print(queue[point])
            point+=1
        else:
            print(-1)
    elif commands[0]=='size':
        print(len(queue)-point)
    elif commands[0]=='empty':
        if(point==len(queue)):
            print(1)
            queue = []
            point = 0
        else:
            print(0)
    elif commands[0]=='front':
        if len(queue)>point:
            print(queue[point])
        else:
            print(-1)
    elif commands[0]=='back':
        if len(queue)>point:
            print(queue[-1])
        else:
            print(-1)