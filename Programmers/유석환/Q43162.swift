import Foundation

func dfs(_ arr: inout [[Int]], _ node: Int, _ isVisited: inout [Bool]) {
    isVisited[node] = true
    
    for i in 0..<arr.count {
        guard i != node else { continue }
        
        if !isVisited[i] && arr[node][i] == 1 {
            dfs(&arr, i, &isVisited)
        }
    }
}

func solution(_ n:Int, _ computers:[[Int]]) -> Int {
    var computers = computers
    var isVisited = [Bool](repeating: false, count: n)
    var res = 0
    
    for i in 0..<n {
        if !isVisited[i] {
            res += 1
            dfs(&computers, i, &isVisited)
        }
    }
    
    return res
}
