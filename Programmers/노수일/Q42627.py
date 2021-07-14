import heapq


def solution(jobs):
    jobs.sort()
    heap = []
    job_time = jobs[0][0]
    accumulate_time = 0
    start = 0
    while start < len(jobs):
        for i in range(len(jobs)):
            if not jobs[i]:
                continue
            if jobs[i][0] <= job_time:
                heapq.heappush(heap, (jobs[i][1], jobs[i][0]))
                jobs[i] = False
        if heap:
            job = heapq.heappop(heap)
            job_time += job[0]
            accumulate_time += job_time - job[1]
            start += 1
        else:
            job_time += 1

    return accumulate_time // len(jobs)


print(solution([[0, 3], [2, 6], [1, 9]]))
print(solution([[24, 10], [28, 39], [43, 20], [37, 5], [47, 22], [20, 47], [15, 34], [15, 2], [35, 43], [26, 1]]))
