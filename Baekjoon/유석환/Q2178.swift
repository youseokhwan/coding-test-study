let input = readLine()!.split(separator: " ").map { Int(String($0))! }
let N = input[0] // 미로의 세로 길이
let M = input[1] // 미로의 가로 길이

var graph = [[Int]]()
for _ in 0..<N {
    graph.append(readLine()!.map { Int(String($0))! })
}

var queue = ArraySlice([(0, 0)])
let dx = [1, -1, 0, 0]
let dy = [0, 0, 1, -1]

while !queue.isEmpty { // BFS
    let node = queue.popFirst()!
    
    for i in 0..<4 {
        let nextNode = (node.0 + dx[i], node.1 + dy[i])
        
        // index out of range 방지
        if nextNode.0 < 0 || nextNode.0 >= M || nextNode.1 < 0 || nextNode.1 >= N {
            continue
        }
        
        // 첫 방문일 경우
        if graph[nextNode.1][nextNode.0] == 1 {
            graph[nextNode.1][nextNode.0] = graph[node.1][node.0] + 1 // node값 + 1
            queue.append((nextNode.0, nextNode.1))
        }
    }
}

print(graph[N - 1][M - 1])
