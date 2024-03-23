def hanoi_tower(n, start, end, by):
    if(n==0):
        return 0
    # 목표 지점외 나머지 지점으로 n-1개의 원판을 옮긴다.(start->by)
    hanoi_tower(n-1, start, by, end)
    print(start, end)
    # 나머지 지점에 있던 n-1개의 원판을 목표 지점으로 옮긴다.(by->end) 
    hanoi_tower(n-1, by, end, start)

N = int(input())
if N>20:
    print(2**N-1)
elif N<=20:
    print(2**N-1)
    hanoi_tower(N,1,3,2)