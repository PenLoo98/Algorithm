# https://www.acmicpc.net/problem/2445

N = int(input())
n = N
for i in range(1, N):
    side = i
    center = 2 * (N-i)
    print("*" * side + ' ' * center+"*" * side)
print("*"*2*N)
for i in range(1, N):
    side = N-i
    center = 2 * i
    print("*" * side + ' ' * center+"*" * side)