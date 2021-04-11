const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const N = input.shift();
const array = input[0].split(' ').map(Number);

let object = {};

for(num of array) {
    object[num] = num;
}
const keys = Object.keys(object);
keys.sort((a, b) => a - b);

let sortedObj = {};
let index = 0;
for(key of keys) {
    sortedObj[key] = index;
    index += 1;
}

// { '2': 2, '4': 3, '-10': 0, '-9': 1 }

const result = [];
for(num of array) {
    result.push(sortedObj[num]);
}

console.log(result.join(' '));