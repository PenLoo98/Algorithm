import sys
input = sys.stdin.readline
# 입력 받기 
n,k = map(int,input().rstrip().split())
# 가로: 배낭 무게, 세로: 아이템 무게
graph = [[0]*(k+1) for _ in range(n+1)]
items = [(0,0)]

for _ in range(n):
    weight,value = map(int,input().rstrip().split())
    items.append((weight,value))

# 아이템을 하나씩 넣어보며 최대 가치를 구한다.
for y in range(1,n+1):
    weight,value = items[y]
    for x in range(1,k+1):
        if x-weight < 0:
            graph[y][x] = graph[y-1][x]
        else:
            graph[y][x] = max(graph[y-1][x], graph[y-1][x-weight] + value)
print(graph[n][k])