def factorial(n, answer):
    if(n>1):
        answer *=n
        return factorial(n-1, answer)    
    elif(n==1):
        return print(answer)
    elif(n==0):
        return print(answer)

answer = 1
factorial(int(input()), answer)