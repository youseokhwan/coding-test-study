const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const N = parseInt(input.shift());


// 이전 풀이(메모리 초과)
// let array = input.shift().split(' ').map(Number);
// let dp = Array(N);
// let max = [];
// for(let i = 0; i < N; i++) {
//     dp[i] = new Array(N).fill(-1001)
// }
// for(let i = 0; i < N; i++) {
//     for(let j = i; j < N; j++) {
//         if(j==i) {
//             // console.log('같아', array[i]);
//             dp[i][j] = array[i];
//         } 
//         else {
//             dp[i][j] = dp[i][j-1] + array[j];
//         }
//     }
//     max.push(Math.max.apply(null, dp[i]))
// }

// console.log(Math.max.apply(null, max));


// 메모리 초과 해결(점화식)
let dp = input.shift().split(' ').map(Number);
let max = dp[0];

for(let i = 1; i < N; i++) {
    if(dp[i-1] > 0 && dp[i] + dp[i-1] > 0) { // 이전 값이 양수이고, 이전값과 지금값을 더했을 때 0보다 크다면(최소한 더 작아지지 않았다면)
        dp[i] += dp[i-1]; // 연속합을 더해준다.
    }

    if(max < dp[i]) {
        max = dp[i]
    }
}

console.log(max);