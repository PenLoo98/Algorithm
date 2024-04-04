import sys
input = sys.stdin.readline
n,m = map(int,input().split())
graph = []

# 1. 입력받기
total_trees = 0
graph.append([])
for i in range(1,n+1):
     graph.append("0"+input().strip())
print(graph)
# list_case = [[], ['0-||--||--'], ['0--||--||-'], ['0|--||--||'], ['0||--||--|'], ['0-||--||--'], ['0--||--||-']]
# print(list_case[1][0][0])