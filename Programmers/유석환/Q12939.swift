import Foundation

func solution(_ s:String) -> String {
    let arr = s.components(separatedBy: " ").map { Int(String($0))! }
    return "\(arr.min()!) \(arr.max()!)"
}
