func dfs(_ x: Int, _ y: Int) {
    if x < 0 || x >= N || y < 0 || y >= N { // 인덱스 검사
        return
    }
    
    if !isVisited[x][y] {
        isVisited[x][y] = true // 방문 처리
        if graph[x][y] == 1 { // 아파트가 있을 경우
            aptCnt += 1 // 아파트 수 증가 및 재귀 호출
            dfs(x + 1, y)
            dfs(x - 1, y)
            dfs(x, y + 1)
            dfs(x, y - 1)
        }
    }
}

let N = Int(readLine()!)! // 지도의 크기 N
var graph = [[Int]]() // 지도

for _ in 0..<N {
    graph.append(readLine()!.map { Int(String($0))! })
}

var result = [Int]() // 각 단지내 집의 수를 저장하는 배열
var aptCnt = 0 // 임시로 사용할 단지내 아파트 수
var isVisited = [[Bool]](repeating: [Bool](repeating: false, count: N), count: N) // 방문 여부

for i in 0..<N {
    for j in 0..<N {
        if !isVisited[i][j] {
            if graph[i][j] == 1 { // 아파트가 있는 곳이면(새로운 단지를 발견했다면)
                aptCnt = 0 // 단지내 아파트 수 0으로 초기화
                dfs(i, j) // dfs 호출
                result.append(aptCnt) // dfs에서 계산된 단지내 아파트 수를 result 배열에 추가
            } else { // 아파트가 없는 곳이면 그냥 방문 처리만
                isVisited[i][j] = true
            }
        }
    }
}

result.sort(by: <) // 오름차순 정렬
print("\(result.count)")
for count in result {
    print(count)
}
