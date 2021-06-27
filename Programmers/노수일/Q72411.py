from itertools import combinations


def solution(orders, course):
    answer = []
    for num in course:
        result_list = {}
        for order in orders:
            alphabet_list = list(order)
            alphabet_list.sort()
            alphabet_combinations = combinations(alphabet_list, num)
            for element in alphabet_combinations:
                combined = ''.join(element)
                if combined in result_list:
                    result_list[combined] += 1
                else:
                    result_list[combined] = 1

        if result_list:
            max_frequency = max(list(result_list.values()))

            if max_frequency != 1:
                for key in result_list.keys():
                    if result_list[key] == max_frequency:
                        answer.append(key)

    answer.sort()
    return answer
