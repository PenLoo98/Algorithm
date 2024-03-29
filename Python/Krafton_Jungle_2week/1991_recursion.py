import sys
 
N = int(sys.stdin.readline().strip())
tree = {}
 
for n in range(N):
    root, left, right = sys.stdin.readline().strip().split()
    tree[root] = [left, right]

def prior_order(char):
    if char!=".":
        print(char,end="")
        prior_order(tree[char][0])
        prior_order(tree[char][1])

def in_order(char):
    if char!=".":
        in_order(tree[char][0])
        print(char,end="")
        in_order(tree[char][1])

def post_order(char):
    if char!=".":
        post_order(tree[char][0])
        post_order(tree[char][1])
        print(char,end="")

prior_order("A")
print()
in_order("A")
print()
post_order("A")