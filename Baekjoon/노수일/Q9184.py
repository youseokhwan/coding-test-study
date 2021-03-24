result = ''

n = 101
# 이전 값들을 저장하기 위한 3차원 배열 101 * 101 * 101
abc = [[[0] * n for _ in range(n)] * n for _ in range(n)]


def w_function(a, b, c):
    a_index, b_index, c_index = a + 50, b + 50, c + 50

    # 값이 있으면 아래 연산 필요없이 바로 return
    if abc[a_index][b_index][c_index] != 0:
        return abc[a_index][b_index][c_index]

    # 문제에서 주어진 연산, 각각 케이스마다 return 하기전에 값을 저장
    if a <= 0 or b <= 0 or c <= 0:
        abc[a_index][b_index][c_index] = 1
        return 1

    if a > 20 or b > 20 or c > 20:
        w20 = w_function(20, 20, 20)
        abc[a_index][b_index][c_index] = w20
        return w20

    if a < b < c:
        value = w_function(a, b, c - 1) + w_function(a, b - 1, c - 1) - w_function(a, b - 1, c)
        abc[a_index][b_index][c_index] = value
        return value

    el_value = w_function(a - 1, b, c) + w_function(a - 1, b - 1, c) + w_function(a - 1, b, c - 1) - w_function(a - 1, b - 1, c - 1)
    abc[a_index][b_index][c_index] = el_value
    return el_value


while True:
    numbers = [int(num) for num in input().split(' ')]
    _a, _b, _c = numbers[0], numbers[1], numbers[2]

    if _a == -1 and _b == -1 and _c == -1:
        break
    result += f'w({_a}, {_b}, {_c}) = {w_function(_a, _b, _c)}\n'

print(result)
