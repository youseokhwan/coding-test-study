const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const [N, M] = input.shift().split(' ').map(Number);

let graph = [];

const dX = [1, -1, 0, 0];
const dY = [0, 0, 1, -1];

let total = N * M;
let ripedTomato = [];
let newRipedTomato = [];

for(line of input) {
    graph.push(line.split(' ').map(Number));
}

for(let i = 0; i < M; i++) {
    for(let j = 0; j < N; j++) {
        if(graph[i][j] === 1) {
            ripedTomato.push(`${i} ${j}`);
        } else if(graph[i][j] === -1) {
            total -= 1;
        } 
    }
}

let day = 0;

let tomatoCount = ripedTomato.length;
while (true) {
    ripedTomato.forEach((tomato) => {
        const [n, m] = tomato.split(' ').map(Number);
        for(let i = 0; i < 4; i++) {
            const nextX = m + dX[i];
            const nextY = n + dY[i];
            if(nextY >= 0 && nextY < M && nextX >= 0 && nextX < N) {
                if(graph[nextY][nextX] === 0) {
                    graph[nextY][nextX] = 1;
                    newRipedTomato.push(`${nextY} ${nextX}`);
                } else { // 빈칸, 이미 익은 토마토 continue
                    continue;
                }
            }
        }

    });

    if(newRipedTomato.length === 0) { // 새로 익은 토마토가 없으면 break
        break;
    }
    
    tomatoCount += newRipedTomato.length; // 카운트 세줌
    ripedTomato = Array.from(newRipedTomato); // 새로 익은 토마토로 최신화
    newRipedTomato = [];
    day += 1;

}

console.log(tomatoCount === total ? day : '-1'); // 빈칸을 제외한 total과 익은 토마토 개수를 카운트 한 것을 비교