const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split("\n");

let arr = [];
let plus = 1
let count = 0;
for(let i = 0; i < 2; i++) {
    Array.prototype.forEach.call(input[i].trim(), (el) => {
        if(arr[el] == undefined) {
            arr[el] = plus;
            count += 1;
        } else {
            arr[el] += plus;
            if(arr[el] >= 0 && i == 1) {
                count -= 1;
            } else {
                count += 1;
            }
        }
    })

    plus -= 2;
}
console.log(count);
