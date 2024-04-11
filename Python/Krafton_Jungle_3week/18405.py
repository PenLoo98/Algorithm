import sys
input = sys.stdin.readline
from collections import deque

# 입력받기
n,k = map(int,input().split())
cylinder = []
virus = []
for i in range(n):
    cylinder.append(list(map(int,input().split())))
    for j in range(n):
        if cylinder[i][j]!=0:
            virus.append((cylinder[i][j],i,j))
s,X,Y = map(int,input().split())
# 작은 번호의 바이러스부터 전염
virus.sort()

# 상하좌우
dx = [-1,1,0,0]
dy = [0,0,-1,1]

def bfs(s,X,Y):
    q = deque(virus)
    count = 0
    while q:
        if count==s:
            break
        # 1초가 경과했을 떄 바이러스를 퍼트린다.
        for _ in range(len(q)):
            prev,x,y=q.popleft()
            # 상하좌우 탐색
            for i in range(4):
                nx = x+dx[i]
                ny = y+dy[i]
                # 0인 곳이 있으면 바이러스 퍼트림 
                if 0<=nx<n and 0<=ny<n:
                    if cylinder[nx][ny]==0:
                        cylinder[nx][ny]=prev
                        # 바이러스 퍼진 곳을 q에 저장
                        q.append((cylinder[nx][ny],nx,ny))
        count+=1
    return cylinder[X-1][Y-1]
print(bfs(s,X,Y))