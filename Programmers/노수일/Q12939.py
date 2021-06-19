def solution(s):
    numbers = [int(number) for number in s.split(' ')]
    numbers.sort()
    answer = f'{numbers[0]} {numbers[-1]}'
    return answer
