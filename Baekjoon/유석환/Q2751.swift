var num = [Int]()

for _ in 0..<Int(readLine()!)! {
    num.append(Int(readLine()!)!)
}

num.sort()

var result = ""
for n in num {
    result += "\(n)\n"
}

print(result)
