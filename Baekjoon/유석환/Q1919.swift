var first = Array(readLine()!)
var second = Array(readLine()!)
var alphabetCount = Array(repeating: 0, count: 26)

for character in first {
    alphabetCount[Int(character.asciiValue!) - 97] += 1
}

for character in second {
    alphabetCount[Int(character.asciiValue!) - 97] -= 1
}

print(alphabetCount.reduce(0, { x, y in
    abs(x) + abs(y)
}))
