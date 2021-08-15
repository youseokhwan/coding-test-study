def solution(n, times):
    times.sort()
    max_number = n * times[-1]
    min_number = n * times[0] // len(times)

    while min_number < max_number:
        mid = (min_number + max_number) // 2
        target = 0
        for time in times:
            target += mid // time

        if target >= n:
            max_number = mid
        else:
            min_number = mid + 1

    return max_number
