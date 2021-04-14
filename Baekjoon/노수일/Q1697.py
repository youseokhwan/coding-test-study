from sys import stdin
from collections import deque

n, k = map(int, stdin.readline().split())

MAX_LENGTH = 100001
road = [0] * MAX_LENGTH

if k > n:
    qu = deque()

    # 출발점을 큐에 넣음
    qu.append(n)

    while qu:
        now_index = qu.popleft()
        if now_index == k:
            break

        # 현재 위치 + 1, 현재 위치 - 1, 현재 위치 * 2 를 순회하면서
        for next_index in (now_index + 1, now_index - 1, 2 * now_index):
            # 다음 인덱스 (넘어갈 곳) = 0 이면
            if (0 <= next_index < MAX_LENGTH) and road[next_index] == 0:
                # 현재 위치만큼 온 시간 + 1
                road[next_index] = road[now_index] + 1
                # 다음 인덱스 큐에 삽입
                qu.append(next_index)
    print(road[k])
else:
    print(n - k)
