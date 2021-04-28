from sys import stdin

n = int(stdin.readline())
numbers = [0] * n

for i in range(n):
    numbers[i] = int(stdin.readline())

memo = [0] * n
memo[0] = numbers[0]

for i in range(1, n):
    if i == 1:
        memo[i] = numbers[i - 1] + numbers[i]
    elif i == 2:
        memo[i] = max(numbers[i] + numbers[i - 1], numbers[i] + numbers[i - 2], memo[i - 1])
    else:
        memo[i] = max(numbers[i] + memo[i - 3] + numbers[i - 1], numbers[i] + memo[i - 2], memo[i - 1])


"""
 2579 와 비슷
 ... ㅁ ㅁ ㅁ ㅁ ...
 ........ o x ...
 ...... o x o ...
 .... o x o o ...
"""

print(memo[n - 1])
