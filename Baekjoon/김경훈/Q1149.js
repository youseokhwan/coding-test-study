const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const N = parseInt(input.shift());

let dp = [[]]; // 2차원 배열 생성
dp[0] = input[0].split(' ').map(Number); // i = 0일때를 미리 할당

for(let i = 1; i < N; i++) { // i = 0일때는 이미 넣어놓았으므로 1부터 시작
    const [R, G, B] = input[i].split(' ').map(Number);
    dp.push([]); // 할당을 위해 빈 배열 추가
   
    dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + R; // 그다음에 R을 칠하는 경우
    dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + G; // 그다음에 G를 칠하는 경우
    dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + B; // 그다음에 B를 칠하는 경우

    
}

console.log(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]))); // 끝까지 도달한 경우(N-1)에서 최솟값을 각각 구한다.