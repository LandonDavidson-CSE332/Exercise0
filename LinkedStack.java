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
    private int elements = 0;
    public LinkedStack(int head_val) {
        this.head = new ListNode<>(head.data, null);
        this.elements = 1;
    }
}
