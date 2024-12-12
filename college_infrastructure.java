import java.util.ArrayList;
import java.util.Scanner;

// Base class for common details
class Person {
    String name;
    String id;

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Class for Students
class Student extends Person {
    String course;
    double fees;

    public Student(String name, String id, String course, double fees) {
        super(name, id);
        this.course = course;
        this.fees = fees;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Course: " + course);
        System.out.println("Fees: $" + fees);
    }
}

// Class for Staff
class Staff extends Person {
    String department;
    String role;

    public Staff(String name, String id, String department, String role) {
        super(name, id);
        this.department = department;
        this.role = role;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Department: " + department);
        System.out.println("Role: " + role);
    }
}

// Class for System Support
class SystemSupport {
    public void provideHelp() {
        System.out.println("For technical support, contact: admission@Paruluniversity.com or call 1800-123-1104");
    }
}

// Class for Security Details
class SecurityDetails {
    public void displaySecurityPolicies() {
        System.out.println("University Security Policies:");
        System.out.println("1. Two-factor authentication for all university accounts.");
        System.out.println("2. Regular security audits of all systems.");
        System.out.println("3. Strong password policies enforced.");
    }
}

// Class for Fees Section
class FeesSection {
    public void displayFeesPolicy() {
        System.out.println("University Fees Policies:");
        System.out.println("1. All fees must be paid by the end of the semester.");
        System.out.println("2. Late fees will incur a 5% penalty.");
        System.out.println("3. Scholarships and financial aid are available.");
    }
}

// Main class to run the system
public class UniversitySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sample data
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Staff> staffList = new ArrayList<>();

        students.add(new Student("Aditya singh", "2303031265281", "Cyber Security", 137000));
        students.add(new Student("Aman", "2303031267649", "Artificial intelligence", 137000));

        staffList.add(new Staff("VAISHALI", "T001", "Computer Science", "Professor"));
        staffList.add(new Staff("Rahul", "T002", "BBA", "Lab Assistant"));

        SystemSupport systemSupport = new SystemSupport();
        SecurityDetails securityDetails = new SecurityDetails();
        FeesSection feesSection = new FeesSection();

        // Menu
        int choice;
        do {
            System.out.println("\nUniversity Management System:");
            System.out.println("1. Show Student Details");
            System.out.println("2. Show Staff Details");
            System.out.println("3. System Support Help");
            System.out.println("4. Security Specifications");
            System.out.println("5. Fees Section");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nStudent Details:");
                    for (Student student : students) {
                        student.displayDetails();
                        System.out.println();
                    }
                    break;

                case 2:
                    System.out.println("\nStaff Details:");
                    for (Staff staff : staffList) {
                        staff.displayDetails();
                        System.out.println();
                    }
                    break;

                case 3:
                    systemSupport.provideHelp();
                    break;

                case 4:
                    securityDetails.displaySecurityPolicies();
                    break;

                case 5:
                    feesSection.displayFeesPolicy();
                    break;

                case 6:
                    System.out.println("Exiting the system.");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);

        sc.close();
    }
}