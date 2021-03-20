const binarySearch = (N, findElement) => {
    let low = 1;
    let high = findElement;
    let result = 0;
    while(low <= high) {
        let cnt = 0;
        let mid = Math.floor((low + high) / 2);

        for(let i = 1; i < N + 1; i++) {
            cnt += Math.min(Math.floor(mid / i), N);
        }

        if(cnt < findElement) {
            low = mid + 1;
        } else {
            result = mid;
            high = mid - 1;
        }
      
    }
    console.log(result);
};

const fs = require('fs');
const [N, findElement] = fs.readFileSync('/dev/stdin').toString().trim().split('\n').map((el) => parseInt(el));

binarySearch(N, findElement);