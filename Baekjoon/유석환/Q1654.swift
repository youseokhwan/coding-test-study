let input = readLine()!.split(separator: " ").map { Int(String($0))! }
let K = input[0]
let N = input[1]
var kArr = [Int]()

for _ in 0..<K {
    kArr.append(Int(readLine()!)!)
}

var start = 1
var end = kArr.max()!
var result = Int()

while start <= end {
    let mid = (start + end) / 2
    
    // 각 랜선을 mid만큼 자른 개수 배열
    let cntArr = kArr.map { $0 / mid }
    let sum = cntArr.reduce(0, +)
    
    // 총 개수가 N보다 같거나 크면 개수를 줄여서 size를 더 늘릴 수 있음
    if sum >= N {
        result = mid
        start = mid + 1
    } else { // 총 개수가 N보다 작으면 size를 줄이고 개수를 더 늘려야 함
        end = mid - 1
    }
}

print(result)
