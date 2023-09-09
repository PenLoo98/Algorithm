# https://www.acmicpc.net/problem/1874

import sys
n = int(sys.stdin.readline())

inputlist = [int(sys.stdin.readline()) for _ in range(n)]

stack = []
result = []
count = 0
for i in inputlist:
    while count < i:
        count += 1
        stack.append(count)
        result.append("+")
    if stack[-1] == i:
        stack.pop()
        result.append("-")
    else:
        print("NO")
        break
    if i==inputlist[-1]:
        print("\n".join(result))