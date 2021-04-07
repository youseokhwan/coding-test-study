import sys

input = sys.stdin.readline
m, n = map(int, input().split())
MAX = 1000000

memo = [True] * (MAX + 1)
memo[0], memo[1] = False, False

for i in range(2, MAX + 1):

    # 체에 걸러지지 않았음 -> 소수
    if memo[i] is True:

        # 소수의 제곱수 부터 배수는 전부 소수가 아님
        j = i * i
        for _ in range(j, MAX + 1, i):
            memo[j] = False
            j = j + i

result = ''
for i in range(m, n + 1):
    if memo[i] is True:
        result += f'{i}\n'

print(result)
