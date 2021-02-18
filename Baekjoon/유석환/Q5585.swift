let coins = [500, 100, 50, 10, 5, 1]
var money = 1000 - Int(readLine()!)!
var count = 0

for coin in coins {
    count += money / coin
    money %= coin
}

print(count)
