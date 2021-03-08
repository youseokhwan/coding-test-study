let T = Int(readLine()!)! // 테스트 케이스의 개수

for _ in 0..<T {
    let input = readLine()!.split(separator: " ").map { Int(String($0))! }
    let M = input[0] // 배추밭의 가로길이 M
    let N = input[1] // 배추밭의 세로길이 N
    let K = input[2] // 배추의 개수 K

    var graph = [[Int]](repeating: [Int](repeating: 0, count: M), count: N) // 그래프 생성
    for _ in 0..<K {
        let cabbage = readLine()!.split(separator: " ").map { Int(String($0))! }
        graph[cabbage[1]][cabbage[0]] = 1 // 배추의 위치 저장
    }
    
    var result = 0 // 배추흰지렁이 수
    
    func dfs(_ x: Int, _ y: Int) {
        if x < 0 || x >= M || y < 0 || y >= N { // index out of range 방지
            return
        }
        
        if graph[y][x] == 1 { // 배추가 있으면
            graph[y][x] = 0 // 방문처리
            
            dfs(x + 1, y) // 상하좌우 노드 재귀 호출
            dfs(x - 1, y)
            dfs(x, y + 1)
            dfs(x, y - 1)
        }
    }
    
    for y in 0..<N { // 배추밭 순회
        for x in 0..<M {
            if graph[y][x] == 1 { // 배추가 있으면
                dfs(x, y) // dfs 호출
                result += 1 // 배추흰지렁이 수 증가
            }
        }
    }
    
    print(result) // 배추흰지렁이 수 출력
}
