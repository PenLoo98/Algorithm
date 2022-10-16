# https://www.acmicpc.net/problem/2490
for i in range(3):
    a, b, c, d = map(int, input().split())
    cnt = 0
    if a == 1:
        cnt += 1
    if b == 1:
        cnt += 1
    if c == 1:
        cnt += 1
    if d == 1:
        cnt += 1

    if cnt == 0:
        print('D')
    elif cnt == 1:
        print('C')
    elif cnt == 2:
        print('B')
    elif cnt == 3:
        print('A')
    elif cnt == 4:
        print('E')

