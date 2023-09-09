# https://www.acmicpc.net/problem/1406
# https://seongonion.tistory.com/53

import sys
# rstrip()을 넣어야 S에 "\n"가 추가가 안됌.
S = sys.stdin.readline().rstrip()
M = int(sys.stdin.readline())
left = list(S)
right = []

for i in range(M):
    cmd = list(sys.stdin.readline().rstrip())
    if cmd[0] == 'L':
        if left != []:
            right.append(left.pop())
    elif cmd[0] == 'D':
        if right != []:
            left.append(right.pop())
    elif cmd[0] == 'B':
        if left != []:
            left.pop()
    elif cmd[0] == 'P':
        left.append(cmd[2])

# 뒤에서부터 꺼내야 하므로 reversed
print("".join(left+list(reversed(right))))
