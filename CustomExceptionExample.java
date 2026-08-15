// Custom Exception Class 1 - for invalid age
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

// Custom Exception Class 2 - for invalid salary
class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String message) {
        super(message);
    }
}

// Custom Exception Class 3 - for invalid email
class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        super(message);
    }
}

// Employee class that uses custom exceptions
class Employee {
    private String name;
    private int age;
    private double salary;
    private String email;
    
    // Constructor with validation using custom exceptions
    public Employee(String name, int age, double salary, String email) 
            throws InvalidAgeException, InvalidSalaryException, InvalidEmailException {
        
        this.name = name;
        
        // Validate age
        if (age < 18 || age > 60) {
            throw new InvalidAgeException("Age must be between 18 and 60. You entered: " + age);
        }
        this.age = age;
        
        // Validate salary
        if (salary < 0) {
            throw new InvalidSalaryException("Salary cannot be negative. You entered: " + salary);
        }
        this.salary = salary;
        
        // Validate email
        if (!email.contains("@")) {
            throw new InvalidEmailException("Invalid email format. You entered: " + email);
        }
        this.email = email;
    }
    
    // Display employee details
    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
        System.out.println("Email: " + email);
    }
}

// Main class to demonstrate custom exceptions
public class CustomExceptionExample {
    public static void main(String[] args) {
        
        // Example 1: Valid employee
        System.out.println("--- Example 1: Creating Valid Employee ---");
        try {
            Employee emp1 = new Employee("John", 30, 50000, "john@gmail.com");
            emp1.displayDetails();
        } catch (InvalidAgeException | InvalidSalaryException | InvalidEmailException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("\n--- Example 2: Invalid Age (too young) ---");
        try {
            Employee emp2 = new Employee("Alice", 15, 40000, "alice@gmail.com");
            emp2.displayDetails();
        } catch (InvalidAgeException | InvalidSalaryException | InvalidEmailException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("\n--- Example 3: Invalid Salary (negative) ---");
        try {
            Employee emp3 = new Employee("Bob", 35, -5000, "bob@gmail.com");
            emp3.displayDetails();
        } catch (InvalidAgeException | InvalidSalaryException | InvalidEmailException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("\n--- Example 4: Invalid Email (no @) ---");
        try {
            Employee emp4 = new Employee("Charlie", 28, 60000, "charlie_gmail.com");
            emp4.displayDetails();
        } catch (InvalidAgeException | InvalidSalaryException | InvalidEmailException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("\n--- Example 5: Invalid Age (too old) ---");
        try {
            Employee emp5 = new Employee("David", 65, 70000, "david@gmail.com");
            emp5.displayDetails();
        } catch (InvalidAgeException | InvalidSalaryException | InvalidEmailException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

/*
===========================================
BASIC SYNTAX OF MAIN PROGRAM IN JAVA
===========================================

1. Class Declaration:
   public class ClassName {
   }

2. Main Method:
   public static void main(String[] args) {
   }

3. Try-Catch Block:
   try {
       // Code that may throw an exception
   } catch (ExceptionType e) {
       // Handle exception
   }

4. Creating Objects:
   ClassName obj = new ClassName(parameters);

5. Calling Methods:
   obj.methodName();

6. Print Output:
   System.out.println("message");

7. Throwing Exceptions:
   throw new CustomException("message");

COMPLETE SYNTAX EXAMPLE:
public class MyProgram {
    public static void main(String[] args) {
        try {
            // Create object
            ClassName obj = new ClassName();
            
            // Call method
            obj.methodName();
        } catch (CustomException e) {
            // Handle exception
            System.out.println("Error: " + e.getMessage());
        }
    }
}
*/
