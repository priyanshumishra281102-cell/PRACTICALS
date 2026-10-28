class Shape {
    void draw() {
        System.out.println("Drawing a shape");
    }

    // Method overloading
    int area(int side) {
        return side * side;
    }

    int area(int length, int breadth) {
        return length * breadth;
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

public class Practical3 {
    public static void main(String[] args) {
        Shape s = new Shape();

        System.out.println("Square Area: " + s.area(5));
        System.out.println("Rectangle Area: "
                + s.area(4, 6));

        Shape shape;

        shape = new Circle();
        shape.draw();

        shape = new Rectangle();
        shape.draw();
    }
}
