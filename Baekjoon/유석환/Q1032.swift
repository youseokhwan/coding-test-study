var N = Int(readLine()!)!
var fileName = [String]()

for _ in 1...N {
    fileName.append(readLine()!)
}

for (i, v) in fileName[0].enumerated() {
    for j in 1..<N {
        if (v != fileName[j][fileName[j].index(fileName[j].startIndex, offsetBy: i)]) {
            fileName[0].replaceSubrange(fileName[0].index(fileName[0].startIndex, offsetBy: i)...fileName[0].index(fileName[0].startIndex, offsetBy: i), with: "?")
            continue
        }
    }
}

print(fileName[0])
