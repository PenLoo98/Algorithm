# https://www.acmicpc.net/problem/10828
# 주의: input()대신 sys.stdin.readline()을 사용해야 통과된다
import sys
N = int(sys.stdin.readline())
stack = []
for _ in range(N):
    cmd = sys.stdin.readline().split()
    if cmd[0] == 'push':
        stack.append(cmd[1])
    elif cmd[0] == 'pop':
        if stack == []:
            print(-1)
        elif stack != []:
            print(stack.pop())
    elif cmd[0] == 'size':
        print(len(stack))
    elif cmd[0] == 'empty':
        if stack == []:
            print(1)
        elif stack != []:
            print(0)
    elif cmd[0] == 'top':
        if stack == []:
            print(-1)
        elif stack != []:
            print(stack[-1])