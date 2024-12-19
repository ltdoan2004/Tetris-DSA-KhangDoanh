export default class Queue {
    constructor() {
        this.items = [];
    }

    enqueue(item) {
        this.items.push(item);
    }

    dequeue() {
        return this.items.shift();
    }

    clone() {
        const newQueue = new Queue();
        newQueue.items = this.items.map(item => item.clone());
        return newQueue;
    }

    peek() {
        return this.items[0];
    }
}