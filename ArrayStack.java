public class ArrayStack<T> implements MyStack<T> {

    private int head = -1;
    private T[] stack = (T[]) new Object[10];

    @Override
    public void push(T item) {
        if (this.head == this.stack.length - 1) {
            resize();
        }
        this.head++;
        this.stack[this.head] = item;
    }

    private void resize() {
        T[] new_stack = (T[]) new Object[this.stack.length * 2];
        System.arraycopy(this.stack, 0, new_stack, 0, this.stack.length);
        this.stack = new_stack;
    }

    @Override
    public T pop() {
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
