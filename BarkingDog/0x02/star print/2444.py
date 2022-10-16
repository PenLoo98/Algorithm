# https://www.acmicpc.net/problem/2444

N = int(input())
n = N
for i in range(1, N + 1):
    side = (2 * N - 1) // 2
    center = 2 * i - 1
    print(" " * side + '*' * center)
    N -= 1

for j in range(1, n + 1):
    if j!=1:
      side = int((2 * j - 1) / 2)
      center = int(2 * n - 1)
      print(" " * side + '*' * center)
    n -= 1