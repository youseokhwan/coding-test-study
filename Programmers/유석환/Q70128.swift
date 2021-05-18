import Foundation

func solution(_ a:[Int], _ b:[Int]) -> Int {
    var dotProduct = 0
    
    for i in 0..<a.count {
        dotProduct += a[i] * b[i]
    }
    
    return dotProduct
}
