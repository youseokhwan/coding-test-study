const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');
const N = input.shift();

let time = [];
for(let i = 0; i < N; i++) {
    let times = input[i].split(' ').map((el) => parseInt(el)); // 공백을 기준으로 input을 자른 후 정수로 형변환
    time.push({'start': times[0], 'end': times[1]}); // 배열에 객체 형태로 push
}

time.sort(function(a, b) { // O(n log n)
    if(a.start == b.start) { // 끝나는 시간이 같으면 시작시간이 빠른것으로 정렬
        return a.end > b.end ? 1 : -1;
    }
    return a.start > b.start ? 1 : -1; // 끝나는 시간 기준 오름차순 정렬
});

let queue = [time[0].end];
for(let i = 1; i < N; i++) {
    // start
    if(time[i].start >= queue[0]) { //시작시간이 잘 맞는다면
        queue.shift();
    }
    // enque
    queue.push(parseInt(time[i].end));
    let current = queue.length - 1;
    while(true) {
        if(current == 0) {
            break;
        }
        if(queue[current] < queue[current - 1]) { // 기존 것이 이전것보다 작다면 스왑하여 앞으로 땡겨주기
            const temp = queue[current];
            queue[current] = queue[current-1]
            queue[current-1] = temp;
        }
        current--;
    }     
}

console.log(queue.length);