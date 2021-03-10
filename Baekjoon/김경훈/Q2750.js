const quickSort = (array) => {
    if(array.length < 2) {
        return array;
    }

    const left = [];
    const right = [];
    const pivot = [array[0]];

    for(let i = 1; i < array.length; i++) {
        if (array[i] < pivot) {
            left.push(array[i]);
        } else if (array[i] > pivot) {
            right.push(array[i]);
        } else {
            pivot.push(array[i]);
        }
    }
    return quickSort(left).concat(pivot, quickSort(right));
}

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n').map((el) => parseInt(el));
input.shift();
const sorted = quickSort(input);
console.log(sorted.join('\n'));