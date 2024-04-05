import sys
input = sys.stdin.readline
t = int(input())
dic = [0]*10001


for _ in range(t):
    # 0부터 m까지의 인덱스를 가진 배열을 선언한다.
    n = int(input())
    coins = list(map(int,input().split()))
    m = int(input())

    # 화폐의 가치를 배열로 선언 
    array = [0]*(m+1)
    array[0] = 1

    # 작은 동전부터 순서대로 경우의 수를 계산
    for coin in coins:
        for i in range(coin, m+1):
            array[i] += array[i-coin]
    print(array[m])