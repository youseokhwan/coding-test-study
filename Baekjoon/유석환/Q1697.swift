let NK = readLine()!.split(separator: " ").map { Int(String($0))! }
let N = NK[0]
let K = NK[1]

var depth = 0
var isVisited = [Bool](repeating: false, count: 100_000 + 1)
isVisited[N] = true

var queue = [N]
while !isVisited[K] {
    var q = [Int]()
    
    while !queue.isEmpty {
        let idx = queue.removeFirst()
        
        if 1...100_000 ~= idx && !isVisited[idx - 1] {
            isVisited[idx - 1] = true
            q.append(idx - 1)
        }
        
        if 0..<100_000 ~= idx && !isVisited[idx + 1] {
            isVisited[idx + 1] = true
            q.append(idx + 1)
        }
        
        if idx * 2 <= 100_000 && !isVisited[idx * 2] {
            isVisited[idx * 2] = true
            q.append(idx * 2)
        }
    }
    
    queue = q
    depth += 1
}

print(depth)
