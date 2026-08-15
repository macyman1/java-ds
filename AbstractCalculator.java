// Abstract class Calculator
abstract class Calculator {
    protected int result;
    
    // Abstract method 1 - finds addition of two numbers
    abstract void sum2(int a, int b);
    
    // Abstract method 2 - finds addition of three numbers
    abstract void sum3(int a, int b, int c);
    
    // Non-abstract method - displays the result
    public void display() {
        System.out.println("Result: " + result);
    }
}

// Class Addition implementing abstract methods
class Addition extends Calculator {
    
    // Implementation of sum2() - adds two numbers
    @Override
    void sum2(int a, int b) {
        result = a + b;
        System.out.println("Sum of " + a + " and " + b + " = " + result);
    }
    
    // Implementation of sum3() - adds three numbers
    @Override
    void sum3(int a, int b, int c) {
        result = a + b + c;
        System.out.println("Sum of " + a + ", " + b + ", and " + c + " = " + result);
    }
}

// Main class to execute the program
public class AbstractCalculator {
    public static void main(String[] args) {
        
        System.out.println("===== ABSTRACT CLASS EXAMPLE =====\n");
        
        // Create object of Addition class
        // Note: Cannot create object of abstract class Calculator
        Addition calc = new Addition();
        
        System.out.println("--- Operation 1: Sum of Two Numbers ---");
        calc.sum2(10, 20);
        calc.display();
        
        System.out.println("\n--- Operation 2: Sum of Three Numbers ---");
        calc.sum3(5, 15, 25);
        calc.display();
        
        System.out.println("\n--- Operation 3: Another Sum of Two Numbers ---");
        calc.sum2(100, 50);
        calc.display();
        
        System.out.println("\n--- Operation 4: Another Sum of Three Numbers ---");
        calc.sum3(10, 20, 30);
        calc.display();
        
        System.out.println("\n===== KEY POINTS =====");
        System.out.println("1. Calculator is an abstract class");
        System.out.println("2. sum2() and sum3() are abstract methods");
        System.out.println("3. display() is a non-abstract method");
        System.out.println("4. Addition class implements both abstract methods");
        System.out.println("5. Cannot create object of abstract class");
        System.out.println("6. Can create object of concrete class (Addition)");
    }
}
