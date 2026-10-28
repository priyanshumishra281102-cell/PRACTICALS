
import java.util.*;

// Interface
interface Borrowable {
    void borrow();
}

// Abstraction
abstract class LibraryItem {
    private int id;
    private String title;

    public LibraryItem(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public abstract void display();
}

// Inheritance and polymorphism
class Book extends LibraryItem implements Borrowable {
    private String author;
    private boolean borrowed;

    public Book(int id, String title, String author) {
        super(id, title);
        this.author = author;
        this.borrowed = false;
    }

    @Override
    public void borrow() {
        if (borrowed) {
            throw new IllegalStateException(
                "Book already borrowed: " + getTitle());
        }

        borrowed = true;
        System.out.println("Borrowed: " + getTitle());
    }

    @Override
    public void display() {
        System.out.println(
            "ID: " + getId()
            + ", Title: " + getTitle()
            + ", Author: " + author
            + ", Borrowed: " + borrowed
        );
    }
}

// Generic repository
class Repository<T> {
    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public T get(int index) {
        if (index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException(
                "Invalid repository index");
        }

        return items.get(index);
    }

    public int size() {
        return items.size();
    }

    public List<T> getAll() {
        return Collections.unmodifiableList(items);
    }
}

// Queue ADT for borrowing requests
class RequestQueue<T> {
    private Queue<T> queue = new LinkedList<>();

    public void enqueue(T item) {
        queue.offer(item);
    }

    public T dequeue() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException(
                "No requests available");
        }

        return queue.remove();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

public class Practical10 {
    public static void main(String[] args) {
        Repository<Book> library = new Repository<>();

        Book b1 = new Book(1, "Java Programming", "James Gosling");
        Book b2 = new Book(2, "Data Structures", "Mark Allen");

        library.add(b1);
        library.add(b2);

        System.out.println("Library Books:");
        for (Book book : library.getAll()) {
            book.display();
        }

        System.out.println("\nBorrowing Book:");
        try {
            Borrowable item = library.get(0);
            item.borrow();

            // Demonstrate exception handling
            item.borrow();
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nBorrowing Request Queue:");
        RequestQueue<String> requests = new RequestQueue<>();

        requests.enqueue("Aman");
        requests.enqueue("Riya");
        requests.enqueue("Karan");

        while (!requests.isEmpty()) {
            System.out.println(
                "Processing request: " + requests.dequeue());
        }

        System.out.println("\nTotal books: " + library.size());

        // Demonstrate invalid index handling
        try {
            library.get(10);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

