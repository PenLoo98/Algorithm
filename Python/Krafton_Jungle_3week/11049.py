import sys
input = sys.stdin.readline

# 입력 받기
n=int(input())
matrix = []

for _ in range(n):
    r,c = map(int,input().split())
    matrix.append((r,c))

dp = [[0]*n for _ in range(n)]

def multiply(i,j):
    if dp[i][j] > 0:
        return dp[i][j]
    if i == j:
        return 0
    # dp로 풀기
    dp[i][j] = min([multiply(i,k) + multiply(k+1,j) + matrix[i][0]*matrix[k][1]*matrix[j][1] for k in range(i,j)])
    return dp[i][j]

print(multiply(0,n-1))