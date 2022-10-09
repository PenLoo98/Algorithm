# https://www.acmicpc.net/problem/1316

alphabet_list = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                 'u', 'v', 'w', 'x', 'y', 'z']

N = int(input())

count = 0
for i in range(0, N):
    # 단어 입력
    word = str(input())
    alphabets = []
    for alphabet in alphabet_list:
        # 단어에 있는 알파뱃 저장
        if word.find(alphabet) >= 0:
            alphabets += [alphabet]
    # 저장한 순서대로 삭제 (미구현)
    for alphabet in alphabets:
        word = word.lstrip(alphabet)
    # 다 삭제되었으면 연속문자 => 카운트 추가
        if word =='':
            count +=1
print(count)




