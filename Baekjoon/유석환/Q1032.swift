let N = Int(readLine()!)!
var fileName = [[Character]]()

for _ in 1...N {
    fileName.append(Array(readLine()!))
}

for (i, v) in fileName[0].enumerated() {
    for j in 1..<N {
        if (v != fileName[j][i]) {
            fileName[0][i] = "?"
            continue
        }
    }
}

print(String(fileName[0]))
