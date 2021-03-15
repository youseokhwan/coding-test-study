let N = Int(readLine()!)!
var points = [(Int, Int)]()

for _ in 0..<N {
    let input = readLine()!.split(separator: " ").map { Int(String($0))! }
    points.append((input[0], input[1]))
}

points.sort(by: {
    if $0.1 == $1.1 {
        return $0.0 < $1.0
    }
    return $0.1 < $1.1
})

var result = ""
for item in points {
    result += "\(item.0) \(item.1)\n"
}

print(result)
