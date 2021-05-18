import Foundation

func solution(_ d:[Int], _ budget:Int) -> Int {
    let dep = d.sorted(by: <)
    var b = budget
    var cnt = 0

    for item in dep {
        guard item <= b else { break }
        b -= item
        cnt += 1
    }

    return cnt
}
