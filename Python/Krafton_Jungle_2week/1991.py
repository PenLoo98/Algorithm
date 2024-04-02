import sys
input = sys.stdin.readline

#
n = int(input())
tree = {}

for _ in range(n):
    node,lchild,rchild = input().split()
    tree[node] = [lchild,rchild]

# 전위 순회: 부모 -> 왼쪽 -> 오른쪽
# 중위 순회: 왼쪽 -> 부모 -> 오른쪽
# 후위 순회: 왼쪽 -> 오른쪽 -> 부모

# ABD가 나와야 하므로 A->C->B 순서로 들어가야 한다.
def pre_order(node): 
    stack = [node]
    while stack:
        current = stack.pop()
        if current != '.':
            print(current, end="")
            stack.append(tree[current][1])
            stack.append(tree[current][0])

# 중위 순회
def in_order(node): 
    stack = []
    current = node
    while True:
        if current !='.':
            stack.append(current)
            current = tree[current][0]
        elif current =='.' and stack:
            current = stack.pop()
            print(current,end='')
            current = tree[current][1]
        else:
            break

# 후위 순회
def post_order(root_node):
    stack = [root_node]
    visited = []
    while stack:
        current = stack[-1]
        left_child = tree[current][0]
        right_child = tree[current][1]

        # 자식 노드의 왼쪽이 있으면 더 탐색
        if left_child!='.' and left_child not in visited:
            stack.append(left_child)

        # 자식 노드의 오른쪽이 있으면 더 탐색 (왼쪽 했으면 오른쪽은 불가능)
        elif right_child!='.' and right_child not in visited:
            stack.append(right_child)

        # 자식 노드가 없으면 pop하고 출력
        else:
            current = stack.pop()
            print(current,end='')
            visited.append(current)
            
pre_order('A')
print()
in_order('A')
print()
post_order('A')