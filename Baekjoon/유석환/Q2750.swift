var num = [Int]()

for _ in 0..<Int(readLine()!)! {
    num.append(Int(readLine()!)!)
}

num.sort()

for n in num {
    print(n)
}
