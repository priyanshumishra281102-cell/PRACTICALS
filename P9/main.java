
class GenericLinkedList<T> {

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public GenericLinkedList() {
        head = null;
        size = 0;
    }

    public void insert(T data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        size++;
    }

    public boolean delete(T data) {
        if (head == null) {
            return false;
        }

        if (java.util.Objects.equals(head.data, data)) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;

        while (current.next != null) {
            if (java.util.Objects.equals(current.next.data, data)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public boolean search(T data) {
        Node current = head;

        while (current != null) {
            if (java.util.Objects.equals(current.data, data)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public void display() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

public class Practical9 {
    public static void main(String[] args) {
        GenericLinkedList<Integer> numbers =
                new GenericLinkedList<>();

        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);

        System.out.print("Integer List: ");
        numbers.display();

        System.out.println("Search 20: " + numbers.search(20));

        numbers.delete(20);
        System.out.print("After deletion: ");
        numbers.display();

        System.out.println("Size: " + numbers.size());
        System.out.println("Is empty: " + numbers.isEmpty());

        System.out.println();

        GenericLinkedList<String> names =
                new GenericLinkedList<>();

        names.insert("Aman");
        names.insert("Riya");
        names.insert("Karan");

        System.out.print("String List: ");
        names.display();

        System.out.println("Search Riya: " + names.search("Riya"));

        names.delete("Aman");
        System.out.print("After deletion: ");
        names.display();

        System.out.println("Size: " + names.size());
    }
}

