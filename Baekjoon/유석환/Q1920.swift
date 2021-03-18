let N = Int(readLine()!)!
var nArr = readLine()!.split(separator: " ").map { Int(String($0))! }
let M = Int(readLine()!)!
let mArr = readLine()!.split(separator: " ").map { Int(String($0))! }

nArr.sort()

var result = ""
forLoop: for num in mArr {
    var startIdx = 0
    var endIdx = N - 1
    var midIdx = (startIdx + endIdx) / 2
    
    while startIdx <= endIdx {
        if nArr[midIdx] == num {
            result += "1\n"
            continue forLoop
        }
        
        if num > nArr[midIdx] {
            startIdx = midIdx + 1
        } else {
            endIdx = midIdx - 1
        }
        
        midIdx = (startIdx + endIdx) / 2
    }
    
    result += "0\n"
}

print(result)
