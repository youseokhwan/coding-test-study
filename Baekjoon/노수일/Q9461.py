from sys import stdin

case = int(stdin.readline())
p_memo = {1: 1, 2: 1, 3: 1}

"""
1, 1, 1, 2, 2, 3, 4, 5, 7, 9
"""


def memo(num):
    if num in p_memo:
        return p_memo[num]
    else:
        p_memo[num] = memo(num - 2) + memo(num - 3)
        return p_memo[num]


result = ''
for i in range(case):
    number = int(stdin.readline())
    p_n = memo(number)
    result += f'{p_n}\n'

print(result)
