/*
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5
*/

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const N = input.shift();
const dp = [];

for(line of input) { // 2차원 배열 만들기
    dp.push(line.split(' ').map((el) => parseInt(el)));
}
let max = 0;

for (let i = 1; i < N; i++) { 
    for (let j = 0; j <= i; j++) {
        if(j == 0) { // 맨 왼쪽에 붙어있다면
            dp[i][j] += dp[i - 1][j]; 
        }
        else if(i == j) { // 맨 오른쪽에 붙어있다면
            dp[i][j] += dp[i - 1][j - 1]; 
        }
        else {
            dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
        } 
        max = max < dp[i][j] ? dp[i][j] : max;
    }
}
console.log(max);
