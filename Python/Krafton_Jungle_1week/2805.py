import sys
input = sys.stdin.readline

# 입력받고 정수로 변환
N,M = map(int, input().split(" "))
trees = list(map(int, input().split(" ")))
# 오름차순으로 정렬
trees.sort()

# 초기값 설정
start, end = 0, max(trees)

def get_total_cut_length(trees, height):
    total_length = 0
    for tree in trees:
        if (tree > height):
            total_length += tree-height
    return total_length

while(start<=end):
    middle = (start+end)//2
    # middle값일 때 total_length를 구한다.
    total_length = get_total_cut_length(trees, middle)
    
    if(M > total_length):
        end = middle-1
    elif(M < total_length):
        start = middle+1
    # M==total_length면 
    else:
        end=middle
        break
print(end)