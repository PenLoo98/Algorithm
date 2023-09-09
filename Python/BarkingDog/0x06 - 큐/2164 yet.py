# https://www.acmicpc.net/problem/2164

import sys
N = int(sys.stdin.readline())
queue = [i for i in range(1, N+1)]
while len(queue) > 1:
    queue = queue[1::2]
    for _ in range(len(queue)):
        queue.append(queue.pop(0))
print(queue[0])