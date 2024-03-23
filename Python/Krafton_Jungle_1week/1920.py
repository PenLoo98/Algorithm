N = int(input())
N_list = list(input().split(" "))
N_list = [int(i) for i in N_list]
N_list.sort()

M = int(input())
M_list = list(input().split(" "))


# in 메서드를 쓰면 BigO(n**2)이 되므로 다른 방법을 써야한다.
for num in M_list:
    if(int(num) in N_list):
        print(1)
    else:
        print(0)