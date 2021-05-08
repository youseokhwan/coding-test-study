from collections import deque
from sys import stdin

r, c = map(int, stdin.readline().split())
board = [list(stdin.readline().strip()) for _ in range(r)]

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

queue = set([(0, 0, board[0][0])])

count = 1
while queue:
    y, x, alphabets = queue.pop()
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if nx < 0 or nx >= c or ny < 0 or ny >= r:
            continue

        if board[ny][nx] not in alphabets:
            next_alphabet = alphabets + board[ny][nx]
            queue.add((ny, nx, next_alphabet))
            count = max(count, len(next_alphabet))

print(count)

"""
2 4
CAAB
ADCB
"""
