let N = Int(readLine()!)! // 로프의 개수 N 입력받음
var lopeWeight = [Int](repeating: 0, count: N) // 각 로프의 최대 중량을 저장하기 위한 lopeWeight 배열
var maxWeight = 0 // 들어올릴 수 있는 물체의 최대 중량

for i in 0..<N { // 각 로프의 최대 중량 입력받음
    lopeWeight[i] = Int(readLine()!)!
}

lopeWeight.sort(by: >) // 그리디 연산을 하기 위해 내림차순으로 정렬. O(nlogn)

for i in 0..<N { // O(n)
    let weight = lopeWeight[i] * (i + 1)
    // 나누어 물체를 들 경우 min 값을 기준으로 로프 개수를 곱해야 최대 중량을 구할 수 있음
    // 내림차순 정렬을 통해 i번째 element가 min값이 되도록 설정하였기 때문에 lopeWeight[i]를 로프 개수와 곱함

    if weight > maxWeight {
        maxWeight = weight // 조건 검사하여 최대 중량 갱신
    }
}

print(maxWeight) // 최대 중량 출력
