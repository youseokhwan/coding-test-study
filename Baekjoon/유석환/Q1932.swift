let n = Int(readLine()!)!
var triangle = [[Int]]()

triangle.append([Int(readLine()!)!])
for i in 1..<n {
    var input = readLine()!.split(separator: " ").map { Int(String($0))! }
    
    input[0] += triangle[i - 1][0]
    for j in 1..<i {
        input[j] += max(triangle[i - 1][j - 1], triangle[i - 1][j])
    }
    input[i] += triangle[i - 1][i - 1]
    
    triangle.append(input)
}

print(triangle[n - 1].max()!)
