class Person {
    protected String name;

    Person(String name) {
        this.name = name;
        System.out.println("Person constructor called");
    }

    void displayName() {
        System.out.println("Name: " + name);
    }
}

class Student extends Person {
    protected int rollNo;

    Student(String name, int rollNo) {
        super(name);
        this.rollNo = rollNo;
        System.out.println("Student constructor called");
    }

    void displayStudent() {
        displayName();
        System.out.println("Roll No: " + rollNo);
    }
}

class Faculty extends Person {
    private String subject;

    Faculty(String name, String subject) {
        super(name);
        this.subject = subject;
    }

    void displayFaculty() {
        displayName();
        System.out.println("Subject: " + subject);
    }
}

// Multilevel inheritance
class ResearchStudent extends Student {
    private String topic;

    ResearchStudent(String name, int rollNo, String topic) {
        super(name, rollNo);
        this.topic = topic;
    }

    void displayResearch() {
        displayStudent();
        System.out.println("Research Topic: " + topic);
    }
}

public class Practical2 {
    public static void main(String[] args) {
        Student s = new Student("Riya", 101);
        s.displayStudent();

        System.out.println();

        Faculty f = new Faculty("Dr. Sharma", "Java");
        f.displayFaculty();

        System.out.println();

        ResearchStudent r =
                new ResearchStudent("Aman", 102, "AI");
        r.displayResearch();
    }
}
