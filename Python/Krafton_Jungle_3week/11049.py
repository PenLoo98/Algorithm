import sys
input = sys.stdin.readline

# 입력 받기
n=int(input())
matrix = [list(map(int,input().split())) for _ in range(n)]

# 순서대로 곱해야한다.
dp = [[0]*n for _ in range(n)]

# n: 행렬의 수
# i: 곱셈을 수행할 행렬의 개수
for i in range(1,n): # 
    for j in range(0,n-i): 
        if i==1:
            # 1칸 밖에 차이나지 않는 건 그냥 곱합
            dp[j][j+i] = matrix[j][0]*matrix[j+i][0]*matrix[j+i][1]
            continue

        dp[j][j+i] = float('inf')
        for k in range(j,j+i):
            dp[j][j+i] = min(dp[j][j+i],
                             dp[j][k]+dp[k+1][j+i]+matrix[j][0]+matrix[k][1]+matrix[j+i][1])
print(dp[0][n-1])