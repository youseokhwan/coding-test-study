import Foundation

func solution(_ lottos:[Int], _ win_nums:[Int]) -> [Int] {
    var zeroCnt = 0
    var result = 0
    
    for item in lottos {
        if item == 0 {
            zeroCnt += 1
        } else {
            if win_nums.contains(item) {
                result += 1
            }
        }
    }
    
    let best = min(7 - (result + zeroCnt), 6)
    let worst = min(7 - result, 6)
    
    return [best, worst]
}
