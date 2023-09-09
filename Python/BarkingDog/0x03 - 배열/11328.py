# https://www.acmicpc.net/problem/11328

N = int(input())
for _ in range(N):
    a, b = input().split()
    a = sorted(a)
    b = sorted(b)
    if a == b:
        print("Possible")
    else:
        print("Impossible")

