let N = Int(readLine()!)!
var words = [[Character]]()
var groupWord = N

for _ in 1...N {
    words.append(Array(readLine()!))
}

for word in words {
    var completedAlphabet = Set<Character>()

    for i in 1..<word.count {
        if word[i] != word[i - 1] {
            if completedAlphabet.contains(word[i]) {
                groupWord -= 1
                break
            }
            completedAlphabet.insert(word[i - 1])
        }
    }
}

print(groupWord)
