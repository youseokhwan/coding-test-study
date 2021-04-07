let cnt = 1_000_000
var prime = [false, false] + [Bool](repeating: true, count: cnt + 1 - 2)

for i in stride(from: 2, through: cnt, by: 1) {
    if i * i > cnt {
        break
    }
    
    if prime[i] {
        for j in stride(from: i * i, through: cnt, by: i) {
            prime[j] = false
        }
    }
}

let MN = readLine()!.split(separator: " ").map { Int(String($0))! }
let M = MN[0]
let N = MN[1]

var result = ""
for i in M...N {
    if prime[i] {
        result += "\(i)\n"
    }
}
print(result)
