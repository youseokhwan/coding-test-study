import Foundation

func solution(_ new_id:String) -> String {
    // 1단계 소문자로 치환
    var id = new_id.lowercased()

    // 2단계 - 소문자, 숫자, -, _, .가 아닌 문자 제거
    for item in id {
        if !(item.isLowercase || item.isNumber || item == "-" || item == "_" || item == ".") {
            id.remove(at: id.firstIndex(of: item)!)
        }
    }

    // 3단계 - 연속된 . 제거
    var arr = Array(id)
    var i = 0
    var flag = false
    while i < arr.count {
        if arr[i] == "." {
            if flag {
                arr.remove(at: i)
                i -= 1
            } else {
                flag = true
            }
        } else {
            flag = false
        }
        i += 1
    }
    id = String(arr)

    // 4단계 - 처음이나 끝에 위치한 . 제거
    if id.first == "." {
        id.removeFirst()
    }
    if id.last == "." {
        id.removeLast()
    }

    // 5단계 - 빈 문자열이라면 a로 대체
    if id.isEmpty {
        id = "a"
    }

    // 6단계 - 16자 미만으로 제거 및 마지막 문자가 .일 경우 제거
    if id.count >= 16 {
        var newId = id[id.startIndex...id.index(id.startIndex, offsetBy: 14)]
        if newId.last! == "." {
            newId.removeLast()
        }
        return String(newId)
    }

    // 7단계 - 최소 3자가 되도록 마지막 글자 반복
    if id.count == 1 {
        id.append("\(id.last!)\(id.last!)")
    } else if id.count == 2 {
        id.append(id.last!)
    }

    return id
}
