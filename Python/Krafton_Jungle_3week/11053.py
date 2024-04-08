import sys
input = sys.stdin.readline

n = int(input())
array = list(map(int,input().split()))
dp = [1]*n
for i in range(len(array)):
    for j in range(0,i):
        if array[j]<array[i]:
            dp[i]=max(dp[i], dp[j]+1)
print(max(dp))