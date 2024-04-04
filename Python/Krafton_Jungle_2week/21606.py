import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

# 1. 입력받기
n = int(input())
a = "0"+input()
graph = [[]for _ in range(n+1)]
visited = [False]*(n+1)
total_cases = 0
for _ in range(n-1):
    start,end=map(int,input().split())
    graph[start].append(end)
    graph[end].append(start)
    # 2. 실내-실내 카운트하기 
    if a[start]=='1' and a[end]=='1':
        total_cases+=2

# 3. 실내를 기준으로 연결된 실외 확인하기 
def dfs(node):
    # 한 노드에서 연결된 노드를 전부 확인한다.
    visited[node]=True
    inside_count=0
    for connected_node in graph[node]:
        # 4. 실내를 만나면 다시 실내를 탐색하기 
        if a[connected_node]=='1':
            inside_count+=1
        elif a[connected_node]=='0' and not visited[connected_node]:
            inside_count+=dfs(connected_node)
    return inside_count

# 5. 모든 노드를 하나씩 순회 
for i in range(1,n+1):
    if a[i]=='0' and not visited[i]:
        adjacent_inside_nodes = dfs(i)
        total_cases += adjacent_inside_nodes*(adjacent_inside_nodes-1)

# 6. 모든 카운트를 출력하기
print(total_cases)