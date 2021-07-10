import Foundation

// 두 노드(단어)가 인접(한 글자만 다른지)해 있는지 확인
func isConnected(_ first:String, _ second:String) -> Bool {
    let first = Array(first)
    let second = Array(second)
    var count = 0
    
    for i in 0..<first.count {
        if first[i] != second[i] {
            count += 1
        }
    }
    
    return count == 1 ? true : false
}

func solution(_ begin:String, _ target:String, _ words:[String]) -> Int {
    let cnt = words.count
    var depth = [Int](repeating: 0, count: cnt)
    var queue = [begin]
    
    // words에 target이 없으면 0 return
    if !words.contains(target) {
        return 0
    }
    
    // bfs
    repeat {
        // dequeue
        let node = queue.removeFirst()
        
        // 방문하지 않은 인접한 노드 순회
        for i in 0..<cnt {
            if depth[i] == 0 && isConnected(node, words[i]) {
                queue.append(words[i])
                
                if node == begin {
                    depth[i] = 1
                } else {
                    depth[i] = depth[words.firstIndex(of: node)!] + 1
                }
            }
        }
    } while !queue.isEmpty
    
    // target의 depth를 return
    return depth[words.firstIndex(of: target)!]
}
