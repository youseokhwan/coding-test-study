import Foundation

func solution(_ progresses:[Int], _ speeds:[Int]) -> [Int] {
    var p = progresses
    var s = speeds
    var result = [Int]()
    
    while !p.isEmpty {
        for i in 0..<p.count {
            p[i] += s[i]
        }
        
        print(p)
        
        if p.first! >= 100 {
            var count = 1
            p.removeFirst()
            s.removeFirst()
            
            while !p.isEmpty && p.first! >= 100 {
                count += 1
                p.removeFirst()
                s.removeFirst()
            }
            
            result.append(count)
        }
    }
    
    return result
}
