import sys
input = sys.stdin.readline
N = int(input())
N_list = list(map(int,input().split(" ")))
N_list.sort()

M = int(input())
M_list = list(map(int,input().split(" ")))

# in 메서드를 쓰면 BigO(n**2)이 되므로 다른 방법을 써야한다.
for num in M_list:
    start, end = 0,len(N_list)-1
    while(start<=end):
        middle=(start+end)//2
        if N_list[middle]==num:
            start = middle
            end = middle
            break
        # 인덱스에 해당하는 값이 num보다 크다 -> 인덱스를 낮춰야한다.
        elif N_list[middle] > num:
            end=middle-1
        # 인덱스에 해당하는 값이 num보다 작다 -> 인덱스를 높여야한다.
        elif N_list[middle] < num:
            start=middle+1
    if(start==middle and end==middle):
        print(1)
    else:
        print(0)