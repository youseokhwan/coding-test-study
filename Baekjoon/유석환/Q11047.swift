var input = readLine()!.split(separator: " ").map { Int($0)! }
var coins = [Int]()
var count = 0

for _ in 1...input[0] {
    coins.append(Int(readLine()!)!)
}

for coin in coins.reversed() {
    count += input[1] / coin
    input[1] %= coin
    
    if input[1] == 0 {
        break
    }
}

print(count)
