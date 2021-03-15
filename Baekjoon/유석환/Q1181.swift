let N = Int(readLine()!)!
var set = Set<String>()
var result = ""

for _ in 0..<N {
    set.insert(readLine()!)
}

var words = [String](set)
var uniqueWords = [(Int, String)]()

for item in words {
    uniqueWords.append((item.count, item))
}

uniqueWords.sort(by: <)

for item in uniqueWords {
    result += "\(item.1)\n"
}
print(result)
