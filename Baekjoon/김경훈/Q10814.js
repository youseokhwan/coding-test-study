const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const N = input.shift();

let array = [];

for(let i of input) {
    const element = i.split(' ');
    array.push({
        'age': element[0],
        'name': element[1]
    });
}

array.sort((a, b) => a.age - b.age);

let result = "";

for(let j of array) {
    result += `${j.age} ${j.name}\n`;
}

console.log(result);