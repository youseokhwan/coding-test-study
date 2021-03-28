const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const N = input.shift();

let array = [1, 1, 1, 2, 2];

for(let i = 5; i < 100; i++) {
    array[i] = array[i - 1] + array[i - 5];
}


for(testCase of input) {
    console.log(array[parseInt(testCase - 1)]);
}