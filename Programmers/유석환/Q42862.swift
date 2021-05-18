import Foundation

func solution(_ n:Int, _ lost:[Int], _ reserve:[Int]) -> Int {
    var students = [-1] + [Int](repeating: 1, count: n) + [-1]
    var result = 0
    
    for item in lost {
        students[item] -= 1
    }
    
    for item in reserve {
        students[item] += 1
    }
    
    for i in 1...n {
        if students[i] == 0 {
            if (students[i - 1] == 2 && students[i + 1] < 2) {
                students[i - 1] -= 1
                students[i] += 1
                continue
            }
            
            if (students[i - 1] < 2 && students[i + 1] == 2) {
                students[i + 1] -= 1
                students[i] += 1
            }
        }
    }
    
    for i in 1...n {
        if students[i] == 0 {
            if students[i - 1] == 2 {
                students[i - 1] -= 1
                students[i] += 1
                continue
            }
            
            if students[i + 1] == 2 {
                students[i + 1] -= 1
                students[i] += 1
            }
        }
    }
    
    for item in students {
        if item >= 1 {
            result += 1
        }
    }
    
    return result
}
