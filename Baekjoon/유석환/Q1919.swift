var first = Array(readLine()!)
var second = Array(readLine()!)
var result = 0

for character in first {
    if second.contains(character) {
        second.remove(at: second.firstIndex(of: character)!)
    } else {
        result += 1
    }
}

print(result + second.count)
