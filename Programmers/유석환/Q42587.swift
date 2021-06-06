import Foundation

func solution(_ priorities:[Int], _ location:Int) -> Int {
    var arr = priorities
    var loc = location
    var cnt = 0
    
    while true {
        if loc == 0 {
            if arr[0] == arr.max() {
                cnt += 1
                break
            } else {
                arr.append(arr[0])
                arr.remove(at: 0)
                loc = arr.count - 1
            }
        } else {
            if arr[0] == arr.max() {
                cnt += 1
                arr.remove(at: 0)
            } else {
                arr.append(arr[0])
                arr.remove(at: 0)
            }
            loc -= 1
        }
    }
    
    return cnt
}
