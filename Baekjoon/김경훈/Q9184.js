const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const obj = {};

const w = (a, b, c) => {
  let key = a + ',' + b + ',' + c;
  if (Object.prototype.hasOwnProperty.call(obj, key)) {
    return obj[key];
  }

  if (a <= 0 || b <= 0 || c <= 0) {
    obj[key] = 1;
  } else if (a > 20 || b > 20 || c > 20) {
    obj[key] = w(20, 20, 20);
  } else if (a < b && b < c) {
    obj[key] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
  } else {
    obj[key] =
      w(a - 1, b, c) +
      w(a - 1, b - 1, c) +
      w(a - 1, b, c - 1) -
      w(a - 1, b - 1, c - 1);
  }

  return obj[key];
}

for(testCase of input) {
    const splited = testCase.split(' ');
    const [a, b, c] = splited.map(Number);

    if(a == -1 && b == -1 && c ==-1) {
        return;
    }
    console.log('w(' + a + ', ' + b + ', ' + c +') = ' + w(a, b, c));
}