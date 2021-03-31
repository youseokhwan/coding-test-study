/*
6
10
20
15
25
10
20
*/

const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n').map(Number);
const N = parseInt(input.shift());
let dp = [];

dp[0] = input[0];
dp[1] = Math.max(input[0]+input[1], input[1]);
dp[2] = Math.max(input[1]+input[2], input[0]+ input[2]);

for(let i = 3; i < N; i++) {
    dp[i] = Math.max(dp[i-2] + input[i], dp[i-3] + input[i] + input[i-1]);
}

console.log(dp[N-1]);
