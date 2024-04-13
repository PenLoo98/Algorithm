import sys
input = sys.stdin.readline

# 입력 받기
n=int(input())
matrix = [list(map(int,input().split())) for _ in range(n)]

# 순서대로 곱해야한다.
dp = [[0]*n for _ in range(n)]

# n: 행렬의 수
# i: 곱셈을 수행할 행렬의 개수

for term in range(1,n):
    for i in range(0,n-term):
        if term==1:
            dp[i][i+term] = matrix[i][0]*matrix[i+term][0]*matrix[i+term][1]
            continue
        dp[i][i+term] = float('inf')
        for mid in range(i,i+term):
            dp[i][i+term] = min(dp[i][i+term],
                                dp[i][mid]+dp[mid+1][i+term]+matrix[i][0]*matrix[mid][1]*matrix[i+term][1])
print(dp[0][n-1])