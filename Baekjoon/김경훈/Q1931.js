const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n'); // 입출력 받기
const N = input.shift(); // N만 배열에서 빼내기
let time = []; // time 담을 배열 선언

for(let i = 0; i < N; i++) {
    let times = input[i].split(' ').map((el) => parseInt(el)); // 공백을 기준으로 input을 자른 후 정수로 형변환
    time.push({'start': times[0], 'end': times[1]}); // 배열에 객체 형태로 push
}

time.sort(function(a, b) { // O(n log n)
    if(a.end == b.end) { // 끝나는 시간이 같으면 시작시간이 빠른것으로 정렬
        return a.start > b.start ? 1 : -1;
    }
    return a.end > b.end ? 1 : -1; // 끝나는 시간 기준 오름차순 정렬
});

let _end = 0; // 맨 처음 끝나는 시간 0으로 간주
let count = 0; // 회의 수 카운트

for(let j in time) { 
    if(_end <= time[j].start) { // 끝나는 시간보다 그다음 시작 시간이 뒤에있으면
        _end = time[j].end; // 그다음 회의를 시작한 것으로 간주하고 끝나는 시간을 초기화한후
        count += 1; // 카운트를 더한다
    }
}

console.log(count);