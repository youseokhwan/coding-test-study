let input = parseInt(require('fs').readFileSync('/dev/stdin'));
let output = "";
for (let i = 0; i < input; i++) {
    console.log(output += "*");
}