# https://www.acmicpc.net/problem/2443

N = int(input())
for i in range(1, N + 1):
    side = int((2 * i - 1) / 2)
    center = int(2 * N - 1)
    print(" " * side + '*' * center)
    N -= 1
