
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const [N, M] = input.shift().split(' ').map(Number);

const array = [];
const visited = [];

for (line of input){
    array.push(line.split('').map(Number));
    visited.push(Array(M).fill(0).map(() => Array(1).fill(0)));
}

const dY = [1, -1, 0, 0];
const dX = [0, 0, -1, 1];

visited[0][0][0] = 1;

const queue = [[0, 0, 0]];

let result = "-1";

while (queue.length !== 0) {
    const [y, x, w] = queue.shift();

    if (y === N - 1 && x === M - 1) {
        // console.log(visited[N - 1][M - 1][w])
        result = visited[N - 1][M - 1][w];
        break;
    }

    for (let i = 0; i < 4; i++) {
        const nextY = y + dY[i];
        const nextX = x + dX[i];
        const nextW = w + 1;

        if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M || visited[nextY][nextX][w] > 1) {
            continue;
        }

        if (array[nextY][nextX] === 0) { // 방문할 수 있는 곳이라면
            visited[nextY][nextX][w] = visited[y][x][w] + 1;
            queue.push([nextY, nextX, w]);
        }

        if (array[nextY][nextX] === 1 && nextW <= 1) { // 벽이라면
            visited[nextY][nextX][nextW] = visited[y][x][w] + 1;
            queue.push([nextY, nextX, nextW]);
        }
    }
}


console.log(result);
