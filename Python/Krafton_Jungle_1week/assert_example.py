def divide(numerator, denominator):
    # 입력값이 정수가 아니라면 에러를 발생시킨다.
    assert type(numerator) == int, "Numerator must be an integer"
    assert type(denominator) == int, "Denominator must be an integer"
    # 분모가 0이라면 에러를 발생시킨다.
    assert denominator != 0, "Denominator cannot be zero"
    return numerator/denominator

print(divide(10, 0))
    