let N = Int(readLine()!)!
var A = readLine()!.split(separator: " ").map { Int(String($0))! }
var dp = [Int](repeating: 0, count: N)
dp[0] = 1

for i in 1..<N {
    var maxDp = 0 // 자신보다 작은 값 중 최대 dp값
    for j in 0..<i {
        if A[i] > A[j] {
            maxDp = max(dp[j], maxDp)
        }
    }
    dp[i] = maxDp + 1
}

print(dp.max()!)
