// 보석 개수와 가방 개수 입력받고 초기화
let input = readLine()!.split(separator: " ").map { Int(String($0))! }
let jewelryCnt = input[0]
let bagCnt = input[1]

// 각 보석의 무게와 가격 입력받고 초기화
var jewels = [(weight: Int, price: Int)](repeating: (weight: 0, price: 0), count: jewelryCnt)
for i in 0..<jewelryCnt {
    let input = readLine()!.split(separator: " ").map { Int(String($0))! }
    jewels[i].weight = input[0]
    jewels[i].price = input[1]
}

// 각 가방의 최대 무게 입력받고 초기화
var bags = [Int](repeating: 0, count: bagCnt)
for i in 0..<bagCnt {
    bags[i] = Int(readLine()!)!
}

// 보석을 무게가 작은 순으로 정렬
jewels.sort(by: { $0.weight < $1.weight })

// 가방을 가벼운 순으로 정렬
bags.sort(by: { $0 < $1 })

// 최대 보석 가격의 합
var result = 0

// 보석 순회하는 인덱스
var idx = 0

// 보석의 가치를 기준으로 한 priortyQueue(Max Heap)
var pq = [Int]()
var pqCnt = 0

// 가방 loop
for i in 0..<bagCnt {
    // 가방 무게보다 낮은 보석들을 우선순위 큐에 enqueue
    while idx < jewelryCnt && jewels[idx].weight <= bags[i] {
        pq.append(jewels[idx].price)
        pqCnt += 1
        
        // Heap 조건 충족
        var pqIdx = pqCnt - 1
        var parentIdx = pqIdx % 2 == 0 ? pqIdx / 2 - 1 : pqIdx / 2
        while pqIdx != 0 && pq[pqIdx] > pq[parentIdx] {
            pq.swapAt(pqIdx, parentIdx)
            pqIdx = parentIdx
            parentIdx = pqIdx % 2 == 0 ? pqIdx / 2 - 1 : pqIdx / 2
        }
        
        idx += 1
    }
    
    // 우선순위 큐의 top 노드를 해당 가방의 보석으로 확정
    if !pq.isEmpty {
        pq.swapAt(0, pq.index(before: pq.endIndex))
        result += pq.removeLast()
        pqCnt -= 1
        
        // Heap 조건 충족
        var pqIdx = 0
        while !pq.isEmpty {
            let leftIdx = pqIdx * 2 + 1
            let rightIdx = leftIdx + 1
            
            if leftIdx >= pqCnt {
                break
            } else if rightIdx >= pqCnt {
                if pq[leftIdx] > pq[pqIdx] {
                    pq.swapAt(leftIdx, pqIdx)
                    pqIdx = leftIdx
                } else {
                    break
                }
            } else {
                let maxIdx = pq[leftIdx] > pq[rightIdx] ? leftIdx : rightIdx
                
                if pq[maxIdx] > pq[pqIdx] {
                    pq.swapAt(maxIdx, pqIdx)
                    pqIdx = maxIdx
                } else {
                    break
                }
            }
        }
    }
}

// 정답 출력
print(result)
