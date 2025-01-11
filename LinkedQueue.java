public class LinkedQueue<E> implements MyQueue<E>{

    private ListNode<E> head;
    private ListNode<E> tail;
    private int size = 0;

    public LinkedQueue() {
        this.head = new ListNode<>(null);
        this.tail = this.head;
    }

    @Override
    public void enqueue(E item) {
        this.tail = new ListNode<>(item, this.tail);
        size++;
    }

    @Override
    public E dequeue() {
        if (this.size == 0) {
            throw new IllegalStateException();
        }
        E data = this.head.data;
        this.head = null; //TODO
        return data;
    }

    @Override
    public E peek() {
        if (this.size == 0) {
            throw new IllegalStateException();
        }
        return this.head.data;
    }

    @Override
    public int size() {
        return this.size;
    }

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
