
class MyStack {
    private int[] arr;
    private int top;
    private int capacity;

    public MyStack(int size) {
        capacity = size;
        arr = new int[size];
        top = -1;
    }

    public void push(int value) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow!");
            return;
        }
        arr[++top] = value;
        System.out.println("Pushed: " + value);
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow!");
            return -1;
        }
        return arr[top--];
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void display() {
        System.out.print("Stack: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

class MyQueue {
    private int[] arr;
    private int front, rear, size, capacity;

    public MyQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int value) {
        if (size == capacity) {
            System.out.println("Queue Overflow!");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = value;
        size++;
        System.out.println("Enqueued: " + value);
    }

    public int dequeue() {
        if (size == 0) {
            System.out.println("Queue Underflow!");
            return -1;
        }
        int value = arr[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    public int front() {
        if (size == 0) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return arr[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
}

public class Practical8 {
    public static void main(String[] args) {
        MyStack stack = new MyStack(3);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        stack.display();
        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        stack.display();

        System.out.println();

        MyQueue queue = new MyQueue(3);

        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);
        queue.enqueue(400);

        queue.display();
        System.out.println("Front element: " + queue.front());
        System.out.println("Dequeued: " + queue.dequeue());
        queue.display();
    }
}

