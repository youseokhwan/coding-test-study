import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())
lab = []
dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]
for _ in range(n):
    lab.append([int(num) for num in input().split()])

result = 0


def bfs():
    temp_lab = [[0] * m for _ in range(n)]
    queue = deque()

    for i in range(n):
        for j in range(m):
            temp_lab[i][j] = lab[i][j]
            if temp_lab[i][j] == 2:
                queue.append((i, j))

    while queue:
        (y, x) = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            # 밖으로 나가지 않게 조절
            if nx < 0 or ny < 0 or nx >= m or ny >= n:
                continue

            if temp_lab[ny][nx] == 0:
                temp_lab[ny][nx] = 2
                queue.append((ny, nx))

    safe_count = 0
    for i in range(n):
        for j in range(m):
            if temp_lab[i][j] == 0:
                safe_count = safe_count + 1

    global result
    if safe_count > result:
        result = safe_count


def make_wall(count):

    if count == 3:
        bfs()
        return

    for i in range(n):
        for j in range(m):
            if lab[i][j] == 0:
                lab[i][j] = 1
                make_wall(count + 1)
                lab[i][j] = 0


make_wall(0)

print(result)
