import sys
input = sys.stdin.readline

stack = []

N = int(input())
for _ in range(N):
    commands = list(input().split())
    if len(commands)==2:
        commands[1]=int(commands[1])
    
    if commands[0]=="push":
        stack.append(commands[1])
    elif commands[0]=="pop":
        if stack:
            print(stack.pop())
        else:
            print(-1)
    elif commands[0]=="size":
        print(len(stack))
    elif commands[0]=="empty":
        if len(stack)==0:
            print(1)
        else: 
            print(0)
    elif commands[0]=="top":
        if stack:
            print(stack[len(stack)-1])
        else:
            print(-1)    
    else:
        "Command Error"