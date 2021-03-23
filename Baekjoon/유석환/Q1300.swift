func getCnt(_ num: Int) -> Int {
    var cnt = 0
    for i in 1...N {
        cnt += min(num / i, N)
    }
    return cnt
}

let N = Int(readLine()!)!
let K = Int(readLine()!)!

var start = 1
var end = min(N * N, 1_000_000_000)
var result = 0

while start <= end {
    let mid = (start + end) / 2
    let cnt = getCnt(mid)
    
    if cnt >= K {
        result = mid
        end = mid - 1
    } else {
        start = mid + 1
    }
}

print(result)
