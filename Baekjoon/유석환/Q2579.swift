let n = Int(readLine()!)!
var arr = [Int]()

for _ in 0..<n {
    arr.append(Int(readLine()!)!)
}

if n == 1 {
    print(arr[0])
} else if n == 2 {
    print(arr[0] + arr[1])
} else {
    var dp1 = [arr[0], arr[0] + arr[1]] + [Int](repeating: 0, count: n - 2)
    var dp2 = [arr[0], arr[1]] + [Int](repeating: 0, count: n - 2)
    
    for i in 2..<n {
        dp1[i] = dp2[i - 1] + arr[i]
        dp2[i] = max(dp1[i - 2], dp2[i - 2]) + arr[i]
    }
    
    print(max(dp1[n - 1], dp2[n - 1]))
}
