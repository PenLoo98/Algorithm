import sys
input = sys.stdin.readline

# 안전한 자리인지 확인
def is_safe(startRow):
    for i in range(startRow):
        # rows[i]==rows[startRow] 열이 일치하는 지
        # abs(rows[i]-rows[startRow]) == rows[i]-rows[startRow] 대각선이 일치하는 지
        if rows[i]==rows[startRow] or abs(rows[i]-rows[startRow]) == i-startRow:
            return False
    return True

# 퀸 
def set(i):
    global count
    for j in range(N):
        if not rows[j] 
            and not row_diagonal[i+j]
            and not row_diagonal_reverse[i-j+N-1]
        



N = int(input())
count = 0
position = [0]*N
rows = [False]*N
row_diagonal = [False]*(2*N-1)
row_diagonal_reverse = [False]*(2*N-1)
set(0)
print(count)