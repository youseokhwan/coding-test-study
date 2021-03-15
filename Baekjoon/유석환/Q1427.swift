var arr = readLine()!.map { Int(String($0))! }
arr.sort(by: >)

var result = ""
for item in arr {
    result += "\(item)"
}

print(result)
