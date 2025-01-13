public class ArrayQueue<T> implements MyQueue<T>{

    // Initialize queue array and head and tail indices
    private T[] queue = (T[]) new Object[10];
    private int head = 5;
    private int tail = 5;
    private boolean empty = true;

    // Add item to queue at tail
    @Override
    public void enqueue(T item) {
        // If queue is full then resize, an empty array looks like a full one so we need the empty boolean
        if (!this.empty && this.tail == this.head) {
            resize();
        }
        // Queue isn't empty since we are adding an element
        this.empty = false;
        // Put item at the empty tail index then iterate and loop tail by 1 for next enqueue
        queue[this.tail] = item;
        this.tail = (this.tail + 1) % this.queue.length;
    }

    // Copy queue to the middle of a new queue twice the size
    private void resize() {
        T[] new_queue = (T[]) new Object[this.queue.length * 2];
        // iterate from head to tail of queue
        for (int i = 0; i < this.tail; i++) {
            // Put head at the start of the second quarter of the new queue,
            // ending at the end of the third quarter since new_queue is twice the size of queue
            new_queue[i + new_queue.length / 4] = this.queue[(this.head + i) % this.queue.length];
        }
        this.queue = new_queue;
    }

    // Return the value at head and increment head past old value to dequeue, throw error if empty
    @Override
    public T dequeue() {
        // If empty throw error
        if (this.empty) {
            throw new IllegalStateException();
        }
        T data = this.queue[this.head];
        this.head++;
        this.empty = this.head == this.tail;
        return data;
    }

    // Return value at head without dequeuing, throw error if empty
    @Override
    public T peek() {
        // If empty throw error
        if (this.empty) {
            throw new IllegalStateException();
        }
        // Return value at head position in queue
        return this.queue[this.head];
    }

    // Return number of elements in queue
    @Override
    public int size() {
        // Return difference between tail and head and then mod by length to account for circularity
        return (this.tail - this.head) % this.queue.length;
    }

    // Return true if queue is empty
    @Override
    public boolean isEmpty() {
        // Since we already need to store an empty boolean we can just return that
        return this.empty;
    }
}
