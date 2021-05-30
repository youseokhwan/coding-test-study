import Foundation

func solution(_ clothes:[[String]]) -> Int {
    var c = [String: Int]()
    
    for item in clothes {
        if c[item[1]] != nil {
            c[item[1]]! += 1
        } else {
            c[item[1]] = 2 // 착용하지 않는 경우 미리 포함
        }
    }
    
    var total = 1
    for item in c {
        total *= item.value
    }
    
    return total - 1
}
