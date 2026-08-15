// Parent class A
class A {
    // Instance variable to store age
    int age;
    String name;

    // Constructor that accepts age as parameter
    A(int age){
        this.age = age;  // Store the age value in this object
        this.name = "Parent";
        System.out.println("Hello from A! Age set to: " + age);  // Print greeting with age
    }
    
    // Method in parent class
    void displayInfo() {
        System.out.println("Parent - Name: " + name + ", Age: " + age);
    }
}

// Child class B inherits from class A
class B extends A {
    // Constructor for class B
    B(int age) {
        super(age);  // Call parent class A's constructor with age
        System.out.println("B constructor executed. Parent age is: " + this.age);
    }
    
    // Method to access parent variables using super
    void accessParentVariables() {
        System.out.println("\n=== Accessing Parent Variables ===");
        System.out.println("Using this.age: " + this.age);  // Access inherited variable
        System.out.println("Using super.age: " + super.age);  // Explicitly use super (same result)
        System.out.println("Using this.name: " + this.name);
        System.out.println("Using super.name: " + super.name);
    }
    
    // Method to modify parent variables
    void modifyParentVariables() {
        System.out.println("\n=== Modifying Parent Variables ===");
        super.age = 50;  // Modify parent's age using super
        super.name = "Child Modified";  // Modify parent's name using super
        System.out.println("After modification - super.age: " + super.age);
        System.out.println("After modification - super.name: " + super.name);
    }
    
    // Override parent method and call it using super
    void displayInfo() {
        System.out.println("\n=== Parent vs Child Method ===");
        super.displayInfo();  // Call parent's displayInfo method
        System.out.println("Child - Age: " + this.age);
    }
}

// Main class with examples
class demo {
    // Program entry point
    public static void main(String[] args){
        System.out.println("=== Example 1: Creating B with age 25 ===");
        B b1 = new B(25);  
        
        System.out.println("\n=== Example 2: Access parent variables ===");
        b1.accessParentVariables();
        
        System.out.println("\n=== Example 3: Modify parent variables ===");
        b1.modifyParentVariables();
        
        System.out.println("\n=== Example 4: Call parent method ===");
        b1.displayInfo();
    }
}