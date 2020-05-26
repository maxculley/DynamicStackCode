
public class DynamicStack {

    int capacity = 2; // Set the starting capacity of the stack
    int[] stack = new int[capacity]; // Initialise stack (array)
    int top = 0; // Track top of stack

    private void expand() {
        int length = size();

        int[] newStack = new int[capacity * 2];
        System.arraycopy(stack, 0, newStack, 0, length);
        stack = newStack;
        capacity *= 2;
    }

    private void shrink() {
        int length = size();
        if (length <= (capacity / 4)) { // If the length of the stack is 1/4 the size of the capacity, half the capacity
            capacity = capacity / 2;

            int newStack[] = new int[capacity];
            System.arraycopy(stack, 0, newStack, 0, length); // Copy old array into new array

            stack = newStack; // Reassign array
        }

    }

    public void push(int data) { // Push to the top of stack
        if (size() == capacity) { // If stack is full
            expand();
        }
        stack[top] = data; // Add value to stack
        top++;

    }

    public int pop() { // Remove top value from stack
        if (isEmpty()) { // If stack is empty
            System.out.println("STACK IS EMPTY");
            return 0;
        } else {
            top--;
            int data = stack[top];
            stack[top] = 0;
            shrink();
            return data;
        }
    }

    public int peek() {
        return stack[top - 1];
    }

    public void show() {
        for (int i = 0; i < stack.length; i++) {
            System.out.print(stack[i] + " ");
        }
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top <= 0;
    }

}
