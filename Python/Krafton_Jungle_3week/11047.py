import sys
input = sys.stdin.readline

n,k = map(int,input().split())
coins = []
for _ in range(n):
    coins.append(int(input()))
coins = [coin for coin in coins if coin<=k]
coins.sort(reverse=True)
count = 0
sum = 0
for coin in coins:
    while k>sum:
        if k>=sum+coin:
            count+=k//coin
            k=k%coin
        else:
            break
print(count)