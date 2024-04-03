import sys
input = sys.stdin.readline

# 입력 받기 
n,m=map(int,input().split())
marble = [[0]*(n+1) for _ in range(n+1)]
for _ in range(m):
    heavy,light = map(int,input().split())
    marble[heavy][light] = 1

# i>k , k>j이면 i>j이라는 걸 표시하기 
for k in range(n+1):
    for j in range(n+1):
        for i in range(n+1):
            if marble[i][k] and marble[k][j]:
                marble[i][j]=1

# 모든 구슬의 무거운, 가벼운 카운트 세기
# 어떻게 각각의 구슬마다 카운트를 할 수 있을까?
answer = 0
for i in range(1,n+1):
    heavy_count=0
    light_count=0
    for j in range(1,n+1):
        if marble[i][j]:
            heavy_count+=1
        elif marble[j][i]:
            light_count+=1
    if heavy_count > n//2 or light_count > n//2:
        answer+=1
print(answer)