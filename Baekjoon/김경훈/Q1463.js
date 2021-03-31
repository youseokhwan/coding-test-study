const fs = require('fs');
const X = parseInt(fs.readFileSync('/dev/stdin').toString().trim());

let min = 1000001;

let DP = Array(X + 1).fill(0);

// const DP = new Array(

for (let i = 2; i <= X; i++) {
    DP[i] = DP[i - 1] + 1;
    if (i % 2 === 0) {
        DP[i] = Math.min(DP[i / 2] + 1, DP[i]);
    }
    if (i % 3 === 0) {
        DP[i] = Math.min(DP[i / 3] + 1, DP[i]);
    }
}

console.log(DP[X]);