const fs = require('fs');
let pattern = "";
var fileArray = fs.readFileSync('/dev/stdin').toString().split('\n');

for(let i = 0; i < fileArray[1].length; ++i) {
    let currentString = fileArray[1][i];
    for(j = 2; j <= fileArray[0]; ++j) {
        if(currentString != fileArray[j][i]) {
            currentString = "?";
            break;
        } else {
            currentString = fileArray[1][i]
        }
    }
    
    pattern += currentString;
}

console.log(pattern)
