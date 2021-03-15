import Foundation

let maxAbs = 4000
let N = Int(readLine()!)!
var arr = [Int](repeating: 0, count: N)
var sortedArr = arr

var sum = 0
var cntArr = [Int](repeating: 0, count: maxAbs * 2 + 1)
for i in arr.indices {
    arr[i] = Int(readLine()!)!
    sum += arr[i]
    cntArr[arr[i] + maxAbs] += 1
}

var modeArr = [0] // 최빈값 배열
var modeArrCnt = 1 // 최빈값 배열의 크기
var modeFreq = cntArr[0] // 최빈값의 빈도수

// CountingSort 로직 중에 최빈값 계산
for i in 1..<maxAbs * 2 + 1 {
    // 최빈값 정보 갱신
    if cntArr[i] > modeFreq {
        modeArr = [i]
        modeArrCnt = 1
        modeFreq = cntArr[i]
    } else if cntArr[i] == modeFreq {
        modeArr.append(i)
        modeArrCnt += 1
    }

    // CountingSort
    cntArr[i] += cntArr[i - 1]
}

// CountingSort
for item in arr {
    cntArr[item + maxAbs] -= 1
    sortedArr[cntArr[item + maxAbs]] = item + maxAbs
}

let arithmeticMean = Int(round(Float(sum) / Float(N))) // 산술평균
let median = sortedArr[N / 2] - maxAbs // 중앙값
let mode = (modeArrCnt == 1 ? modeArr[0] : modeArr[1]) - maxAbs // 최빈값
let range = sortedArr.last! - sortedArr.first! // 범위

let result = "\(arithmeticMean)\n" +
    "\(median)\n" +
    "\(mode)\n" +
    "\(range)"
print(result)
