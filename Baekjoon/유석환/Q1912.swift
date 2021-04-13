let n = Int(readLine()!)!
var seq = readLine()!.split(separator: " ").map { Int(String($0))! }

var maxSum = Int.min
var previousSum = 0

for item in seq {
    previousSum = max(0, previousSum) + item
    maxSum = max(maxSum, previousSum)
}

print(maxSum)
