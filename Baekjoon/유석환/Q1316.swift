let N = Int(readLine()!)!
var words = [String]()
var groupWord = N

for _ in 1...N {
    words.append(readLine()!)
}

for word in words {
    var completedAlphabet = Set<Character>()

    for i in 1..<word.count {
        let currentAlphabet = word[word.index(word.startIndex, offsetBy: i)]
        let previousAlphabet = word[word.index(word.startIndex, offsetBy: i - 1)]

        if (currentAlphabet != previousAlphabet) {
            if (completedAlphabet.contains(currentAlphabet)) {
                groupWord -= 1
                break
            } else {
                completedAlphabet.insert(previousAlphabet)
            }
        }
    }
}

print(groupWord)
