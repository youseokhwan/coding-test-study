from itertools import permutations


def solution(numbers):
    number_list = [int(num) for num in numbers]
    number_list.sort(reverse=True)
    max_number = int(''.join([str(num) for num in number_list]))

    prime_list = [True for _ in range(max_number + 1)]
    prime_list[0], prime_list[1] = False, False

    for i in range(2, max_number + 1):
        if prime_list[i] is True:
            for j in range(i * i, max_number + 1, i):
                prime_list[j] = False

    answer = 0
    permute_list = []
    for i in range(1, len(number_list) + 1):
        temp_permute = permutations(number_list, i)
        for temp_number in temp_permute:
            permute_list.append(int("".join([str(s) for s in temp_number])))

    permute_list = list(set(permute_list))

    for num in permute_list:
        if prime_list[num] is True:
            answer += 1

    return answer
