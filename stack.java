// Simple Stack implementation using a singly linked list
class StackUsingLinkedList {
    // Node structure
    class Node {
        int data;
        Node next;
        Node(int d) { data = d; next = null; }
    }

    private Node top; // top of stack
    private int size;

    public StackUsingLinkedList() {
        top = null;
        size = 0;
    }

    // Push an element onto the stack
    public void push(int value) {
        Node node = new Node(value);
        node.next = top;
        top = node;
        size++;
        System.out.println("Pushed: " + value);
    }

    // Pop an element from the stack; throws RuntimeException if empty
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow - stack is empty");
        }
        int val = top.data;
        top = top.next;
        size--;
        System.out.println("Popped: " + val);
        return val;
    }

    // Peek at the top element without removing
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return top.data;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Get current size
    public int size() {
        return size;
    }

    // Display stack contents from top to bottom
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Top -> ");
        Node cur = top;
        while (cur != null) {
            System.out.print(cur.data);
            if (cur.next != null) System.out.print(" -> ");
            cur = cur.next;
        }
        System.out.println(" -> null");
    }

    // Demo main
    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();

        System.out.println("=== Stack Demo (using linked list) ===");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();

        System.out.println("Peek: " + stack.peek());
        stack.pop();
        stack.display();

        stack.pop();
        stack.pop();

        System.out.println("Is empty? " + stack.isEmpty());
        System.out.println("Final size: " + stack.size());

        // Uncomment to see underflow exception
        // stack.pop();
    }
}

