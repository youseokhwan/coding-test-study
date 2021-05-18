func solution(_ arr:[Int]) -> [Int] {
    var result = arr
    let minIndex = result.firstIndex(of: result.min()!)!
    
    result.remove(at: minIndex)
    
    if result.isEmpty {
        return [-1]
    } else {
        return result
    }
}
