import Foundation

func solution(_ citations:[Int]) -> Int {
    let arr = citations.sorted(by: >)
    var hIndex = 0
    
    for i in stride(from: arr.max()!, to: 0, by: -1) {
        guard i <= arr.count else {
            continue
        }
        
        if arr[i - 1] >= i {
            if i == arr.count {
                hIndex = i
                break
            } else if i < arr.count && arr[i...].max()! <= i {
                hIndex = i
                break
            }
        }
    }
    
    return hIndex
}
