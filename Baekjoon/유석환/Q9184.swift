struct Numbers: Hashable {
    let a: Int
    let b: Int
    let c: Int
}

func w(_ a: Int, _ b: Int, _ c: Int) -> Int {
    if a <= 0 || b <= 0 || c <= 0 {
        return 1
    }
    
    if a > 20 || b > 20 || c > 20 {
        return w(20, 20, 20)
    }
    
    if wDic[Numbers(a: a, b: b, c: c)] != nil {
        return wDic[Numbers(a: a, b: b, c: c)]!
    }
    
    if a < b && b < c {
        wDic[Numbers(a: a, b: b, c: c)] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c)
        return wDic[Numbers(a: a, b: b, c: c)]!
    }
    
    wDic[Numbers(a: a, b: b, c: c)] = w(a - 1, b, c) + w(a - 1, b - 1, c) +
        w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1)
    return wDic[Numbers(a: a, b: b, c: c)]!
}

var wDic = [Numbers: Int]()
var result = ""

while true {
    let input = readLine()!.split(separator: " ").map { Int(String($0))! }
    let a = input[0]
    let b = input[1]
    let c = input[2]
    
    if a == -1 && b == -1 && c == -1 {
        break
    }
    
    result += "w(\(a), \(b), \(c)) = \(w(a, b, c))\n"
}

print(result)
