import Foundation

func solution(_ s:String) -> Int {
    let str = Array(s)
    var minCnt = 987654321
    
    if s.count == 1 {
        return 1
    }
    
    for unit in 1...s.count / 2 {
        var compressedStr = [Character]()
        var idx = 0
        
        while true {
            if idx + unit > str.count {
                compressedStr += str[idx...]
                break
            }
            
            let target = str[idx..<idx + unit]
            idx += unit
            var cnt = 1
            
            while idx + unit <= str.count {
                if target == str[idx..<idx + unit] {
                    cnt += 1
                    idx += unit
                } else {
                    break
                }
            }
            
            compressedStr += cnt != 1 ? Array("\(cnt)") + target : target
        }
        
        minCnt = compressedStr.count < minCnt ? compressedStr.count : minCnt
    }
    
    return minCnt
}
