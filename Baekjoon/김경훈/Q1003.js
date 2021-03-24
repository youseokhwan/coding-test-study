const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n').map((el) => parseInt(el));
const T = input.shift();

let array = Array(41).fill({'0': 0, '1': 0});

array[0] = {'0': 1, '1': 0}; // 0을 넣을 때 미리 push
array[1] = {'0': 0, '1': 1}; // 1을 넣을 때 미리 push

let max = 2;

const fibonacci = (n) => {
    if(n >= max) {
        for(let i = max; i <= n; i++) {
            array[i][0] = array[i-1][0] + array[i-2][0];
            array[i][1] = array[i-1][1] + array[i-2][1];
        }
        max = n;
    }
    result += `${array[n][0]} ${array[n][1]}\n`;
};

result = '';
for(let testCase of input) {
    fibonacci(testCase);
}

console.log(result);
