const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');
const [N, M, V] = input.shift().split(' ').map((el) => parseInt(el));

let graph = [];
graph = Array.from(Array(N + 1), () => Array(N + 1).fill(0));

for(let i = 0; i < M; i++) {
    // let array = [];
    const [front, back] = input[i].split(' ').map((el) => parseInt(el));
    graph[front][back] = 1;
    graph[back][front] = 1;
}

let visitedGraph = [];
let visited = new Array(N + 1).fill(false);

const DFS = (v) => {
    visited[v] = true; // 방문처리(false -> true)
    visitedGraph.push(v); // 출력용
    for (let i = 1; i < graph.length; i++) { //graph에 1이 있고 방문하지 않았다면 재귀 호출 
        if (graph[v][i] === 1 && visited[i] === false) {
            DFS(i); 
        } 
    }
}
DFS(V);
console.log(visitedGraph.join(' '));
visited = new Array(N + 1).fill(false); // visited 초기화
visitedGraph = []; // visitedGraph 초기화
const BFS = (v) => {
    let queue = []; // 시작 노드 큐에 삽입 
    queue.push(v); // 시작 노드 방문처리 
    visitedGraph.push(v); //큐에 값이 있을동안 계속 반복 
    while (queue.length !== 0) { 
        //큐에서 하나를 빼서 그 노드 방문처리 
        let dequeue = queue.shift();
        visited[dequeue] = true;  
        for (let i = 1; i < graph.length; i++) { //큐에서 뺀 노드를 반복하면서 노드와 연결된 
            //다른 노드들 중 1이 있고 방문하지 않았다면 
            if (graph[dequeue][i] === 1 && visited[i] === false) { //연결 노드 방문처리 후 큐와 출력을 위한 배열에 삽입 
                visited[i] = true; 
                queue.push(i); 
                visitedGraph.push(i); 
            } 
        } 
    } 
    return;

}
BFS(V);
console.log(visitedGraph.join(' '));


