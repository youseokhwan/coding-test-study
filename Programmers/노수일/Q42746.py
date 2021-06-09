def solution(numbers):
    number_list = [(index, str(num) * 3) for (index, num) in enumerate(numbers)]
    number_list.sort(key=lambda x: x[1], reverse=True)
    answer = ''

    for element in number_list:
        answer += str(numbers[element[0]])

    return str(int(answer))