let MN = readLine()!.split(separator: " ").map { Int(String($0))! }
let M = MN[0]
let N = MN[1]
var graph = [[Int]]()

// 그래프 입력받기
for _ in 0..<N {
    graph.append(readLine()!.split(separator: " ").map { Int(String($0))! })
}

// 토마토 좌표 배열
var tomatoes = [(Int, Int)]()
for i in 0..<M {
    for j in 0..<N {
        if graph[j][i] == 1 {
            tomatoes.append((i, j))
        }
    }
}

// 모두 익을 때까지의 최소 일수 계산
var day = -1
while !tomatoes.isEmpty {
    // 인접 토마토 배열
    var adjacentTomatoes = [(Int, Int)]()
    
    // 인접 토마토 익히기
    for tomato in tomatoes {
        // 상
        if tomato.1 - 1 >= 0 && graph[tomato.1 - 1][tomato.0] == 0 {
            graph[tomato.1 - 1][tomato.0] = 1
            adjacentTomatoes.append((tomato.0, tomato.1 - 1))
        }
        
        // 하
        if tomato.1 + 1 <= N - 1 && graph[tomato.1 + 1][tomato.0] == 0 {
            graph[tomato.1 + 1][tomato.0] = 1
            adjacentTomatoes.append((tomato.0, tomato.1 + 1))
        }
        
        // 좌
        if tomato.0 - 1 >= 0 && graph[tomato.1][tomato.0 - 1] == 0 {
            graph[tomato.1][tomato.0 - 1] = 1
            adjacentTomatoes.append((tomato.0 - 1, tomato.1))
        }
        
        // 우
        if tomato.0 + 1 <= M - 1 && graph[tomato.1][tomato.0 + 1] == 0 {
            graph[tomato.1][tomato.0 + 1] = 1
            adjacentTomatoes.append((tomato.0 + 1, tomato.1))
        }
    }
    
    tomatoes = adjacentTomatoes
    day += 1
}

// 모두 익지 못하는 상황이면 day를 -1로 수정
outer: for i in 0..<M {
    for j in 0..<N {
        if graph[j][i] == 0 {
            day = -1
            break outer
        }
    }
}

// 정답 출력
print(day)
