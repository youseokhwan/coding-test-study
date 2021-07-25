import heapq


def solution(arguments):
    max_heap = []
    min_heap = []
    for arg in arguments:
        if arg == "D 1":
            if max_heap:
                heapq.heappop(max_heap)
                if max_heap == [] or -max_heap[0] < min_heap[0]:
                    min_heap = []
                    max_heap = []
        elif arg == "D -1":
            if min_heap:
                heapq.heappop(min_heap)
                if min_heap == [] or -max_heap[0] < min_heap[0]:
                    max_heap = []
                    min_heap = []
        else:
            num = int(arg[2:])
            heapq.heappush(max_heap, -num)
            heapq.heappush(min_heap, num)
    if not min_heap:
        return [0, 0]
    return [-heapq.heappop(max_heap), heapq.heappop(min_heap)]
