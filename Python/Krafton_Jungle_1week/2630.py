import sys
input = sys.stdin.readline

# 입력 받기
N = int(input())
papers = [list(map(int,input().split())) for _ in range(N)]
# 하얀색: 0, 파란색: 1
zero_count = 0
one_count = 0

# 사각형 배열의 입력을 4등분하는 함수
def divide_quarter(x,y,N):
    global zero_count
    global one_count
    half = N//2

    color = papers[x][y]
    for i in range(x,x+N):
        for j in range(y,y+N):
            if color != papers[i][j]:
                divide_quarter(x,y,half)
                divide_quarter(x,y+half,half)
                divide_quarter(x+half,y,half)
                divide_quarter(x+half,y+half,half)
                return
    if color==0:
        zero_count+=1
    elif color==1:
        one_count+=1
        
divide_quarter(0,0,N)

print(zero_count)
print(one_count)