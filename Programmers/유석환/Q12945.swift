func solution(_ n:Int) -> Int {
    var dp = [Int](repeating: -1, count: max((n + 1), 2))
    dp[0] = 0
    dp[1] = 1
    
    if n > 1 {
        for i in 2...n {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567
        }
    }
    
    return dp[n]
}
