import sys
input = sys.stdin.readline

N = int(input())

def is_safe(row_index):
    for i in range(row_index):
        # 같은 행
        if row[row_index] == row[i] or abs(row[row_index] - row[i]) == abs(row_index-i):
            return False
    return True

def n_queen(startRow):
    global count
    
    # 마지막 행까지 탐색한 경우
    if startRow==N:
        count += 1
    else:
        for column in range(N):
            row[startRow] = column
            # 퀸이 안전 하다면 다음 탐색
            if is_safe(startRow):
                n_queen(startRow+1)

row = [0] * N
count = 0
n_queen(0)

print(count)