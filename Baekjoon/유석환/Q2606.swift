// 컴퓨터의 수와 연결된 쌍의 수 입력받음
var nodeCnt = Int(readLine()!)!
var edgeCnt = Int(readLine()!)!

// 간선을 저장할 배열 선언
var edges = [(Int, Int)]()

// 간선 정보 입력받음
for _ in 0..<edgeCnt {
    let input = readLine()!.split(separator: " ").map { Int(String($0))! }
    
    // 작은 수가 앞으로 오도록 함
    input[0] < input[1] ? edges.append((input[0], input[1])) : edges.append((input[1], input[0]))
}

// 시작점이 작은 순으로 정렬(같으면 도착점이 작은 순으로 정렬)
edges.sort(by: {
    if $0.0 == $1.0 {
        return $0.1 < $1.1
    }
    return $0.1 < $1.1
})

// 그래프 정의
var graph = [[Int]](repeating: [], count: nodeCnt + 1)
// 간선 정보를 토대로 그래프 초기화
for edge in edges {
    graph[edge.0].append(edge.1)
    graph[edge.1].append(edge.0)
}

// queue 정의
var queue = ArraySlice([1])
// 방문한 적이 있는지 확인하기 위한 isVisited Bool 배열
var isVisited = [Bool](repeating: false, count: nodeCnt + 1)
// 감염된 컴퓨터의 수
var result = 0

// bfs loop
while !queue.isEmpty {
    // dequeue
    let node = queue.popFirst()!
    // node에 방문했으므로 true로 변경
    isVisited[node] = true
    // 감염된 컴퓨터 추가
    result += 1
    
    // 인접 노드 loop
    for i in graph[node] {
        // i 노드에 방문한 적이 없을 경우
        if !isVisited[i] {
            // enqueue
            queue.append(i)
            // i 번째 노드에 방문했으므로 true로 변경
            isVisited[i] = true
        }
    }
}

// 1번 컴퓨터는 제외이므로 1를 뺀 후 출력
print(result - 1)
