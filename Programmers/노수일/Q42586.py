def solution(progresses, speeds):
    answer = []
    next_seq = 0

    while next_seq < len(progresses):
        numbers = 0
        for i in range(next_seq, len(progresses)):
            progresses[i] = progresses[i] + speeds[i]

        for i in range(next_seq, len(progresses)):
            if progresses[i] >= 100:
                next_seq = i + 1
                numbers = numbers + 1
            else:
                break

        if numbers != 0:
            answer.append(numbers)

    return answer
