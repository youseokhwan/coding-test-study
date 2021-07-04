from collections import deque


def solution(n, computers):
    answer = 0
    for i in range(n):
        for j in range(i + 1):
            if not computers[i][j] or computers[i][j] == 0:
                continue
            queue = deque([(i, j)])
            while queue:
                y, x = queue.popleft()
                computers[y][x] = False
                for n_i in range(n):
                    for n_j in range(n_i + 1):
                        if not computers[n_i][n_j] or computers[n_i][n_j] == 0:
                            continue
                        if n_i == x or n_i == y or n_j == x or n_j == y:
                            queue.append((n_i, n_j))

            answer += 1
    return answer


print(solution(3, [[1, 1, 0], [1, 1, 0], [0, 0, 1]]))
print(solution(3, [[1, 1, 0], [1, 1, 1], [0, 1, 1]]))

"""
1   2  3
|   |  |
4 - 5  6
"""

print(solution(6, [[1, 0, 0, 1, 0, 0],
                   [0, 1, 0, 0, 1, 0],
                   [0, 0, 1, 0, 0, 1],
                   [1, 0, 0, 1, 1, 0],
                   [0, 1, 0, 1, 1, 0],
                   [0, 0, 1, 0, 0, 1]]))
