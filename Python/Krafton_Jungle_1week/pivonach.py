def fivonacci(n):
    array = []
    left = 1
    right = 1
    for i in range(n):
        if i>1:
            sum = left+right
            array.append(sum)
            left = right 
            right = sum
        elif i<=1:
            array.append(1)
    return print(array)

pivo(int(input()))
    # (0), 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987
    # 16번째까지의 피보나치 수열

