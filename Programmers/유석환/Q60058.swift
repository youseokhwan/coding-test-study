import Foundation

func revise(_ p:String) -> String {
    // 1. 빈 문자열인 경우 빈 문자열 반환
    if p.isEmpty {
        return ""
    }
    
    // 2. u, v로 분리
    var index = 1
    var value = p[p.index(p.startIndex, offsetBy: 0)] == "(" ? 1 : -1
    
    while value != 0 && index < p.count {
        if p[p.index(p.startIndex, offsetBy: index)] == "(" {
            value += 1
        } else {
            value -= 1
        }
        index += 1
    }
    
    var u = String(p[p.startIndex..<p.index(p.startIndex, offsetBy: index)])
    let v = String(p[p.index(p.startIndex, offsetBy: index)...])
    
    // 3. u가 올바른 괄호 문자열이면 v에 대해 작업 수행
    if isValid(u) {
        // 3-1. 수행한 결과를 u 뒤에 붙여 반환
        return u + revise(v)
    } else { // 4. 아니면 아래 작업 수행
        // 4-1, 4-2, 4-3 작업 수행
        var newStr = "(" + revise(v) + ")"
        
        // 4-4. u의 첫, 마지막 문자 제거 및 나머지 문자 뒤집어 붙히기
        u.removeFirst()
        u.removeLast()
        for c in u {
            if c == "(" {
                newStr += ")"
            } else {
                newStr += "("
            }
        }
        
        // 4-5. 반환
        return newStr
    }
}

// 올바른 문자열이면 true 반환하는 isValid 함수
func isValid(_ p:String) -> Bool {
    var value = 0
    
    for c in p {
        if c == "(" {
            value += 1
        } else {
            value -= 1
        }
        
        if value < 0 {
            return false
        }
    }
    
    if value == 0 {
        return true
    } else {
        return false
    }
}

func solution(_ p:String) -> String {
    return revise(p)
}
