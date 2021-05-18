import Foundation

func solution(_ numbers:[Int], _ hand:String) -> String {
    let location = [(3, 1), (0, 0), (0, 1), (0, 2), (1, 0),
                    (1, 1), (1, 2), (2, 0), (2, 1), (2, 2)]
    var left = (3, 0)
    var right = (3, 2)
    var result = ""
    
    for number in numbers {
        switch number {
        case 1, 4, 7:
            left = location[number]
            result += "L"
        case 3, 6, 9:
            right = location[number]
            result += "R"
        default:
            let l = abs(left.0 - location[number].0) + abs(left.1 - location[number].1)
            let r = abs(right.0 - location[number].0) + abs(right.1 - location[number].1)
            
            if l == r {
                if hand == "left" {
                    left = location[number]
                    result += "L"
                } else {
                    right = location[number]
                    result += "R"
                }
            } else if l < r {
                left = location[number]
                result += "L"
            } else {
                right = location[number]
                result += "R"
            }
        }
    }
    
    return result
}
