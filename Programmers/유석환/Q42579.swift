import Foundation

func solution(_ genres:[String], _ plays:[Int]) -> [Int] {
    var songInfoByGenre = [String: [(Int, Int)]]() // [장르이름: (고유번호, 재생횟수)]
    var playCountByGenre = [String: Int]() // [장르이름: 재생횟수 총합]
    
    for i in 0..<genres.count {
        if songInfoByGenre[genres[i]] != nil {
            songInfoByGenre[genres[i]]!.append((i, plays[i]))
        } else {
            songInfoByGenre[genres[i]] = [(i, plays[i])]
        }
        
        if playCountByGenre[genres[i]] != nil {
            playCountByGenre[genres[i]]! += plays[i]
        } else {
            playCountByGenre[genres[i]] = plays[i]
        }
    }
    
    for key in songInfoByGenre.keys {
        songInfoByGenre[key]!.sort(by: { $0.1 > $1.1 })
    }
    
    let sortedArr = playCountByGenre.sorted(by: { $0.value > $1.value })
    var result = [Int]()
    
    for item in sortedArr {
        result.append(songInfoByGenre[item.key]![0].0)
        
        if songInfoByGenre[item.key]!.count > 1 {
            result.append(songInfoByGenre[item.key]![1].0)
        }
    }
    
    return result
}
