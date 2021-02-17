// 입력 모듈을 import
const fs = require('fs');
// 정수를 입력받고 1000원에서 빼어 잔돈을 계산한다.
let extra = 1000 - Number(fs.readFileSync('/dev/stdin'));
// 동전의 단위를 미리 리스트에 선언해놓는다.
const list = [500, 100, 50, 10, 5, 1];
// 사용한 잔돈(동전)의 개수
let count = 0;
// list를 순회하며 잔돈을 계산한다
for(i of list) {
    // 잔돈이 0원이 되면 리스트를 다 순회하지 못했어도 반복문에서 탈출한다
    if(extra == 0) { 
        break;
    }
    // 잔돈에서 동전 단위의 몫을 구한다. JS는 타입 프리 언어라서 정수형에 '/'를 사용해도 알아서 double로 계산하기 때문에 다시 정수로 변환해준다.
    count += parseInt(extra / i);
    // 잔돈은 동전의 단위로 나눈 나머지만큼 남는다.
    extra %= i;
}
// 마지막에 잔돈으로 사용한 동전의 개수를 출력한다.
console.log(count);