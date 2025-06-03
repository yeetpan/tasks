import java.util.Scanner;

// Generic Stack implementation using Linked List
class Stack<T> {
    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> top;

    public void push(T item) {
        Node<T> node = new Node<>(item);
        node.next = top;
        top = node;
    }

    public T pop() {
        if (isEmpty()) return null;
        T item = top.data;
        top = top.next;
        return item;
    }

    public T peek() {
        if (isEmpty()) return null;
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

public class GenStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> integerStack = new Stack<>();

        // Read integers until non-integer input
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            integerStack.push(num);
        }

        // Perform integer stack operations
        System.out.println("Peek: " + integerStack.peek());
        System.out.println("Is Empty: " + integerStack.isEmpty());
        System.out.println("Pop: " + integerStack.pop());
        System.out.println("Pop: " + integerStack.pop());
        System.out.println("Is Empty: " + integerStack.isEmpty());

        // Clear the scanner buffer
        scanner.nextLine();

        // String stack
        Stack<String> stringStack = new Stack<>();
        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) break;
            stringStack.push(input);
        }

        // Perform string stack operations
        System.out.println("Peek: " + stringStack.peek());
        scanner.close();
    }
}