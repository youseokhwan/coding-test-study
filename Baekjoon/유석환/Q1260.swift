// dfs 함수
func dfs(_ graph: [[Int]], _ node: Int) {
    // node에 방문했으므로 true로 변경하고 dfsResult에 추가
    isVisited[node] = true
    dfsResult += String(node) + " "
    
    // 인접한 노드 loop
    for i in graph[node] {
        // i 노드에 방문한 적이 없으면 재귀 호출
        if !isVisited[i] {
            dfs(graph, i)
        }
    }
}

// bfs 함수
func bfs(_ graph: [[Int]], _ start: Int) {
    // sub은 queue의 SubSequence(popFirst()를 사용하기 위함)
    let queue = [start]
    var sub = queue[queue.startIndex...]
    
    // start에 방문했으므로 true로 변경
    isVisited[start] = true
    
    // queue가 빌 때까지 loop
    while !sub.isEmpty {
        // dequeue하고 bfsResult에 추가
        let node = sub.popFirst()!
        bfsResult += String(node) + " "
        
        // 인접한 노드 loop
        for i in graph[node] {
            // i 노드에 방문한 적이 없으면
            if !isVisited[i] {
                // i 노드를 enqueue하고 true로 변경
                sub.append(i)
                isVisited[i] = true
            }
        }
    }
}

// N, M, V값 입력받음
let input = readLine()!.split(separator: " ").map { Int(String($0))! }
let N = input[0]
let M = input[1]
let V = input[2]

// 그래프 및 간선 배열 정의
var graph = [[Int]](repeating: [], count: N + 1)
var edges = [(Int, Int)]()

// 간선 정보 입력받음
for _ in 0..<M {
    let edge = readLine()!.split(separator: " ").map { Int(String($0))! }
    
    // 낮은 숫자가 앞으로 오도록 함
    edge[0] < edge[1] ? edges.append((edge[0], edge[1])) : edges.append((edge[1], edge[0]))
}

// 간선 정렬(시작점이 낮은 순, 같으면 도착점이 낮은 순)
edges.sort(by: {
    if $0.0 == $1.0 {
        return $0.1 < $1.1
    }
    return $0.0 < $1.0
})

// 각 간선들을 그래프에 추가
for i in 0..<M {
    graph[edges[i].0].append(edges[i].1)
    graph[edges[i].1].append(edges[i].0)
}

// isVisited, dfsResult 초기화
var isVisited = [Bool](repeating: false, count: N + 1)
var dfsResult = String()

// dfs 함수 호출
dfs(graph, V)
// dfsResult 끝에 whiteSpace 제거
dfsResult.removeLast()
// dfsResult 출력
print(dfsResult)

// isVisited, bfsResult 초기화
isVisited = [Bool](repeating: false, count: N + 1)
var bfsResult = String()

// bfs 함수 호출
bfs(graph, V)
// bfsResult 끝에 whiteSpace 제거
bfsResult.removeLast()
// bfsResult 출력
print(bfsResult)
