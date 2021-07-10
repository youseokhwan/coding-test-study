import Foundation

func solution(_ record:[String]) -> [String] {
    var user = [String: String]() // id, nickname
    var log = [(String, Int)]() // id, cmd
    var result = [String]()
    
    for item in record {
        let arr = item.components(separatedBy: " ") // [cmd, id, nickname]
        
        // nickname 갱신
        if arr[0] != "Leave" {
            user[arr[1]] = arr[2]
        }
        
        if arr[0] == "Enter" {
            log.append((arr[1], 0))
        } else if arr[0] == "Leave" {
            log.append((arr[1], 1))
        }
    }
    
    for item in log {
        if item.1 == 0 { // Enter
            result.append("\(user[item.0]!)님이 들어왔습니다.")
        } else { // Leave
            result.append("\(user[item.0]!)님이 나갔습니다.")
        }
    }
    
    return result
}
