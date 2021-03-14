const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const N = input.shift();

let array = [];

for(let i of input) {
    const coord = i.split(' ');
    array.push({
        'x': coord[0],
        'y': coord[1]
    });
};

array.sort(function(a, b) {
    if(a.x === b.x) {
        return a.y - b.y;
    } else {
        return a.x - b.x;
    }
});

let result = "";
for(let j of array) {
    result += `${j.x} ${j.y}\n`;
}

console.log(result);