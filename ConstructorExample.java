public class ConstructorExample {
    
    // Example class to demonstrate constructors
    static class Student {
        String name;
        int age;
        String course;
        double gpa;
        
        // 1. Default Constructor
        public Student() {
            this.name = "Unknown";
            this.age = 0;
            this.course = "Not Assigned";
            this.gpa = 0.0;
            System.out.println("Default constructor called");
        }
        
        // 2. Constructor with name only
        public Student(String name) {
            this.name = name;
            this.age = 18; // default age
            this.course = "Not Assigned";
            this.gpa = 0.0;
            System.out.println("Constructor with name called: " + name);
        }
        
        // 3. Constructor with name and age
        public Student(String name, int age) {
            this.name = name;
            this.age = age;
            this.course = "Not Assigned";
            this.gpa = 0.0;
            System.out.println("Constructor with name and age called: " + name + ", " + age);
        }
        
        // 4. Constructor with all parameters
        public Student(String name, int age, String course, double gpa) {
            this.name = name;
            this.age = age;
            this.course = course;
            this.gpa = gpa;
            System.out.println("Full constructor called: " + name + ", " + age + ", " + course + ", " + gpa);
        }
        
        // 5. Copy Constructor (copying from another Student object)
        public Student(Student other) {
            this.name = other.name;
            this.age = other.age;
            this.course = other.course;
            this.gpa = other.gpa;
            System.out.println("Copy constructor called for: " + name);
        }
        
        // Method to display student information
        public void display() {
            System.out.println("Student: " + name + ", Age: " + age + 
                             ", Course: " + course + ", GPA: " + gpa);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Constructor Examples ===\n");
        
        // 1. Using default constructor
        System.out.println("1. Default Constructor:");
        Student student1 = new Student();
        student1.display();
        System.out.println();
        
        // 2. Using constructor with name only
        System.out.println("2. Constructor with Name:");
        Student student2 = new Student("Alice");
        student2.display();
        System.out.println();
        
        // 3. Using constructor with name and age
        System.out.println("3. Constructor with Name and Age:");
        Student student3 = new Student("Bob", 20);
        student3.display();
        System.out.println();
        
        // 4. Using constructor with all parameters
        System.out.println("4. Full Constructor:");
        Student student4 = new Student("Charlie", 22, "Computer Science", 3.8);
        student4.display();
        System.out.println();
        
        // 5. Using copy constructor
        System.out.println("5. Copy Constructor:");
        Student student5 = new Student(student4); // Copy from student4
        student5.display();
        System.out.println();
        
        // Demonstrating constructor chaining with 'this'
        System.out.println("=== Constructor Chaining Example ===");
        @SuppressWarnings("unused")
        ChainExample chain = new ChainExample("David", 25);
    }
}

// Example of Constructor Chaining using 'this()'
class ChainExample {
    String name;
    int age;
    String department;
    
    // Default constructor
    public ChainExample() {
        this("Unknown", 0, "Not Assigned"); // Calls the 3-parameter constructor
        System.out.println("Default constructor executed");
    }
    
    // Constructor with name and age
    public ChainExample(String name, int age) {
        this(name, age, "General"); // Calls the 3-parameter constructor
        System.out.println("2-parameter constructor executed");
    }
    
    // Constructor with all parameters (this will be called by others)
    public ChainExample(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
        System.out.println("3-parameter constructor executed: " + name + ", " + age + ", " + department);
    }
}
