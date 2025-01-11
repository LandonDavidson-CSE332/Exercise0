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
    private int size = 0;

    public LinkedStack(T head_val) {
        this.head = new ListNode<>(head.data, null);
        this.size = 1;
    }

    public void push(T data) {
        this.head = new ListNode<>(data, this.head);
        this.size++;
    }

    public T pop() {
        i f(this.size == 0) {
            return null;
        }
        T data = this.head.data;
        this.size--;
        this.head = old_head.next;
        return data;
    }

    public T peek() {
        if (this.size == 0) {
            return;
        }
        return this.head.data;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size ? false : true;
    }
}
