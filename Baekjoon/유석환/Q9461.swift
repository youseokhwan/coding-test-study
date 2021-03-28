var length = [0, 1, 1, 1, 2, 2] + [Int](repeating: -1, count: 95)
for i in 6...100 {
    length[i] = length[i - 1] + length[i - 5]
}

var result = ""
for _ in 0..<Int(readLine()!)! {
    result += "\(length[Int(readLine()!)!])\n"
}

print(result)
