import sys
input = sys.stdin.readline

# 입력 받기
n = int(input())
matrix_sizes = []

for _ in range(n):
    r, c = map(int, input().split())
    matrix_sizes.append((r, c))

# DP 테이블 초기화
dp = [[0] * n for _ in range(n)]

# 행렬 곱셈 연산 최소 횟수 계산
for chain_len in range(2, n + 1):  # 곱하는 행렬의 개수 (2부터 n까지)
    for i in range(n - chain_len + 1):  
        j = i + chain_len - 1  # j는 항상 i와 곱할 행렬 개수를 기준으로 결정됨
        dp[i][j] = float('inf')
        for k in range(i, j):
            # dp[i][k]와 dp[k+1][j]를 곱하는데 필요한 최소 횟수 계산
            # matrix_sizes[i][0]는 첫 번째 행렬의 행 개수,
            # matrix_sizes[k][1]는 k번째 행렬의 열 개수,
            # matrix_sizes[j][1]는 마지막 행렬의 열 개수
            cost = dp[i][k] + dp[k + 1][j] + matrix_sizes[i][0] * matrix_sizes[k][1] * matrix_sizes[j][1]
            if cost < dp[i][j]:
                dp[i][j] = cost

# 0번째부터 n-1번째 행렬까지 곱하는 최소 연산 횟수 출력
print(dp[0][n-1])
