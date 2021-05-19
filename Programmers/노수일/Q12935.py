def solution(arr):
    min_num = min(arr)

    answer = [num for num in arr if num != min_num]

    if not answer:
        return [-1]
    return answer
