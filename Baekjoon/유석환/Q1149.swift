typealias Cost = (R: Int, G: Int, B: Int)

let N = Int(readLine()!)!
var cost = [Cost](repeating: Cost(0, 0, 0), count: 1001)

for i in 1...N {
    let rgb = readLine()!.split(separator: " ").map { Int(String($0))! }
    cost[i] = Cost(rgb[0], rgb[1], rgb[2])
}

var dpTable = [Cost](repeating: Cost(0, 0, 0), count: 1001)
for i in 1...N {
    dpTable[i].R = min(dpTable[i - 1].G, dpTable[i - 1].B) + cost[i].R
    dpTable[i].G = min(dpTable[i - 1].R, dpTable[i - 1].B) + cost[i].G
    dpTable[i].B = min(dpTable[i - 1].R, dpTable[i - 1].G) + cost[i].B
}

print(min(dpTable[N].R, dpTable[N].G, dpTable[N].B))
