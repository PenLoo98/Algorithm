n = int(input())
array = [0]*91
array[1] = 1

def fibonacci(n):
    if array[n]:
        return array[n]
    elif n == 0:
        return 0
    else:
        array[n] = fibonacci(n-1) + fibonacci(n-2)
        return array[n]
print(fibonacci(n))