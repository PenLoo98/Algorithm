import sys
input = sys.stdin.readline
from collections import deque

# 보드 크기 N과 사과의 갯수 K 입력
N = int(input())
K = int(input())

# 맵의 모든 좌표를 0으로 둔다.
graph = [[0]*N for _ in range(N)]
# 동, 남, 서, 북
dx = [1,0,-1,0]
dy = [0,1,0,-1]

# K개의 사과의 좌표를 2로 바꾼다.
for _ in range(K):
    x,y = map(int, input().split())
    graph[x-1][y-1] = 2

# L개의 뱀의 방향 변환 정보를 저장 (X:int,C:string)
L = int(input())
dirDict = dict()
# queue는 뱀의 몸통이 차지하는 좌표
queue = deque()
queue.append((0,0))

for _ in range(L):
    X,C = input().split()
    dirDict[int(X)] = C

x=0
y=0
graph[y][x] = 1
count = 0
direction = 0    

def turn(char):
    global direction
    if char == 'L':
        direction = (direction - 1) % 4
    elif char == 'D':
        direction = (direction + 1) % 4

while True:
    count += 1
    x += dx[direction]
    y += dy[direction]

    # 벽에 부딪히면 종료
    if x<0 or x>=N or y<0 or y>=N:
        break
    # 사과가 있으면 사과는 없어지고 꼬리는 그대로
    if graph[y][x]==2:
        graph[y][x] = 1
        queue.append((x,y))
        # count가 dirDict와 키값이 같다면 방향 "D" or "L"이 있다.
        if count in dirDict:
            turn(dirDict[count])
    # 사과가 없으면 몸길이를 줄여서 꼬리가 위차한 칸을 비워준다. 몸길이는 그대로
    elif graph[y][x]==0:
        graph[y][x] = 1
        queue.append((x,y))
        # 꼬리를 땡겨주기 때문에 큐의 맨 첫항을 제거한다.
        tx,ty = queue.popleft()
        graph[ty][tx] = 0
        if count in dirDict:
            turn(dirDict[count])
    else:
        break
# 게임이 몇 초에 끝나는지 출력하기
print(count)