// 입력 모듈 import
const fs = require('fs');
// \n을 기준으로 split
const input = fs.readFileSync('/dev/stdin').toString().split('\n');
// 첫줄은 input에서 shift(배열의 첫번째 인덱스를 제거하고 제거한 값을 반환하는 함수)를 이용하여 빼내고 Int로 형변환해준다.
let firstLine = input.shift().split(' ').map((el) => parseInt(el));
// 공백을 이용하여 split하면 두번째 요소가 K가 된다.
let K = firstLine[1];
// 동전 개수 선언
let count = 0;
// for in 구문
// 순회하기 전에 항상 최적의 해를 만족하려면 큰 수부터 나눠주어야 동전의 개수를 최소화할 수 있으므로 배열을 reverse 해주고, 형변환해준다.
for(element of input.reverse().map((el) => parseInt(el))) {
    // 분자(남은 돈)가 분모(나누는 동전의 단위)보다 큰 경우에만 주어진 동전의 단위로 나누는 것이 가능하므로 조건을 건다.
    // 이때 Javascript는 Int를 '/'해도 알아서 Double로 뱉으므로 1.xx의 경우도 대응이 가능하다.
    if((K / element) >= 1) {
        // 나눌 수 있다면, 현재 단위의 동전으로 나눈 수 만큼 동전의 개수를 Int로 형변환 후 카운트.
        count += parseInt(K / element);
        // 계산 후 돈은 나머지만 남긴다.
        K %= element;
        // 돈이 0원이 되면 딱 맞아떨어지도록 계산이 된 것이므로 루프를 탈출한다.
        if(K == 0) {
            break;
        }
    }
}
// 동전의 개수 출력
console.log(count);