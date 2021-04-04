const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');
const INF = Infinity;
const [V, E] = input.shift().split(' ').map(Number);
const start = Number(input.shift());

let graph = [];

for (let i = 0; i < V; i++) {
    graph.push([]); // 2차원 배열로 만들어줌
}

let visited = Array(V).fill(false); // 방문 여부 배열 false
let distances = Array(V).fill(INF); // 거리는 최솟값을 구해야 하기 때문에 우선 Infinity로 초기화

let u, v, w;

input.forEach((line) => { // 이어진 간선, 가중치 포함하는 그래프 만들기
    [u, v, w] = line.split(' ').map(Number); // u, v, w 비구조화 할당
    graph[u - 1].push([w, v - 1]); // u, v를 1씩 빼주는 이유는 배열에서는 0부터 시작하기 때문에
});

const dijkstra = (vStart) => { // 다익스트라 구현
    distances[vStart] = 0; // 시작 거리는 0

    while (true) { // loop
        let shortestD = INF; // 최소 거리 비교를 위해 Infinity로 초기화
        let closestV;
        for (let i = 0; i < distances.length; i++) {
            if (distances[i] < shortestD && !visited[i]) { // 거리가 최소 거리이고, 아직 방문하지 않았다면
                shortestD = distances[i]; // 최소 거리 갱신
                closestV = i; // 가장 가까운 vertex를 갱신
            }
        }
    
        if (shortestD === INF) { // 최소 거리를 찾지 못한다면 break
            break;
        }
    
        visited[closestV] = true; // 최소 거리의 vertex를 방문했으므로 방문여부 true

        let w, v;
        graph[closestV].forEach((node) => { // 최소 거리 계산을 위해 순회
            [w, v] = node; // 가중치, v 비구조화 할당
            if (visited[v]) { // 이미 방문한 경우는 skip(=continue)
                return;
            }
            distances[v] = Math.min(distances[v], distances[closestV] + w); // i번째 줄의 i번 정점까지 가야하므로 최솟값을 비교하면서 순회
        });
    }
};


dijkstra(start - 1);

distances.forEach((d, i) => {
    distances[i] = d === INF ? INF: d;
});

console.log(distances.join("\n"));

