const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');
const N = parseInt(input.shift());
const M = parseInt(input.shift());

let graph = [];
graph = Array.from(Array(N + 1), () => Array(N + 1).fill(0));

for(let i = 0; i < M; i++) {
    const [front, back] = input[i].split(' ').map((el) => parseInt(el));
    graph[front][back] = 1;
    graph[back][front] = 1;
}

let virusComputers = [];
let visited = new Array(N + 1).fill(false); // N + 1 인덱스의 배열을 모두 false 초기화

const DFS = (v) => {
    visited[v] = true; // 방문처리(false -> true)
    virusComputers.push(v); // 바이러스가 감염된 컴퓨터(노드)를 push
    for (let i = 1; i < graph.length; i++) { // graph에 1이 있고 방문하지 않았다면 재귀 호출 
        if (graph[v][i] === 1 && visited[i] === false) {
            DFS(i); 
        } 
    }
}
DFS(1); // 1번 컴퓨터부터 출발
console.log(virusComputers.length - 1); // 바이러스가 감염된 컴퓨터중에 본인 것(1번 컴퓨터)은 제외하고 출력