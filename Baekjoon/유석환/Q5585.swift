let coins = [500, 100, 50, 10, 5, 1]
var money = 1000 - Int(readLine()!)!
var count = 0

for coin in coins {
    while money >= coin {
        money -= coin
        count += 1
    }
}

print(count)
