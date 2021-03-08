const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');
console.log(input);
const [N, M] = input.shift().split(' '); // shift
const graph = Array.from(Array(N + 1), () => new Array(M + 1)); // n x n 배열 선언
const visited = Array.from(Array(N + 1), () => new Array(M + 1).fill(false)); // n x n 배열 선언
const directX = [1, -1, 0, 0]; // 좌, 우 방문을 위한 배열 선언
const directY = [0, 0, 1, -1]; // 상, 하 방문을 위한 배열 선언
let count = 0;
// 입력값을 그래프에 담아줌
for (let i = 0; i < N; i++) {
    let jCount = [];
    graph[i] = input[i].split("").map((el) => Number(el));
    // visited[i] = [false, false, false, false, false, false];
    for (let j = 0; j < M; j++) {
        jCount.push(false);
    }
    visited[i] = jCount;
}


const DFS = (i, j, weight) => { // DFS 구현
    if(i >= 0 && i < N && j >= 0 && j < M && visited[i][j] === false) { // 지도 밖을 벗어나지 않기 위한 조건문 && 집이 있다면
        visited[i][j] = true; // 방문처리
        graph[i][j] += weight;
        for(let k = 0; k < 4; k++) { // 상, 하, 좌, 우 차례 방문
            DFS(i + directX[k], j + directY[k], graph[i][j]);
        }
    }
}



// 그래프 탐색
for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) { // 인접행렬 순회
        if (visited[i][j] === false) { // 집이 있다면
            DFS(i, j, 1); // DFS 호출
            //DFS가 한번 수행되고 나면 하나의 단지 전체 방문처리 완료
            //전역 변수로 사용한 home을 배열에 넣고 초기화
        }
    }
}

console.log(parseInt(graph[N-1][M-1]) - 1)
