from sys import stdin

n = int(stdin.readline())


def evaluate(num, operation, finish):
    operation += str(num)
    if num == finish:
        if eval(operation.replace(' ', '')) == 0:
            answer.append(operation)
        return

    evaluate(num + 1, operation + '+', finish)
    evaluate(num + 1, operation + '-', finish)
    evaluate(num + 1, operation + ' ', finish)


result = ''

for _ in range(n):
    number = int(input())
    answer = []
    evaluate(1, '', number)
    answer.sort()
    for j in range(len(answer)):
        result += f'{answer[j]}\n'
    result += '\n'

print(result)
