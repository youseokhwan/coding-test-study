const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const N = input.shift();
const targetArray = input.shift().split(' ').map((el) => parseInt(el));

const M = input.shift();
const originalSearchArray = input.shift().split(' ').map((el) => parseInt(el));
const searchArray = [...originalSearchArray].sort((a , b) => a - b);

const binarySearch = (searchArray, target) => {
    let low = 0;
    let high = searchArray.length - 1;
    while(low <= high) {
        let mid = Math.floor((low + high) / 2);
        let middleElement = searchArray[mid];
        if(target > middleElement) {
            low = mid + 1;
        } else if (target < middleElement) {
            high = mid - 1;
        } else {
            return 1;
        }
    }
    return 0;
}

const array = {};

for(let target of targetArray) {
    const _result = binarySearch(searchArray, target);
    if(array[target] == undefined) {
        array[target] = 1;
    } else {
        array[target] += _result;
    }
}

let result = "";

for(let element of originalSearchArray) {
    result += `${array[element] == undefined ? '0 ' : `${array[element]} `}`;
}

console.log(result);