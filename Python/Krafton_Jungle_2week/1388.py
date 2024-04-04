import sys
input = sys.stdin.readline
n,m = map(int,input().split())
graph = []

# 1. 입력받기
total_trees = 0
graph.append([])
for i in range(1,n+1):
     graph.append("0"+input().strip())
# 행 카운트하기
# '-'모양이면 카운트하다가 '|'만나면 카운트 중지
for i in range(1,n+1):
    column_count = 0
    for j in range(1,m+1):
        if graph[i][j] == '-':
            while j < m and graph[i][j] == '-':
                j += 1 
                column_count += 1
    if column_count > 0:
        total_trees += 1
    column_count = 0
# 열 카운트하기
# '|'모양이면 카운트하다가 '-'만나면 카운트 중지
for j in range(1,m+1):
    row_count = 0
    for i in range(1,n+1):
        if graph[i][j] == '|':
            while i < n and graph[i][j] == '|':
                i += 1
                row_count += 1
    if row_count > 0:
        total_trees += 1
    row_count = 0
    
print(total_trees)