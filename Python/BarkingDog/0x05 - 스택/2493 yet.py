# https://www.acmicpc.net/problem/2493

import sys
# N = int(sys.stdin.readline())
N = 5
# tower = list(map(int, sys.stdin.readline().split()))
tower = [6, 9, 5, 7, 4]
result = [0] * N
heights = tower
# print("tower: ",tower)
# print("result: ",result)
# print("heights: ",heights)
for _ in range(N):
    h = heights.pop()
    print("h: ",h)
    for i in heights[::-1]:
        print("i: ",i)
        if h < i:
            result[len(heights)] = tower.index(i) + 1
            print("result: ",result)
            break
        elif h >= i:
            continue
print(" ".join(map(str,result)))




