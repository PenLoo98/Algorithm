import sys
input = sys.stdin.readline
from collections import deque

# 1. 입력 받기
n = int(input())
m = int(input())

forward = [[] for _ in range(n+1)] # forward[출발노드] = [도착노드, 이동시간]
backward = [[] for _ in range(n+1)] # backward[출발노드] = [도착노드, 이동시간]
in_degree = [0]*(n+1) # in_degree[노드] = 진입차수
distance = [0]*(n+1) # distance[노드] = 출발노드에서 해당 노드까지 총 이동한 거리
queue = deque() # 진입차수가 0인 노드를 저장하는 deque
for _ in range(m):
    before, after, time = map(int,input().split()) # 출발노드, 도착노드, 이동시간
    forward[before].append([after,time])
    backward[after].append([before,time])
    in_degree[after] += 1 
start,end = map(int, input().split()) # 출발도시, 도착도시

# 2. 진입차수 0인 노드를 시작노드로 정하기 
queue.append(start)

# 3. 시작 노드를 기준으로 시작노드와 연결된 간선을 하나씩 지운다.
while queue:
    current = queue.popleft()
    # 연결된 모든 노드를 확인한다.
    for after,time in forward[current]:
        in_degree[after]-=1 # 진입차수 1 감소
        distance[after] = max(distance[after], distance[current]+time) # 최장거리면 갱신
        if in_degree[after]==0: # 진입차수 0인 노드들 큐에 담기
            queue.append(after)
print(distance[end]) # 출발지에서 도착지까지의 최장거리 출력

# 4. 백트래킹하며 최장거리일 때 지나온 도로의 수를 카운트한다.
pass_routes = 0 # 최장거리일 때 지나온 도로의 수
visited = [False]*(n+1) # 방문했는지 확인하기 위해
queue.append(end) # 도착지를 출발지로 설정 -> 백트래킹 위해서
while queue:
    current = queue.popleft()
    # 연결된 모든 노드를 확인한다.
    for after,time in backward[current]:
        # 현재 노드와 연결된 도시라면 pass_routes를 카운트
        if distance[current] - distance[after] == time:
            pass_routes+=1
            # 중복 방문 방지
            if not visited[after]:
                queue.append(after)
                visited[after] = True
print(pass_routes)