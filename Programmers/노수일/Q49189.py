import heapq


def solution(n, edge):
    graph = [[] for _ in range(n)]
    distance = [50000 for _ in range(n)]
    for row in edge:
        graph[row[0] - 1].append((row[1] - 1, 1))
        graph[row[1] - 1].append((row[0] - 1, 1))

    q = []
    heapq.heappush(q, (0, 0))
    distance[0] = 0
    while q:
        dist, now = heapq.heappop(q)

        if distance[now] < dist:
            continue

        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

    largest = max(distance)
    answer = 0
    for d in distance:
        if d == largest:
            answer += 1

    return answer


print(solution(6, [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]))
