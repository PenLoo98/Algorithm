import sys
input = sys.stdin.readline

#
n = int(input())
position = []
stack = []

for _ in range(n):
    node,lchild,rchild = input().split()
    position.append([node,lchild,rchild])


# 전위 순회: 부모 -> 왼쪽 -> 오른쪽

# 중위 순회: 왼쪽 -> 부모 -> 오른쪽

# 후위 순회: 왼쪽 -> 오른쪽 -> 부모

def pre_order(num): 
    # 왼쪽이면 탐색 
    if position[num][1]!='.':
        print(position[num][0],end="")
        stack.append(position[num][0])
        stack.pop()

    # 오른쪽이면 탐색
    if position[num][2]!='.':
        stack.append(position[num][0])
        pre_order(num+1)
        stack.pop()

def in_order(num): 
    # 왼쪽이면 탐색 
    if position[num][1]!='.':
        stack.append(position[num][0])
        pre_order(num+1)
        stack.pop()
    # 출력
    print(position[num][0],end="")
    # 오른쪽이면 탐색
    if position[num][2]!='.':
        stack.append(position[num][0])
        pre_order(num+1)
        stack.pop()

def post_order(num): 
    # 왼쪽이면 탐색 
    if position[num][1]!='.':
        stack.append(position[num][0])
        pre_order(num+1)
        stack.pop()
    # 오른쪽이면 탐색
    if position[num][2]!='.':
        stack.append(position[num][0])
        pre_order(num+1)
        stack.pop()
    # 출력
    print(position[num][0],end="")

pre_order(0)
print()
in_order(0)
print()
post_order(0)