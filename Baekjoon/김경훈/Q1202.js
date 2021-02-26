const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');
const NK = input.shift().split(' ');
const N = NK[0];
const K = NK[1];
let jewels = [];
let bags = [];
for (let i = 0; i < N; i++) {
    const jewel = input[0].split(' ');
    jewels.push({
        weight: jewel[0],
        price: jewel[1]
    });

    input.shift();
}
for (let i = 0; i < K; i++) {
    bags.push(input[0]);
    input.shift();
}

// Sorting
jewels.sort((a, b) => a.weight - b.weight)
bags.sort((a, b) => a - b);

// 우선순위 큐 구현

class PriorityQueue {
    constructor() {
        this.queue = [];
    }
    enque(element) {
        this.queue.push(element);
        let current = this.queue.length;
        let parent = current >> 1;
        while (parent >= 1) {
            if (this.queue[parent].price >= element.price) {
                break;
            }

            this.queue[current] = this.queue[parent]
            current = parent;
            parent = current >> 1;
        }
    }
    dequeue() {
        let entry = 0;
        this.queue.forEach((item, index) => {
            if (this.queue[entry].weight < this.queue[index].weight) {
                entry = index;
            }
        });
        return this.queue.splice(entry, 1);
    }
}

const priorityQueue = new PriorityQueue();
let count = 0;
bags.forEach(element => {
    let jewelIndex = 0;
    while (element >= jewels[jewelIndex].weight) {
        if (jewelIndex >= N) {
            break;
        }
        priorityQueue.enque(jewels[jewelIndex]);
        jewelIndex += 1;
    }
    if (priorityQueue.queue.length != 0) {
        const a = priorityQueue.dequeue();
        count += parseInt(a[0].price);
    }

});
console.log(count);