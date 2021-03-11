import Foundation

// FileIO 출처: https://gist.github.com/JCSooHwanCho/30be4b669321e7a135b84a1e9b075f88
final class FileIO {
    private let buffer: [UInt8]
    private var index: Int = 0
    private let fhOutput: FileHandle = FileHandle.standardOutput

    init(fhInput: FileHandle = FileHandle.standardInput) {

        buffer = Array(try! fhInput.readToEnd()!) + [UInt8(0)] // 인덱스 범위 넘어가는 것 방지
    }

    @inline(__always) private func read() -> UInt8 {
        defer {
            index += 1
        }

        return buffer[index]
    }

    @inline(__always) func readInt() -> Int {
        var sum = 0
        var now = read()
        var isPositive = true

        while now == 10
                      || now == 32 {
            now = read()
        } // 공백과 줄바꿈 무시
        if now == 45 {
            isPositive.toggle(); now = read()
        } // 음수 처리
        while now >= 48, now <= 57 {
            sum = sum * 10 + Int(now - 48)
            now = read()
        }

        return sum * (isPositive ? 1 : -1)
    }

    @inline(__always) func readByteSequenceWithoutSpaceAndLineFeed() -> [UInt8] {
        var now = read()

        while now == 10 || now == 32 {
            now = read()
        } // 공백과 줄바꿈 무시

        let beginIndex = index - 1

        while now != 10,
              now != 32,
              now != 0 {
            now = read()
        }

        return Array(buffer[beginIndex..<(index - 1)])
    }

    @inline(__always) func print(_ s: String) {
        fhOutput.write(s.data(using: .utf8)!)
    }
}

let fIO = FileIO()
let N = fIO.readInt()
var num = [Int](repeating: 0, count: 10001)

for _ in 0..<N {
    num[fIO.readInt()] += 1
}

var result = ""
for i in 1...10000 {
    for _ in 0..<num[i] {
        result += "\(i)\n"
    }
}

fIO.print(result)
