import Foundation

func solution(_ arr1:[[Int]], _ arr2:[[Int]]) -> [[Int]] {
    var res = [[Int]](repeating: [Int](repeating: 0, count: arr2[0].count), count: arr1.count)
    
    for i in 0..<res.count {
        for j in 0..<res[0].count {
            var sum = 0
            
            for k in 0..<arr2.count {
                sum += arr1[i][k] * arr2[k][j]
            }
            
            res[i][j] = sum
        }
    }
    
    return res
}
