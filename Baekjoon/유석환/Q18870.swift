// 시간초과

_ = readLine()!
let xArr = readLine()!.split(separator: " ").map { Int(String($0))! }
let resultArr = Array(Set(xArr)).sorted(by: <)

var result = ""
for item in xArr {
    result += "\(resultArr.firstIndex(of: item)!) "
}
print(result)
