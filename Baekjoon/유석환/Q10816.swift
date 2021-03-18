// 1. Dictionary를 이용한 풀이(정답, 808ms)
let N = Int(readLine()!)!
let nArr = readLine()!.split(separator: " ").map { Int(String($0))! }
let M = Int(readLine()!)!
let mArr = readLine()!.split(separator: " ").map { Int(String($0))! }

var nDic = [Int: Int]()
for item in nArr {
    if nDic[item] != nil {
        nDic[item]! += 1
    } else {
        nDic[item] = 1
    }
}

var result = ""
for item in mArr {
    if nDic[item] != nil {
        result += "\(nDic[item]!) "
    } else {
        result += "0 "
    }
}

print(result)

// 2. BinarySearch를 이용한 풀이 1 (시간초과)
// 값이 여러 개일 수 있으므로 BinarySearch를 통해 값을 찾더라도 그 앞과 뒤도 재귀적으로 호출한다.

/*
func binarySearch(_ num: Int, _ startIdx: Int, _ endIdx: Int) -> Int {
    guard startIdx <= endIdx else {
        return 0
    }
    
    var count = 0
    let midIdx = (startIdx + endIdx) / 2
    
    if num == nArr[midIdx] {
        count = binarySearch(num, startIdx, midIdx - 1) + 1 + binarySearch(num, midIdx + 1, endIdx)
    } else if num > nArr[midIdx] {
        count = binarySearch(num, midIdx + 1, endIdx)
    } else {
        count = binarySearch(num, startIdx, midIdx - 1)
    }
    
    return count
}

let N = Int(readLine()!)!
var nArr = readLine()!.split(separator: " ").map { Int(String($0))! }
let M = Int(readLine()!)!
let mArr = readLine()!.split(separator: " ").map { Int(String($0))! }

nArr.sort()

var result = ""
for num in mArr {
    result += "\(binarySearch(num, 0, N - 1)) "
}

print(result)
*/

// 3. BinarySearch를 이용한 풀이 2 (시간초과)
// 값을 찾으면 그 인덱스를 기준으로 앞뒤 인덱스를 순차적으로 탐색하여 중복값이 몇개나 있는지 체크한다.

/*
let N = Int(readLine()!)!
var nArr = readLine()!.split(separator: " ").map { Int(String($0))! }
let M = Int(readLine()!)!
let mArr = readLine()!.split(separator: " ").map { Int(String($0))! }

nArr.sort()

var result = ""
for num in mArr {
    var idx = -1
    var startIdx = 0
    var endIdx = N - 1
    var count = 0
    
    while startIdx <= endIdx {
        let midIdx = (startIdx + endIdx) / 2
        
        if num == nArr[midIdx] {
            idx = midIdx
            count += 1
            break
        } else if num > nArr[midIdx] {
            startIdx = midIdx + 1
        } else {
            endIdx = midIdx - 1
        }
    }
    
    if idx != -1 {
        var leftIdx = idx - 1
        var rightIdx = idx + 1
        
        while leftIdx >= 0 {
            if nArr[leftIdx] == num {
                count += 1
                leftIdx -= 1
            } else {
                break
            }
        }
        
        while rightIdx < N {
            if nArr[rightIdx] == num {
                count += 1
                rightIdx += 1
            } else {
                break
            }
        }
    }
    
    result += "\(count) "
}

print(result)
*/
