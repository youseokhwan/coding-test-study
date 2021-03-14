const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const N = input.shift();

input.sort();
input.sort(function(a, b) {
    return a.length - b.length;
})

let prev = '';
let result = "";
for(let i of input) {
    if(prev !== i) {
        result += `${i}\n`;
    }
    prev = i;
}

console.log(result);