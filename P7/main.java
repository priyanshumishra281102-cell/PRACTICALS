
class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

public class Practical7 {

    // Generic method
    public static <T> void display(T data) {
        System.out.println("Value: " + data);
    }

    // Bounded type parameter
    public static <T extends Number> double square(T num) {
        return num.doubleValue() * num.doubleValue();
    }

    // ? extends Number: reading numbers
    public static double sum(java.util.List<? extends Number> list) {
        double total = 0;
        for (Number n : list) {
            total += n.doubleValue();
        }
        return total;
    }

    // ? super Integer: adding integers
    public static void addIntegers(
            java.util.List<? super Integer> list) {
        list.add(10);
        list.add(20);
    }

    public static void main(String[] args) {
        Box<String> b1 = new Box<>();
        b1.set("Hello Java");

        Box<Integer> b2 = new Box<>();
        b2.set(100);

        System.out.println("String Box: " + b1.get());
        System.out.println("Integer Box: " + b2.get());

        display("Generics");
        display(25);
        display(5.5);

        System.out.println("Square of 5: " + square(5));

        java.util.List<Integer> nums =
                java.util.Arrays.asList(10, 20, 30);
        System.out.println("Sum: " + sum(nums));

        java.util.List<Number> result =
                new java.util.ArrayList<>();
        addIntegers(result);
        System.out.println("Added Integers: " + result);
    }
}

