import Foundation

func solution(_ numbers:[Int], _ target:Int) -> Int {
    var totals = [numbers.first!, -numbers.first!]
    
    for i in 1..<numbers.count {
        totals = totals.map { $0 + numbers[i] } + totals.map { $0 - numbers[i] }
    }
    
    return totals.filter { $0 == target }.count
}
