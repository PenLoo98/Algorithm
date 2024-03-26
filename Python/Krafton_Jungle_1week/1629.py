import sys
input = sys.stdin.readline
A,B,C = map(int,input().split())
def divide_and_square(A,B):
    result = 1
    while B:
        if(B%2==1):
            result*=A
        result*=A**(B//2)
        B=B//2
    return result
print(divide_and_square(A,B)%C)
