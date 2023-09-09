# https://www.acmicpc.net/problem/2442

N = int(input())
for i in range(1, N + 1):
    side = (2 * N - 1) // 2
    center = 2 * i - 1
    print(" " * side + '*' * center)
    N -= 1
