n = int(input())
test_case = []

for _ in range(n):
    test_case.append([int(num) for num in input().split()])


def move(x_y):
    count = 0

    x = x_y[0]
    y = x_y[1]

    k = 1
    k_sum = 0
    distance = y - x
    while k_sum < distance:
        count += 1
        k_sum += k
        if count % 2 == 0:
            k += 1

    return count


result = ''
for case in test_case:
    result += f'{move(case)}\n'

print(result)


"""
0 1 2 3 4 5 6 7 8 9
-> 1
-> 0, 1, 2
-> 1, 2, 3

1
1 1
1 1 1
1 2 1
1 2 1 1
1 2 2 1
1 2 2 1 1
1 2 2 2 1
1 2 3 2 1
"""