import sys
import heapq
input = sys.stdin.readline

n = int(input())
m = int(input())
# 출발 도시, 도착 도시, 걸리는 시간
move_time = []
for _ in range(m):
    start, end, time = map(int, input().split())
    # 최대힙으로 저장하기 위해 -time을 인덱스 0에 저장
    heapq.heappush(-time, start, end, time)
start_city, end_city = map(int, input().split())

# 데이터 자료구조 뭘로 해야되지? 
# 

# 제일 오래 걸리는 경로로 올 때 시간 구하기
# 이동거리 0으로 두고 더 긴 이동거리가 있을 때마다 갱신해주면 될듯?

# 가장 많은 도로를 거쳐서 오는 사람이 달린 도로의 수 구하기
# 위상정렬로 노드 차수 1씩 지우면서 지나온 도로 수만큼 move 카운트 증가 
# move 카운터 최대값 출력 -> 이동 경로별로 move카운트 저장해야하나? 
# 아니면 그냥 move 카운트가 더 클때마다 갱신해주면 될듯 -> DP처럼?
# 

# 만나는 시간, 도로의 수 출력 