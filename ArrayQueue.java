public class ArrayQueue<T> implements MyQueue<T>{

    // Initialize queue array, head and tail indices, and size value
    private T[] queue = (T[]) new Object[10];
    private int head = 5;
    private int tail = 5;
    private int size = 0;

    // Add item to queue at tail
    @Override
    public void enqueue(T item) {
        // If queue is full then resize
        if (this.size == this.queue.length) {
            resize();
        }
        // Put item at the empty tail index then iterate and loop tail by 1 for next enqueue
        queue[this.tail] = item;
        this.tail = (this.tail + 1) % this.queue.length;
        this.size++;
    }

    // Copy queue to the middle of a new queue twice the size
    private void resize() {
        T[] new_queue = (T[]) new Object[this.queue.length * 2];
        // iterate from head to tail of queue
        for (int i = 0; i < this.queue.length; i++) {
            // Put head at the start of the second quarter of the new queue,
            // ending at the end of the third quarter since new_queue is twice the size of queue
            new_queue[i + new_queue.length / 4] = this.queue[(this.head + i) % this.queue.length];
        }
        this.head = new_queue.length / 4;
        this.tail = this.head + this.queue.length;
        this.queue = new_queue;
    }

    // Return the value at head and increment head past old value to dequeue, throw error if empty
    @Override
    public T dequeue() {
        // If empty throw error
        if (this.size == 0) {
            throw new IllegalStateException();
        }
        T data = this.queue[this.head];
        this.head = (this.head + 1) % this.queue.length;
        this.size--;
        return data;
    }

    // Return value at head without dequeuing, throw error if empty
    @Override
    public T peek() {
        // If empty throw error
        if (this.size == 0) {
            throw new IllegalStateException();
        }
        // Return value at head position in queue
        return this.queue[this.head];
    }

    // Return number of elements in queue
    @Override
    public int size() {
        // Return size
        return this.size;
    }

    // Return true if queue is empty
    @Override
    public boolean isEmpty() {
        // Since we already need to store an empty boolean we can just return that
        return this.size == 0;
    }
}
