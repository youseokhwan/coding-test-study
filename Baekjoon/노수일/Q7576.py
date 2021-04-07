import sys
from collections import deque

input = sys.stdin.readline

m, n = map(int, input().split())
storage = []
dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

for _ in range(n):
    storage.append([int(num) for num in input().split()])

queue = deque()
for i in range(n):
    for j in range(m):
        if storage[i][j] == 1:
            queue.append((i, j))

max_count = 0

while queue:
    (y, x) = queue.popleft()

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        # 밖으로 나가지 않게 조절
        if nx < 0 or ny < 0 or nx >= m or ny >= n:
            continue

        # 다음 노드가 안익은 토마토라면
        if storage[ny][nx] == 0:
            # 익게만들고 그 노드부터 탐색
            storage[ny][nx] = storage[y][x] + 1
            queue.append((ny, nx))

# 전부 익었는지 검사
all_clear = True
for line in storage:
    if 0 in line:
        all_clear = False

if all_clear:
    # 1부터 시작하므로 일수는 배열 내 최대값 -1
    print(max(map(max, storage)) - 1)
else:
    print('-1')
