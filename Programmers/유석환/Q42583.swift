import Foundation

func solution(_ bridge_length:Int, _ weight:Int, _ truck_weights:[Int]) -> Int {
    var weights = truck_weights
    var scheduler = [(Int, Int)]() // (트럭의 무게, 다리를 지났을 때 시간)
    var time = 0
    
    while !(weights.isEmpty && scheduler.isEmpty) {
        scheduler = scheduler.filter { $0.1 > time }
        
        var total = 0
        for s in scheduler {
            total += s.0
        }
        
        if !weights.isEmpty {
            if total + weights.first! <= weight {
                scheduler.append((weights.first!, time + bridge_length))
                weights.removeFirst()
            }
        }
        
        time += 1
    }
    
    return time
}
