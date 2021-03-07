const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');
const T = input.shift();
let count; 
let need = 0;

const directX = [1, -1, 0, 0]; // 좌, 우 방문을 위한 배열 선언
const directY = [0, 0, 1, -1]; // 상, 하 방문을 위한 배열 선언

for(let i = 0; i < T; i++) { // T만큼 반복한다
    count = 0; // 배추가 심어진 땅 카운트
    const [N, M, K] = input.shift().split(' ').map((el) => parseInt(el));
    
    let graph = Array.from(Array(N + 1), () => Array(M + 1).fill(0)); // N x M 배열의 인접행렬 생성
    let limitCount = 0; // graph 채우기 위한 변수
    
    while(limitCount < K) { // input에서 shift해가며 인접행렬 채우기
        const [front, back] = input.shift().split(' ');
        graph[front][back] = 1;
        limitCount += 1;
    }

    const DFS = (a, b) => { // DFS 구현
        if(a >= 0 && a < N && b >= 0 && b < M && graph[a][b] === 1) { // 지도 밖을 벗어나지 않기 위한 조건문 && 배추가 있다면
            graph[a][b] = 0; // 방문 처리
            count += 1; // 배추 개수 count
            for(let k = 0; k < 4; k++) { // 땅 상, 하, 좌, 우 차례 방문
                DFS(a + directX[k], b + directY[k]);
            }
        }
    }

    // 그래프 탐색
    for (let i = 0; i < N; i++) {
        for (let j = 0; j < N; j++) { // 인접행렬 순회
            if (graph[i][j] === 1) { // 배추가 있다면
                DFS(i, j); // DFS 호출 

                // 한 번의 순회가 끝나고 나면
                if(count > 0) { // 배추가 있는 땅이 여러개라면
                    count = 0; // 카운트 0 초기화
                    need += 1; // 지렁이 개수 +
                }
            }
        }
    }
    
    console.log(need) // 필요한 지렁이 수 출력
    need = 0;

}

