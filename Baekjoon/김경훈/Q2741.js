const input = parseInt(require('fs').readFileSync('/dev/stdin'));
let output = "";
for (let i = 1; i < input+1; i++) {
    output += i += "\n";
}
console.log(output);