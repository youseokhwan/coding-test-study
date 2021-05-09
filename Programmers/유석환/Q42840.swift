import Foundation

func solution(_ answers:[Int]) -> [Int] {
    let supo = [[1, 2, 3, 4, 5], [2, 1, 2, 3, 2, 4, 2, 5], [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]]
    let patternCnt = [5, 8, 10]
    var correctCnt = [0, 0, 0]
    
    for i in 0..<answers.count {
        for j in 0..<3 {
            if answers[i] == supo[j][i % patternCnt[j]] {
                correctCnt[j] += 1
            }
        }
    }
    
    let max = correctCnt.max()
    var res = [Int]()
    
    for i in 0..<3 {
        if correctCnt[i] == max {
            res.append(i + 1)
        }
    }
    
    return res
}
