import sys
sys.setrecursionlimit(10**9)

bst = []

# input EOF
while True:
    try:
        bst.append(int(input()))
    except:
        break
def post_order(start, end):
    # 종료 조건
    if start > end:
        return
    root = bst[start]
    idx = start+1

    # 오른쪽 자식 노드 찾기
    while idx <= end:
        if bst[idx] > root:
            break
        idx += 1
    post_order(start+1, idx-1)
    post_order(idx, end)
    print(root)
post_order(0, len(bst)-1)