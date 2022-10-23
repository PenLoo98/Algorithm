# https://www.acmicpc.net/problem/1158
# https://infinitt.tistory.com/213

N, K = map(int, input().split())
before = list(range(1, N+1))
after = []
index = 0

for _ in range(N):
    index += K-1
    if index >= len(before):
        index = index%len(before)
    after.append(before.pop(index))

print("<"+", ".join(map(str,after))+">")

