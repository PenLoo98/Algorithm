    # (0), 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987
    # 16번째까지의 피보나치 수열
n = int(input())
left = 0
right = 0
array = []

def fivonacci(n,left,right):
    if n==0:
        return 0
    elif left>0 and right>0:
        sum = left+right
        array.append(sum)
        left = right 
        right = sum
    elif left==0:
        left+=1
        array.append(left)
    elif right==0:
        right+=1
        array.append(right)
    fivonacci(n-1,left,right)
    
fivonacci(n,left,right)
print(array)

