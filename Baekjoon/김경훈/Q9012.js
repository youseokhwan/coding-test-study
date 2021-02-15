const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

for(let i = 1; i <= input[0]; i++) {
    let isVps = true;
    let stack = [];
    for(let j = 0; j < input[i].length; j++) {
        if(input[i][j] == '(') {
            stack.push(input[i][j])
        }
        else {
            if(stack.length == 0) {
                isVps = false;
                break
            } else {
                stack.pop();
            }      
        }
    }
    if(stack.length > 0) {
        isVps = false;
    }

    console.log(isVps ? 'YES' : 'NO');
}
