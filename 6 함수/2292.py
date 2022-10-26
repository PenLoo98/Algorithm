# https://www.acmicpc.net/problem/2292
# 실제테스트에선 input과 print의 텍스트를 빼야함

N = int(input()) - 1
count = 1
circle = 1
while N > 0:
    N -= 6*circle
    count += 1
    circle += 1
print(count)