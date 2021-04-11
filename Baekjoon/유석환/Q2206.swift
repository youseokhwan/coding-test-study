// 시간초과

let wall = 987654321
let dx = [0, 0, -1, 1]
let dy = [-1, 1, 0, 0]

let NM = readLine()!.split(separator: " ").map { Int(String($0))! }
let N = NM[0]
let M = NM[1]
var graph = [[Int]]()

// 그래프 입력받으면서 벽 위치 저장
var walls = [(Int, Int)]()
for i in 0..<N {
    var arr = Array(readLine()!).map { Int(String($0))! }
    for j in 0..<M {
        if arr[j] == 1 {
            arr[j] = wall
            walls.append((j, i))
        }
    }
    graph.append(arr)
}
graph[0][0] = 1

// BFS
func bfs() -> Int {
    var queue = ArraySlice([(0, 0)])
    
    while !queue.isEmpty {
        let item = queue.popFirst()!
        
        for i in 0..<4 {
            let x = item.0 + dx[i]
            let y = item.1 + dy[i]
            
            // 인덱스가 유효하고, 0인 경우(최초 진입한 경우)
            if 0..<M ~= x && 0..<N ~= y && g[y][x] == 0 {
                g[y][x] = g[item.1][item.0] + 1
                queue.append((x, y))
            }
        }
    }
    
    return g.last!.last! == 0 ? 987654321 : g.last!.last!
}

// 부술 벽 순회
var result = 987654321
var g: [[Int]]
for w in walls {
    g = graph
    g[w.1][w.0] = 0
    result = min(result, bfs())
}

print(result == 0 ? -1 : result)
