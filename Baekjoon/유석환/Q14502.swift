let NM = readLine()!.split(separator: " ").map { Int(String($0))! }
let N = NM[0]
let M = NM[1]
var srcGraph = [[Int]]()

// 그래프 입력받기
for _ in 0..<N {
    srcGraph.append(readLine()!.split(separator: " ").map { Int(String($0))! })
}

// 바이러스 노드 및 빈 칸 노드 배열
var srcVirus = [(Int, Int)]()
var empty = [(Int, Int)]()

// 그래프 순회하면서 바이러스 및 빈 칸 배열 초기화
for i in 0..<N {
    for j in 0..<M {
        if srcGraph[i][j] == 0 {
            empty.append((j, i))
        } else if srcGraph[i][j] == 2 {
            srcVirus.append((j, i))
        }
    }
}

// 안전한 노드의 수
var safeCnt = 0

// 벽 3개 선정하여 각각 safeNodeCnt 계산
for i in 0..<empty.count - 2 {
    for j in i + 1..<empty.count - 1 {
        for k in j + 1..<empty.count {
            // 벽 3개 세우기
            var graph = srcGraph
            graph[empty[i].1][empty[i].0] = 1
            graph[empty[j].1][empty[j].0] = 1
            graph[empty[k].1][empty[k].0] = 1
            
            // 바이러스 배열
            var virus = srcVirus
            
            // 바이러스 확산
            while !virus.isEmpty {
                var adjacentVirus = [(Int, Int)]()
                
                for v in virus {
                    if v.1 - 1 >= 0 && graph[v.1 - 1][v.0] == 0 {
                        graph[v.1 - 1][v.0] = 2
                        adjacentVirus.append((v.0, v.1 - 1))
                    }
                    
                    if v.1 + 1 <= N - 1 && graph[v.1 + 1][v.0] == 0 {
                        graph[v.1 + 1][v.0] = 2
                        adjacentVirus.append((v.0, v.1 + 1))
                    }
                    
                    if v.0 - 1 >= 0 && graph[v.1][v.0 - 1] == 0 {
                        graph[v.1][v.0 - 1] = 2
                        adjacentVirus.append((v.0 - 1, v.1))
                    }
                    
                    if v.0 + 1 <= M - 1 && graph[v.1][v.0 + 1] == 0 {
                        graph[v.1][v.0 + 1] = 2
                        adjacentVirus.append((v.0 + 1, v.1))
                    }
                }
                
                virus = adjacentVirus
            }
            
            // 안전한 칸 계산
            var cnt = 0
            for n in 0..<N {
                for m in 0..<M {
                    if graph[n][m] == 0 {
                        cnt += 1
                    }
                }
            }
            safeCnt = cnt > safeCnt ? cnt : safeCnt
        }
    }
}

// 출력
print(safeCnt)
