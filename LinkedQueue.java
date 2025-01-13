public class LinkedQueue<E> implements MyQueue<E>{

    // Initialize head and tail variables, the linked list points from head to tail
    private ListNode<E> head = null;
    private ListNode<E> tail = null;
    private int size = 0;

    // Add item to tail of queue
    @Override
    public void enqueue(E item) {
        // If the list is empty set head and tail to the new node
        if (this.size == 0) {
            this.tail = new ListNode<>(item);
            this.head = this.tail;
            this.size++;
            return;
        }
        // Create new node after tail and then assign that as the new tail
        this.tail.next = new ListNode<>(item);
        this.tail = this.tail.next;
        this.size++;
    }

    // Remove head and return its data, throw error if empty
    @Override
    public E dequeue() {
        // If stack is empty throw an error
        if (this.size == 0) {
            throw new IllegalStateException();
        }
        // Save the data in head and then move the head one node up the list
        E data = this.head.data;
        this.head = this.head.next;
        this.size--;
        return data;
    }

    // Return data at head of queue, or throw error if empty
    @Override
    public E peek() {
        if (this.size == 0) {
            throw new IllegalStateException();
        }
        return this.head.data;
    }

    // Return size of queue
    @Override
    public int size() {
        return this.size;
    }

    // Return true of size== 0
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    private static class ListNode<E>{
        private final E data;
        private ListNode<E> next;

        private ListNode(E data, ListNode<E> next){
            this.data = data;
            this.next = next;
        }

        private ListNode(E data){
            this.data = data;
        }
    }
}
