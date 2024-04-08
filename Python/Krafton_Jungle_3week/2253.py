import sys
from collections import deque
input = sys.stdin.readline

# 입력 받기
n,m = map(int,input().split())
# 가로: 돌의 번호 수
stones = [[i-1] for i in range(n+1)]
queue = deque()
for _ in range(m):
    small = int(input())
    stones[small]=float('inf')


jump = 1
# 돌의 번호 수만큼 반복
for i in range(2,n+1):
    for velocity in [-1,0,1]:
        move = jump + velocity
        if 0<i+move<=n and not stones[i+move]==float('inf') and not stones[i]==float('inf'):
            stones[i+move] = min(stones[i+move],stones[i]+1) 

print(stones[n])

# 1 2 4 7 10 14 16