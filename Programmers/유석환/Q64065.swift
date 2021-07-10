import Foundation

func solution(_ s:String) -> [Int] {
    var str = s
    var cnt = [Int](repeating: 0, count: 100000 + 1)
    
    str.removeFirst()
    str.removeFirst()
    str.removeLast()
    str.removeLast()
    
    for element in str.components(separatedBy: "},{") {
        for item in element.components(separatedBy: ",").map { Int(String($0))! } {
            cnt[item] += 1
        }
    }
    
    var result = [Int](repeating: 0, count: s.count)
    
    for i in 1..<cnt.count {
        if cnt[i] > 0 {
            result[s.count - cnt[i]] = i
        }
    }
    
    return result.filter { $0 != 0 }
}
