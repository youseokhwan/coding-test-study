def solution(answers):
    supo1 = [1, 2, 3, 4, 5]  # 5
    supo2 = [2, 1, 2, 3, 2, 4, 2, 5]  # 8
    supo3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]  # 10

    supo1_cnt, supo2_cnt, supo3_cnt = 0, 0, 0

    for i in range(len(answers)):
        if answers[i] == supo1[i % 5]:
            supo1_cnt += 1
        if answers[i] == supo2[i % 8]:
            supo2_cnt += 1
        if answers[i] == supo3[i % 10]:
            supo3_cnt += 1

    max_cnt = max(supo1_cnt, supo2_cnt, supo3_cnt)

    answer = []
    if supo1_cnt == max_cnt:
        answer.append(1)
    if supo2_cnt == max_cnt:
        answer.append(2)
    if supo3_cnt == max_cnt:
        answer.append(3)
    return answer


print(solution([1, 2, 3, 4, 5]))
print(solution([1, 3, 2, 4, 2]))
