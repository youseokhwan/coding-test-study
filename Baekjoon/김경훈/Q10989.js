// 숫자의 최대값이 지정되어 있으므로 계수정렬

const countingSort = (array, k) => {
    let count = Array(k).fill(0);
    let sorted = [];

    for(let j = 0; j < array.length; j++) {
        count[array[j]] += 1;
    }


    for(let i = 0; i < k; i++) {
        const sortedNum = Array(count[i]).fill(i);
        sorted = sorted.concat(sortedNum)
    }

    console.log(sorted.join('\n'));
}

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const N = input.shift();

countingSort(input, 10000);