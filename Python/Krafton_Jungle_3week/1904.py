n = int(input())

array = [0]*1000001
array[1]=1
array[2]=2

def tile(n):
    for i in range(3,n+1):
        array[i] = (array[i-2]+array[i-1])%15746
    return array[n]
print(tile(n))