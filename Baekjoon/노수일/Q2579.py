from sys import stdin

n = int(stdin.readline())
stairs = []
memo = []

for i in range(n):
    stairs.append(int(stdin.readline()))

"""
| | | | | | | | |
          m o x o
        m o x o o
"""

memo = [0] * n
memo[0] = stairs[0]

for i in range(1, n):
    if i == 1:
        memo[i] = stairs[i - 1] + stairs[i]
    elif i == 2:
        memo[i] = stairs[i] + max(stairs[i - 1], stairs[i - 2])
    else:
        memo[i] = stairs[i] + max(memo[i - 3] + stairs[i - 1], memo[i - 2])

print(memo[n - 1])
