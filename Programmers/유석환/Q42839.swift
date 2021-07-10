import Foundation

func getPermutation(_ arr: [Character], _ r: Int, _ res: inout [Int], _ idx: Int = 0) {
    var arr = arr
    
    if idx == r {
        let item = Int(String(Array(arr[0..<r])))!
        res.append(item)
        return
    }
    
    for i in idx..<arr.count {
        arr.swapAt(idx, i)
        getPermutation(arr, r, &res, idx + 1)
        arr.swapAt(idx, i)
    }
}

func solution(_ numbers:String) -> Int {
    let num = 10000000
    var isPrime = [Bool](repeating: true, count: num + 1)
    
    isPrime[0] = false
    isPrime[1] = false
    
    for i in 2...num {
        guard i * i <= num else {
            break
        }
        
        if isPrime[i] {
            for j in stride(from: i * i, through: num, by: i) {
                isPrime[j] = false
            }
        }
    }
    
    let charArr = Array(numbers)
    var perArr = [Int]()
    
    for i in 1...charArr.count {
        getPermutation(charArr, i, &perArr)
    }
    
    var result = 0
    for item in Set(perArr) {
        if isPrime[item] {
            result += 1
        }
    }
    
    return result
}
