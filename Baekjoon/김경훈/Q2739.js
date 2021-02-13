let input = parseInt(require('fs').readFileSync('/dev/stdin'));
for(let i=1; i<10; i++) {
    console.log(`${input} * ${i} = ${input * i}`)
}