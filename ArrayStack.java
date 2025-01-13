public class ArrayStack<T> implements MyStack<T> {

    private int head = -1;
    private T[] stack = (T[]) new Object[10];

    // Add item to head of stack
    @Override
    public void push(T item) {
        // If array is full resize it
        if (this.head == this.stack.length - 1) {
            resize();
        }
        // Iterate head and store item since we know there is space
        this.head++;
        this.stack[this.head] = item;
    }

    // Copy elements from stack to a new array that is twice the size
    private void resize() {
        // Create new array twice the size of stack
        T[] new_stack = (T[]) new Object[this.stack.length * 2];
        // Copy stack into new_stack and assign it to stack
        System.arraycopy(this.stack, 0, new_stack, 0, this.stack.length);
        this.stack = new_stack;
    }

    // Return data in head and remove from the stack, throw error if empty
    @Override
    public T pop() {
        // If the array is empty throw error
        if (this.head == -1) {
            throw new IllegalStateException();
        }
        // Save data in head, decrement head, and return data
        T data = this.stack[head];
        head--;
        return data;
    }

    // Return data in head without popping, throw error if empty
    @Override
    public T peek() {
        // If array is empty throw error
        if (this.head == -1) {
            throw new IllegalStateException();
        }
        // Return data at head in stack
        return this.stack[this.head];
    }

    // Return head + 1 since head is the zero-indexed position of the top of the stack
    @Override
    public int size() {
        return this.head + 1;
    }

    // Return true if list is empty
    @Override
    public boolean isEmpty() {
        return this.head + 1 == 0;
    }
}
