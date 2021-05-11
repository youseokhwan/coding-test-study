import Foundation

func solution(_ nums:[Int]) -> Int {
    let cnt = nums.count
    var answer = 0

    // 에라토스테네스의 체를 통해 소수 여부를 미리 계산
    var primeNumber = [false, false] + [Bool](repeating: true, count: 3000 - 2)
    for i in 2..<3000 {
        if i * i >= 3000 {
            break
        }
        
        if primeNumber[i] {
            for j in stride(from: i * i, to: 3000, by: i) {
                primeNumber[j] = false
            }
        }
    }
    
    // 조합을 통해 3개를 뽑고 소수인지 판별
    for i in 0..<cnt {
        for j in (i + 1)..<cnt {
            for k in (j + 1)..<cnt {
                if primeNumber[nums[i] + nums[j] + nums[k]] {
                    answer += 1
                }
            }
        }
    }
    
    return answer
}
