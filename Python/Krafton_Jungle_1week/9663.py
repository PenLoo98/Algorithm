import sys
input = sys.stdin.readline

# 안전한 자리인지 확인
def is_safe(startRow):
    for i in range(startRow):
        if rows[i]==rows[startRow] or abs(rows[i]-rows[startRow]) == rows[i]-rows[startRow]:
            return False
    return True

# 퀸 
def n_queen(startRow):
    global count
    # 순회를 마쳤다면 가능한 경우의 수 count 1 증가
    if startRow == N:
        count += 1
    else:
        for i in range(N):
            rows[i]=startRow
            if is_safe(startRow):
                n_queen(startRow+1)    

N = int(input())
count = 0
rows = [0]*N
n_queen(0)
print(count)