var fib = [(Int, Int)](repeating: (-1, -1), count: 41)
fib[0] = (1, 0)
fib[1] = (0, 1)

for i in 2...40 {
    fib[i].0 = fib[i - 1].0 + fib[i - 2].0
    fib[i].1 = fib[i - 1].1 + fib[i - 2].1
}

let T = Int(readLine()!)!
var result = ""

for _ in 0..<T {
    let N = Int(readLine()!)!
    result += "\(fib[N].0) \(fib[N].1)\n"
}

print(result)
