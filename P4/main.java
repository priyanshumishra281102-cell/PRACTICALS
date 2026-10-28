abstract class Employee {
    protected String name;

    Employee(String name) {
        this.name = name;
    }

    abstract double calculateSalary();

    void displayName() {
        System.out.println("Employee: " + name);
    }
}

interface Payable {
    void pay();
}

interface Printable {
    void printDetails();
}

class FullTimeEmployee extends Employee
        implements Payable, Printable {

    private double monthlySalary;

    FullTimeEmployee(String name, double salary) {
        super(name);
        monthlySalary = salary;
    }

    @Override
    double calculateSalary() {
        return monthlySalary;
    }

    @Override
    public void pay() {
        System.out.println("Salary paid: "
                + calculateSalary());
    }

    @Override
    public void printDetails() {
        displayName();
        System.out.println("Salary: "
                + calculateSalary());
    }
}

class PartTimeEmployee extends Employee {
    private int hours;
    private double rate;

    PartTimeEmployee(String name, int hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    double calculateSalary() {
        return hours * rate;
    }
}

public class Practical4 {
    public static void main(String[] args) {
        FullTimeEmployee e1 =
                new FullTimeEmployee("Aman", 30000);

        PartTimeEmployee e2 =
                new PartTimeEmployee("Riya", 40, 500);

        e1.printDetails();
        e1.pay();

        e2.displayName();
        System.out.println("Part-time Salary: "
                + e2.calculateSalary());
    }
}
