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

# 다음점을 어떻게 정하지? 시작점이 before면서 cost가 제일 적은 걸로 골라야하는데 
# heapq인 board에서 뽑아야 하나? 

while heap:
    # heap에서 가장 작은 값을 pop
    # heap에서 뭘 뽑아서 값에 할당해야되지?
    current_distance, current_node = heapq.heappop(heap)

    # 목적지에 도달하면 총 이동거리 출력 
    if current_node==end:
        print(current_distance)
        break

    #  현재 노드에서 다음으로 갈 노드를 정한다.
    for next_node,next_cost in board[current_node]:
        sum_distacne = current_distance+next_cost
        if distance[next_node] <= sum_distacne:
            continue
        distance[next_node] = sum_distacne
        # 다음 목적지를 정했다면 heap에 저장한다.
        heapq.heappush(heap, [distance[next_node], next_node])