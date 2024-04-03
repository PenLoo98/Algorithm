import sys
import heapq
input = sys.stdin.readline

n = int(input())
m = int(input())

# 0~n까지의 배열을 생성함.
board = [[] for _ in range(n+1)]
distance = [float('inf') for _ in range(n+1)]

for _ in range(m):
    before, after, cost = map(int,input().split())
    board[before].append([after,cost])

start, end = map(int, input().split())

# 시작점 이동거리 0
distance[start] = 0
heap = []

# cost, current_node
heapq.heappush(heap, [0,start]) 

while heap:
    # heap에서 가장 작은 값을 pop
    current_cost, current_node = heapq.heappop(heap)

    # 목적지에 도달하면 총 이동거리 출력 
    if current_node == end:
        print(current_cost)
        break

    # 현재 노드에서 다음으로 갈 노드를 정한다.
    for next_node, next_cost in board[current_node]:
        # 기존 최단거리보다 더 짧다면 갱신한다. 
        sum_distance = current_cost+next_cost
        if distance[next_node] <= sum_distance:
            continue
        distance[next_node] = sum_distance
        # 다음 목적지를 정했다면 heap에 저장한다.
        heapq.heappush(heap, [distance[next_node], next_node])