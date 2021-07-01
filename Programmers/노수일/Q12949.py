def solution(arr1, arr2):
    answer = []

    for i in range(len(arr1)):
        row_arr1 = arr1[i]
        answer_row = []
        for j in range(len(arr2[0])):
            sum_of = 0
            for t in range(len(row_arr1)):
                sum_of += row_arr1[t] * arr2[t][j]
            answer_row.append(sum_of)
        answer.append(answer_row)
    return answer


print(solution([[1, 4], [3, 2], [4, 1]], [[3, 3], [3, 3]]))
