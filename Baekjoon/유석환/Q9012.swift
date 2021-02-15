let t = Int(readLine()!)!
var psList = [String]()

for _ in 1...t {
    psList.append(readLine()!)
}

outer: for ps in psList {
    var valid = 0
    
    inner: for parenthesis in ps {
        if (parenthesis == "(") {
            valid += 1
        } else {
            valid -= 1
        }
        
        if (valid < 0) {
            print("NO")
            continue outer
        }
    }
    
    if (valid == 0) {
        print("YES")
    } else {
        print("NO")
    }
}
