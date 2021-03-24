from sys import stdin

t = int(stdin.readline())
memoization = [None] * 41
# 0이 1번 1이 0번이라는 뜻
memoization[0] = {0: 1, 1: 0}
# 0이 0번 1이 1번이라는 뜻
memoization[1] = {0: 0, 1: 1}
result = ''


def fibonacci(number: int) -> dict:
    if number == 0:
        return memoization[0]
    elif number == 1:
        return memoization[1]
    elif memoization[number] is not None:
        return memoization[number]
    else:
        # n-1, n-2 를 구해서 0의 갯수, 1의 갯수를 합한 값을 넣음
        first_dict = fibonacci(number - 1)
        second_dict = fibonacci(number - 2)
        memoization[number] = dict()
        memoization[number][0] = first_dict[0] + second_dict[0]
        memoization[number][1] = first_dict[1] + second_dict[1]
        return memoization[number]


for i in range(0, t):
    num = int(stdin.readline())
    fibonacci(num)
    result += str(memoization[num][0]) + ' ' + str(memoization[num][1]) + '\n'

print(result)
