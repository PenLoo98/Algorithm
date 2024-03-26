import sys
input = sys.stdin.readline

array = [2,8,7,1,3,5,6,4]

def quick_sort(array,start,end):
    n = len(array)
    pl = 0
    pr = n-1
    x = array[n//2]

    while pl <= pr:
        while array[pl] >= x: pl+=1
        while array[pr] <= x: pr-=1
        if pl <= pr:
            array[pl], array[pr] = array[pr], array[pl]
            pl +=1
            pr -=1
    print(f"피벗은 {x}입니다.")

    print("피벗 이하인 그룹입니다.")
    print(*array[0:pl])
        


    