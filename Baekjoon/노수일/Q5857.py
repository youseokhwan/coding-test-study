input_bracket = input()
answer = 0

left = 0
right = 0
bracket = 0

for i in range(len(input_bracket)):
    if input_bracket[i] == '(':
        left += 1
        bracket += 1
    else:
        right += 1
        bracket -= 1
    if bracket <= 1:
        left = 0
    if bracket < 0:
        answer = right
        break

if bracket > 0:
    answer = left

print(answer)
