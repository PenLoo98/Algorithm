# https://www.acmicpc.net/problem/2446

N = int(input())
n = N
for i in range(1, N+1):
    side = i-1
    center = 2 * N - 1
    print(" " * side + '*' * center)
    N -=1

for i in range(1, n):
    side = n-i-1
    center = 2 * i + 1
    print(" " * side + '*' * center)