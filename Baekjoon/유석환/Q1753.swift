// Q1753 최단경로 -> 채점 4% 시간초과
import Foundation

// 출처: https://gist.github.com/JCSooHwanCho/30be4b669321e7a135b84a1e9b075f88
final class FileIO {
    private let buffer: [UInt8]
    private var index: Int = 0

    init(fileHandle: FileHandle = FileHandle.standardInput) {
        buffer = Array(try! fileHandle.readToEnd()!) + [UInt8(0)]
    }

    @inline(__always) private func read() -> UInt8 {
        defer { index += 1 }
        return buffer[index]
    }

    @inline(__always) func readInt() -> Int {
        var sum = 0
        var now = read()
        var isPositive = true

        while now == 10 || now == 32 { now = read() }
        
        if now == 45 {
            isPositive.toggle();
            now = read()
        }
        
        while now >= 48, now <= 57 {
            sum = sum * 10 + Int(now - 48)
            now = read()
        }

        return sum * (isPositive ? 1 : -1)
    }
}

// priorityQueue push 연산
func push(_ item: (Int, Int)) {
    pq.append(item)
    cnt += 1
    
    var idx = cnt
    while idx != 1 {
        let parentIdx = idx / 2
        
        if pq[idx] < pq[parentIdx] {
            pq.swapAt(idx, parentIdx)
            idx = parentIdx
        } else {
            break
        }
    }
}

// priorityQueue pop 연산
func pop() -> (Int, Int) {
    pq.swapAt(1, cnt)
    
    let first = pq.popLast()!
    cnt -= 1
    
    var idx = 1
    while true {
        let left = idx * 2
        let right = left + 1
        
        if left > cnt {
            break
        } else if left == cnt {
            if pq[left] < pq[idx] {
                pq.swapAt(left, idx)
                idx = left
            } else {
                break
            }
        } else {
            let smaller = pq[left] < pq[right] ? left : right
            if pq[smaller] < pq[idx] {
                pq.swapAt(smaller, idx)
                idx = smaller
            } else {
                break
            }
        }
    }
    
    return first
}

let fileIO = FileIO()
let V = fileIO.readInt()
let E = fileIO.readInt()
let start = fileIO.readInt()
var graph = [[(Int, Int)]](repeating: [(Int, Int)](), count: V + 1)

// 간선 정보 입력받기
for _ in 0..<E {
    graph[fileIO.readInt()].append((fileIO.readInt(), fileIO.readInt()))
}

// 각 노드까지의 최단 거리 저장
var dist = [Int](repeating: Int.max, count: V + 1)
dist[start] = 0

// 다익스트라 알고리즘 구현
var pq = [(0, 0), (start, 0)] // 인덱스 0은 사용 안함
var cnt = 1
while cnt > 0 {
    let node = pop()
    
    // 이미 계산된 노드는 무시
    if dist[node.0] < node.1 {
        continue
    }
    
    // 인접 노드 순회
    for item in graph[node.0] {
        let cost = node.1 + item.1
        if cost < dist[item.0] {
            dist[item.0] = cost
            push((item.0, cost))
        }
    }
}

// 출력
var result = ""
for item in dist[1...] {
    if item == Int.max {
        result += "INF\n"
    } else {
        result += "\(item)\n"
    }
}
print(result)
