def solution(lottos, win_nums):
    def lotto_rank(number_of_correct):
        if number_of_correct >= 2:
            return 7 - number_of_correct
        else:
            return 6

    num_of_zero = 0
    corrected = 0

    for num in lottos:
        if num == 0:
            num_of_zero += 1
        elif num in win_nums:
            corrected += 1

    answer = [lotto_rank(corrected + num_of_zero), lotto_rank(corrected)]
    return answer


print(solution([44, 1, 0, 0, 31, 25], [31, 10, 45, 1, 6, 19]))
print(solution([0, 0, 0, 0, 0, 0], [38, 19, 20, 40, 15, 25]))
print(solution([45, 4, 35, 20, 3, 9], [20, 9, 3, 45, 4, 35]))
