let N = Int(readLine()!)!

switch N {
case 1:
    print(1)
case 2:
    print(2)
default:
    var binarySequenceCnt = [Int](repeating: 0, count: N + 1)
    
    binarySequenceCnt[1] = 1
    binarySequenceCnt[2] = 2
    for i in 3...N {
        binarySequenceCnt[i] = (binarySequenceCnt[i - 1] + binarySequenceCnt[i - 2]) % 15746
    }

    print(binarySequenceCnt.last!)
}
