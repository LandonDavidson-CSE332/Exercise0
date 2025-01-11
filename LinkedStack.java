public class LinkedStack<T> implements MyStack<T> {

    // Provided ListNode class defining each node of the STack's linked list
    private static class ListNode<T>{
        private final T data;
        private ListNode<T> next;

        private ListNode(T data, ListNode<T> next){
            this.data = data;
            this.next = next;
        }

        private ListNode(T data){
            this.data = data;
        }
    }

    // Initialize list head and size
    private ListNode<T> head = null;
    private int size = 0;

    @Override
    public void push(T data) {
        this.head = new ListNode<>(data, this.head);
        this.size++;
    }

    @Override
    public T pop() {
        if (this.size == 0) {
            throw new IllegalStateException();
        }
        this.size--;
        T data = this.head.data;
        this.head = this.head.next;
        return data;
    }

    @Override
    public T peek() {
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
}
