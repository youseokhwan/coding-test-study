const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');
const N = input.shift();
const graph = Array.from(Array(N), () => new Array(N));

const directX = [1, -1, 0, 0];
const directY = [0, 0, 1, -1];

// 입력값을 그래프에 담아줌
for (let i = 0; i < N; i++) {
    graph[i] = input[i].split("").map((el) => Number(el));
}

let house = 0; // 집 개수를 셀 변수
let count = []; // 집 개수들을 담을 배열


const DFS = (i, j) => {
    if(i >= 0 && i < N && j >= 0 && j < N && graph[i][j] === 1) {
        graph[i][j] = 0; // 방문처리
        house += 1;
        for(let k = 0; k < 4; k++) {
            DFS(i + directX[k], j + directY[k]);
        }
    }

}

// 그래프 탐색
for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
        // 방문한적 없다면 DFS호출
        if (graph[i][j] === 1) {
            DFS(i, j);
            //DFS가 한번 수행되고 나면 하나의 단지 전체 방문처리 완료
            //전역 변수로 사용한 home을 배열에 넣고 초기화
            count.push(house);
            house = 0;
        }
    }
}

console.log(count.length);
count.sort((a, b) => a - b);
count.forEach((element) => {
    console.log(element);
})