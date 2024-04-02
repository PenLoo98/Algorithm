import sys
import heapq
input = sys.stdin.readline

n = int(input())
# 남,동,서,북
dx = [0,1,-1,0]
dy = [1,0,0,-1]
count = 0

while n != 0:
    count+=1
    board = [list(map(int,input().split())) for _ in range(n)]
    # 최단 경로를 저장하는 최소 힙
    heap = []
    distance = [[float('inf')]*n for _ in range(n)]
    distance[0][0] = board[0][0]
    # 최소힙인 heap에 (board[0][0],0,0)을 넣는다.
    heapq.heappush(heap,(board[0][0],0,0))

    while heap:
        # heap에서 가장 작은 값을 pop한다.
        cost,y,x = heapq.heappop(heap)

        # 최소 가중치를 먼저 가기 때문에 [n-1][n-1]에 도착하면 break한다.
        if y==n-1 and x==n-1:
            print(f'Problem {count}: {cost}')
            n = int(input())
            break
        # 남,동,서,북으로 이동한다.
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]

            # 이동한 좌표가 범위 내에 있으면
            if 0<=nx<n and 0<=ny<n:
                # 이동한 좌표의 가중치가 현재 가중치+이동한 좌표의 가중치보다 크면
                if distance[ny][nx] > cost+board[ny][nx]:
                    # 이동한 좌표의 가중치를 현재 가중치+이동한 좌표의 가중치로 갱신한다.
                    distance[ny][nx] = cost+board[ny][nx]
                    # heap에 (현재 가중치+이동한 좌표의 가중치,이동한 y좌표,이동한 x좌표)를 넣는다.
                    heapq.heappush(heap,(distance[ny][nx],ny,nx))        