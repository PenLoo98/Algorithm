# https://www.acmicpc.net/problem/1158

N, K = map(int, input().split())
left = list(range(1, N+1))
right = []
for i in range(N):
    for j in range(K):
        if j == K-1:
            right.append(left.pop(0))
        else:
            left.append(left.pop(0))