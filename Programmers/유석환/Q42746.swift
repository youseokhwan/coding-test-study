import Foundation

func solution(_ numbers:[Int]) -> String {
    var arr = numbers.map { String($0) }
    
    arr.sort(by: {
        if $0 + $1 > $1 + $0 {
            return true
        } else { return false }
    })
    
    var result = ""
    for item in arr {
        result += String(item)
    }
    
    return result.first == "0" ? "0" : result
}
