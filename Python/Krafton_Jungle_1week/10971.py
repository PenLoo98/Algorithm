import sys
input = sys.stdin.readline

def dfs_backTracking(start,next,value,visited):
    global min_value

    # 방문한 도시가 입력받은 도시의 갯수라면
    if len(visited) == N:
        # 마지막 도시에서 출발 도시로 갈 수 있다면
        if cities[next][start] != 0:
            min_value = min(min_value, value+cities[next][start])
        return 
    # 도시의 개수만큼 반복
    for i in range(N):
        # 현재 도시에서 갈 수 있는 비용이 0이 아니고, 이미 방문한 도시가 아니며 저장된 비용값이 최소일 때
        if cities[next][i] != 0 and i not in visited and value < min_value :
            visited.append(i)
            dfs_backTracking(start, i, value+cities[next][i], visited)
            visited.pop()

N = int(input())
cities = []
for _ in range(N):
    inputs = list(map(int, input().split()))
    cities.append(inputs)
min_value = sys.maxsize
        
for i in range(N):
    dfs_backTracking(i,i,0,[i])
print(min_value)