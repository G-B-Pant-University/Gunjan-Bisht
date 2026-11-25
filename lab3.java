class Employee {

    String emailId;
    String name;
    String department;

    Employee(String emailId, String name, String department) {
        this.emailId = emailId;
        this.name = name;
        this.department = department;
    }

    void display() {
        System.out.println("Email ID: " + emailId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
    }

    double calculateSalary() {
        return 0.0;
    }
}

class FullTimeEmployee extends Employee {

    double basicSalary;
    double bonus;

    FullTimeEmployee(String emailId, String name, String department,
                     double basicSalary, double bonus) {

        super(emailId, name, department);
        this.basicSalary = basicSalary;
        this.bonus = bonus;
    }

    @Override
    double calculateSalary() {
        return basicSalary + bonus;
    }

    @Override
    void display() {
        super.display();
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Bonus: " + bonus);
        System.out.println("Total Salary: " + calculateSalary());
    }
}

class PartTimeEmployee extends Employee {

    int hoursWorked;
    double hourlyRate;

    PartTimeEmployee(String emailId, String name, String department,
                     int hoursWorked, double hourlyRate) {

        super(emailId, name, department);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    @Override
    void display() {
        super.display();
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Hourly Rate: " + hourlyRate);
        System.out.println("Total Salary: " + calculateSalary());
    }
}

public class lab3 {

    public static void main(String[] args) {

        Employee e1 = new FullTimeEmployee(
            "Riya@gmail.com", "Riya", "IT", 30000, 5000
        );

        Employee e2 = new PartTimeEmployee(
            "Raman@gmail.com", "Raman", "Support", 80, 200
        );

        System.out.println("Full-Time Employee Details:");
        e1.display();

        System.out.println("\nPart-Time Employee Details:");
        e2.display();
    }
}
