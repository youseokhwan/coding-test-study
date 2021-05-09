import Foundation

func solution(_ board: [[Int]], _ moves: [Int]) -> Int {
    let n = board.count
    var myBoard = [[Int]](repeating: [Int](), count: n)
    
    for i in stride(from: n - 1, through: 0, by: -1) {
        for j in 0..<n {
            let doll = board[i][j]
            if doll != 0 {
                myBoard[j].append(doll)
            }
        }
    }
    
    var stack = [0]
    var count = 0
    
    for crain in moves {
        if let doll = myBoard[crain - 1].popLast() {
            if stack.last! == doll {
                stack.removeLast()
                count += 1
            } else {
                stack.append(doll)
            }
        }
    }
    
    return count * 2
}
