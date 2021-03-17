const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const N = input.shift();
const searchArray = input.shift().split(' ').map((el) => parseInt(el));
searchArray.sort((a, b) => a - b);

const M = input.shift();
const targetArray = input.shift().split(' ').map((el) => parseInt(el));

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

let result = '';

for(target of targetArray) {
    result += `${binarySearch(searchArray, target)}\n`;
}

console.log(result);