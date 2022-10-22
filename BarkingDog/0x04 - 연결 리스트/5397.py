# https://www.acmicpc.net/problem/5397

import sys
T = int(sys.stdin.readline())
for _ in range(T):
    left, right = [], []
    for i in sys.stdin.readline().rstrip():
        if i == '<':
            if left != []:
                right.append(left.pop())
        elif i == '>':
            if right != []:
                left.append(right.pop())
        elif i == '-':
            if left != []:
                left.pop()
        else:
            left.append(i)
    # right가 뒤부터 출력되어야 하므로 reverse
    print(''.join(left + right[::-1]))





