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

    // Add data to head of stack
    @Override
    public void push(T data) {
        // Create new node with data and pointer to head and assign it to head
        this.head = new ListNode<>(data, this.head);
        this.size++;
    }

    // Return value at head and remove it from stack
    @Override
    public T pop() {
        // If list is empty throw an error
        if (this.size == 0) {
            throw new IllegalStateException();
        }
        this.size--;
        // Read data in head then set head equal to head.next and return data
        T data = this.head.data;
        this.head = this.head.next;
        return data;
    }

    // Return value at head without popping
    @Override
    public T peek() {
        // If list is empty throw error
        if (this.size == 0) {
            throw new IllegalStateException();
        }
        // Read and return data in head
        return this.head.data;
    }

    // Return this.size
    @Override
    public int size() {
        return this.size;
    }

    // Return true if this.size == 0
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
}
