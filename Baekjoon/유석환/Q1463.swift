let N = Int(readLine()!)!
var dp = [0, 0, 1, 1] + [Int](repeating: Int.max, count: max(3, N + 1 - 4))

if N < 4 {
    print(dp[N])
} else {
    for i in 4...N {
        if i % 3 == 0 {
            dp[i] = min(dp[i], dp[i / 3])
        }
        
        if i % 2 == 0 {
            dp[i] = min(dp[i], dp[i / 2])
        }
        
        dp[i] = min(dp[i], dp[i - 1]) + 1
    }

    print(dp[N])
}
