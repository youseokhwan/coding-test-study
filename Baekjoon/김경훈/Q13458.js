const fs = require('fs'); // 입출력 모듈 import
const input = fs.readFileSync('/dev/stdin').toString().split('\n'); // \n split
let N = input.shift(); // N
let A = input.shift().split(' '); // A:array
const maxCount = input[0].split(' '); // 총감독관, 부감독관 응시자 수
let B = maxCount[0]; // B
let C = maxCount[1]; // C
let count = parseInt(N); // 총감독관은 어차피 모든 시험장에 한명씩 들어가야 하므로 미리 더하고 시작한다.
for(let i = 0; i < N; i++) { // O(n)
    extra = parseInt(A[i]) - parseInt(B); // 남은 인원수 = 전체 인원수 - 총감독관이 맡은 인원수
    if(extra > 0) { // 총감독이 맡은 인원을 빼도 응시자가 남는다면
        count += parseInt(extra / C); // 남은 응시자에서 부감독관을 할당해주고(몫을 더하고)
        if(extra % C != 0) { // 나머지가 있을때는 어쩔수없이 부감독관을 한명 더 할당한다.
            count += 1;
        }
    }
}
console.log(count);