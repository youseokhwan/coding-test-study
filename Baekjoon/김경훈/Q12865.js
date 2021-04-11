const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const [N, K] = input.shift().split(' ').map(Number);

let items = [0, ];

for(line of input) {
    items.push(line.split(' ').map(Number));
}

// // 물건 번호 맞추기 위해 맨 앞에 null 넣음
// items.unshift(undefined);

// array[n][k]: n번까지의 물건들 중 몇 개를 골라,
// 그 무게 합이 k 이하인 경우들 각각의 가치 합 중 최댓값

const array = [];
for (let i = 0; i <= N; i++) {
    array.push(Array(K + 1).fill(0));
}

for (let n = 1; n <= N; n++) {
    const [weight, value] = items[n];
    for (let k = 0; k <= K; k++) {
        if (k < weight) { // 물건의 무게가 k보다 크면 넣을 수 없다.
            array[n][k] = array[n - 1][k];
        } else {
            array[n][k] = Math.max(
                array[n - 1][k], // n번 물건 안 담는 경우
                array[n - 1][k - weight] + value // n번 물건 담는 경우
            );
        }
    }
}

// console.log(array);
console.log(array[N][K]);
