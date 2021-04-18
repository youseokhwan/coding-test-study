let mod = 1_000_000_000
let N = Int(readLine()!)!
var dp = [[Int]](repeating: [Int](repeating: 0, count: 10), count: N + 1)
dp[1] = [0, 1, 1, 1, 1, 1, 1, 1, 1, 1]

if N == 1 {
    print(dp[1].reduce(0, +))
} else {
    for i in 2...N {
        dp[i][0] = dp[i - 1][1]
        dp[i][9] = dp[i - 1][8]
        for j in 1...8 {
            dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod
        }
    }
    print(dp[N].reduce(0, +) % mod)
}
