let N = Int(readLine()!)!
var members = [[String]](repeating: [String](), count: 201)

for _ in 0..<N {
    let input = readLine()!.split(separator: " ").map { String($0) }
    members[Int(input[0])!].append(input[1])
}

var result = ""
for i in 1...200 {
    if !members[i].isEmpty {
        for member in members[i] {
            result += "\(i) \(member)\n"
        }
    }
}

print(result)
