import java.util.*;

class Teacher {
    String name;

    Teacher(String name) {
        this.name = name;
    }
}

class Department {
    String name;
    private List<Teacher> teachers = new ArrayList<>();

    Department(String name) {
        this.name = name;
    }

    // Composition-style ownership in this example
    void addTeacher(String name) {
        teachers.add(new Teacher(name));
    }

    void display() {
        System.out.println("Department: " + name);
        for (Teacher t : teachers) {
            System.out.println("Teacher: " + t.name);
        }
    }
}

class College {
    String name;
    private List<Department> departments;

    // Aggregation: existing departments are supplied
    College(String name, List<Department> departments) {
        this.name = name;
        this.departments = departments;
    }

    void display() {
        System.out.println("College: " + name);
        for (Department d : departments) {
            d.display();
        }
    }
}

class Course {
    String title;

    Course(String title) {
        this.title = title;
    }
}

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    // Association
    void enroll(Course course) {
        System.out.println(name + " enrolled in "
                + course.title);
    }
}

public class Practical5 {
    public static void main(String[] args) {
        Department d1 = new Department("Computer Science");
        Department d2 = new Department("Mathematics");

        d1.addTeacher("Mr. Kumar");
        d2.addTeacher("Ms. Singh");

        List<Department> list = new ArrayList<>();
        list.add(d1);
        list.add(d2);

        College c = new College("ABC College", list);
        c.display();

        Student s = new Student("Aman");
        Course course = new Course("Java Programming");
        s.enroll(course);
    }
}
