public class LinkedStack<T> implements MyStack<T> {
    
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

    private ListNode<T> head;
    private int size;

    public LinkedStack() {
        this.head = new ListNode<>(null);
        this.size = 1;
    }

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
        T data = this.head.data;
        this.size--;
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
