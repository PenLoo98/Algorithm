inputs = ['a', 'but', 'not', 'more']

# 리스트를 길이 순으로 정렬 후, 사전 순으로 정렬
inputs.sort(key=lambda x: (len(x),x))
for word in inputs:
    print(word)
