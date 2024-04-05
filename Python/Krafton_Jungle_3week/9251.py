import sys
input = sys.stdin.readline
string1 = '0'+input().rstrip()
string2 = '0'+input().rstrip()

n = len(string1)
m = len(string2)

graph = [[0]*n for _ in range(m)]

for i in range(1, m):
    for j in range(1,n):
        # 좌 또는 상의 값에서 최대값에 
        graph[i][j] = max(graph[i-1][j], graph[i][j-1])
        # 같은 경우 1을 더한다.
        if string1[j]==string2[i]:
            graph[i][j]=graph[i-1][j-1]+1
print(graph[m-1][n-1])