const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n').map((el) => parseInt(el));
const N = input.shift();

input.sort((a, b) => a - b);

const avg = Math.round(input.reduce((a, b) => a + b, 0) / N)
console.log(avg) // 산술평균

console.log(input[parseInt(N / 2)]); // 중간값


// 최빈값 구하기

let _array = {};
let max = -1;
for(let v of input){
    _array[v] ? _array[v]++ : _array[v] = 1;
    if(max < _array[v]) {
        max = _array[v];
    }
}


const most = [];
for(let j in _array){
    if(_array[j] === max) {
        most.push(j);
    }
}
most.sort((a, b) => a - b);

if(most.length > 1) {
    console.log(parseInt(most[1]));
} else {
    console.log(most[0])
}

console.log(input[N - 1] - input[0]);  // 최대 - 최소
