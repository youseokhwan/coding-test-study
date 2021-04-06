const fs = require('fs');
const [M, N] = fs.readFileSync('/dev/stdin').toString().trim().split(' ').map(Number);

let isPrime = new Array(N + 1).fill(true);

isPrime[0] = false;
isPrime[1] = false;

let result = "";
for (let n = 2; n <= Math.ceil(Math.sqrt(N)); n++) {
    if (isPrime[n]) {
        let m = 2;
        while (n * m <= N) {
            isPrime[n * m] = false;
            m++;
        }
    }
}


const result = [];
for (let n = M; n <= N; n++) {
    if (isPrime[n]) {
        result.push(n);
    }
}
console.log(result.join('\n'));