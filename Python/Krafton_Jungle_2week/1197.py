import sys
input = sys.stdin.readline

# 1. 입력 받기
v,e = map(int,input().split())
graph = [[]*(v+1) for _ in range(v+1)]
for _ in range(e):
    start, end, weight = map(int,input().split())
    graph[start].append([end,weight])

# 2. 최소 스패닝 트리의 가중치
    
# 3. 


# 결과 출력
total_weight = 0
print(total_weight)