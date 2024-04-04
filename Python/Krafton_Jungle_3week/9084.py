import sys
sys.setrecursionlimit(10**8)
input = sys.stdin.readline
t = int(input())
dic = [0]*10001


def make(m):
    # 이미 계산한 결과인 경우 
    if dic[m]:
        return dic[m]

    # 새로 계산하는 경우
    for coin in coins:
        dic[m] += make(m-coin)
    return dic[m]

for _ in range(t):
    n = int(input())
    coins = list(map(int,input().split()))
    m = int(input())
    # 0부터 m까지의 인덱스를 가진 배열을 선언한다.
    print(make(m))