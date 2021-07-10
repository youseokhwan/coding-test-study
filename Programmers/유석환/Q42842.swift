import Foundation

func solution(_ brown:Int, _ yellow:Int) -> [Int] {
    let sum = brown + yellow
    var result = [Int]()
    
    for i in 3...sum {
        if sum % i == 0 {
            let j = sum / i
            if (i - 2) * (j - 2) == yellow {
                result = [i, j]
            }
        }
    }
    
    return result
}
