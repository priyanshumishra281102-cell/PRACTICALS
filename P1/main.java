class Student {
    private int rollNo;
    private String name;
    private double marks;

    // Default constructor
    Student() {
        rollNo = 12;
        name = "Aman";
        marks = 86
        ;
    }

    // Parameterized constructor
    Student(int rollNo, String name, double marks) {
        this.rollNo = rollNo;
        setName(name);
        setMarks(marks);
    }

    // Getters
    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    // Setters with validation
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public void setMarks(double marks) {
        if (marks >= 0 && marks <= 100) {
            this.marks = marks;
        } else {
            System.out.println("Invalid marks!");
        }
    }

    void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
    }
}

public class Practical1 {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student(101, "Aman", 85.5);

        System.out.println("Default Student:");
        s1.display();

        System.out.println("\nParameterized Student:");
        s2.display();

        s2.setMarks(105);
        System.out.println("Marks after invalid update: "
                + s2.getMarks());
    }
}

