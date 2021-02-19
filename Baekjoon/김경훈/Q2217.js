const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n').map((el) => parseInt(el));
const N = input.shift();
input.sort((a, b) => {
    return a - b;
})
let maxWeight = 0;
let nowWeight;
for(let i = 0; i < N; i++) {
    nowWeight = input[i] * (N - i);
    if(nowWeight > maxWeight) {
        maxWeight = nowWeight;
    }
}

console.log(maxWeight);