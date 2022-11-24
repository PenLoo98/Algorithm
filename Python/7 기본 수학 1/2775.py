# https://www.acmicpc.net/problem/2775

import sys
input = sys.stdin.readline

def infloor(K,N):
    if K==0:
        people = N
    elif K!=0:
        Nums=list(range(1,N+1))
        for _ in range(K):
            indexes = 0
            after = []
            for i in Nums:
                after.append(sum(Nums[:indexes+1]))
                indexes += 1   
            Nums = after
        people = Nums[N-1]
    print(people)

T = int(input())
for _ in range(T):
    K = int(input())
    N = int(input())
    infloor(K,N)
    
