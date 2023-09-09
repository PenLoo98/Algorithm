# https://www.acmicpc.net/problem/10773
import sys
K = int(sys.stdin.readline())
stack = []
for _ in range(K):
    num = int(sys.stdin.readline())
    if num == 0:
        stack.pop()
    elif num != 0:
        stack.append(num)
print(sum(stack))