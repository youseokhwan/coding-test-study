let NK = readLine()!.split(separator: " ").map { Int(String($0))! }
let N = NK[0]
let K = NK[1]

var items = [(Int, Int)]()
for _ in 0..<N {
    let WV = readLine()!.split(separator: " ").map { Int(String($0))! }
    if WV[0] <= K {
        items.append((WV[0], WV[1]))
    }
}

var maxValue = [Int](repeating: 0, count: K + 1)
for (weight, value) in items {
    var maxValueCopy = maxValue
    for i in weight...K {
        if maxValue[i - weight] + value > maxValue[i] {
            maxValueCopy[i] = maxValue[i - weight] + value
        }
    }
    maxValue = maxValueCopy
}

print(maxValue[K])
