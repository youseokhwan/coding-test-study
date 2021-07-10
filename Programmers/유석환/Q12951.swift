import Foundation

func solution(_ s:String) -> String {
    var words = s.components(separatedBy: " ").map { $0.lowercased() }
    
    for i in 0..<words.count {
        guard !words[i].isEmpty else {
            continue
        }
        
        var arr = Array(words[i])
        arr[0] = Character(arr[0].uppercased())
        words[i] = String(arr)
    }
    
    var result = words.reduce("", { $0 + String($1) + " " })
    result.removeLast()
    
    return result
}
