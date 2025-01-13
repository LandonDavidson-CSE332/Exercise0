public class ArrayQueue<T> implements MyQueue<T>{

    // Initialize queue array and head and tail indices
    private T[] queue = (T[]) new Object[10];
    private int head = 5;
    private int tail = 5;
    private boolean empty = true;

    // Add item to queue at tail
    @Override
    public void enqueue(T item) {
        // If queue is full then resize
        if (this.tail == this.head) {
            resize();
        }
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
            new_queue[i + new_queue.length / 4] = this.queue[this.head + i];
        }
        this.queue = new_queue;
    }

    @Override
    public T dequeue() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
