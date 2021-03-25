const fs = require('fs');
const N = parseInt(fs.readFileSync('/dev/stdin').toString().trim());

// 점화식
// a(n) = a(n-2) + a(n-1)

let array = [1 % 15746, 2 % 15746];

for(let i = 2; i <= N; i++) {
    array.push(parseInt(array[i-2] + array[i-1]) % 15746);
}

console.log(parseInt(array[N-1]));