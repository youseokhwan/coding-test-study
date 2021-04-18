let n = Int(readLine()!)!
var wine = [0]
for _ in 0..<n {
    wine.append(Int(readLine()!)!)
}

var dpOO = [0, 0] + [Int](repeating: 0, count: n + 1 - 2)
var dpXO = [0, wine[1]] + [Int](repeating: 0, count: n + 1 - 2)
var dpOX = [0, wine[1]] + [Int](repeating: 0, count: n + 1 - 2)
var dpMax = [0, wine[1]] + [Int](repeating: 0, count: n + 1 - 2)

if n == 1 {
    print(dpMax[1])
} else {
    for i in 2...n {
        dpOO[i] = dpMax[i - 1]
        dpXO[i] = dpOX[i - 1] + wine[i]
        dpOX[i] = dpMax[i - 2] + wine[i]
        dpMax[i] = max(dpOO[i], dpXO[i], dpOX[i])
    }
    print(dpMax[n])
}
