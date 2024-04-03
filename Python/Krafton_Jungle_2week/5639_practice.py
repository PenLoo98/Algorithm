import sys
# 재귀호출 횟수 제한 해제
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

bst = []

while True:
    try:
        n = int(input())
        # sys.stdin.readline 종료 문자 방지
        if n=="":
            break
        bst.append(n)
    except:
        break

def post_order(start,end):
    # 종료 조건
    if start>end:
        return
    
    root = bst[start]
    idx = start+1

    while idx <= end:
        # 루트 노드보다 큰 오른쪽 자식노드 찾기
        if root < bst[idx]:
            break
        idx +=1
    # idx는 루트 노드보다 큰 자식 노드의 인덱스값
    post_order(start+1, idx-1)
    post_order(idx, end)
    print(root)

post_order(0, len(bst)-1)