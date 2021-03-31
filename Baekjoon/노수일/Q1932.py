n = int(input())

triangle = []

for i in range(n):
    line_list = [0] * n
    input_lines = [int(num) for num in input().split(' ')]
    line_list[:len(input_lines)] = input_lines
    triangle.append(line_list)

"""
7 
3 8 
8 1 0 
2 7 4 4
4 5 2 6 5
"""

for i in range(1, n):
    for j in range(i + 1):
        if j == 0:
            triangle[i][j] = triangle[i][j] + triangle[i - 1][j]
        elif i == j:
            triangle[i][j] = triangle[i][j] + triangle[i - 1][j - 1]
        else:
            triangle[i][j] = triangle[i][j] + max(triangle[i - 1][j], triangle[i - 1][j - 1])

print(max(triangle[n - 1]))
