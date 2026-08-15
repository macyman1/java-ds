// Interface 1
interface Animal {
    void eat();
    void sleep();
}

// Interface 2
interface Vehicle {
    void drive();
    void stop();
}

// Interface 3
interface Worker {
    void work();
    void takeBreak();
}

// Class implementing MULTIPLE interfaces
// This shows multiple inheritance in Java
class Dog implements Animal, Vehicle, Worker {
    private String name;
    
    public Dog(String name) {
        this.name = name;
    }
    
    // Implementation from Animal interface
    @Override
    public void eat() {
        System.out.println(name + " is eating dog food");
    }
    
    @Override
    public void sleep() {
        System.out.println(name + " is sleeping");
    }
    
    // Implementation from Vehicle interface
    @Override
    public void drive() {
        System.out.println(name + " is driving the car");
    }
    
    @Override
    public void stop() {
        System.out.println(name + " stopped the car");
    }
    
    // Implementation from Worker interface
    @Override
    public void work() {
        System.out.println(name + " is working hard");
    }
    
    @Override
    public void takeBreak() {
        System.out.println(name + " is taking a break");
    }
}

// Main class to demonstrate multiple inheritance
public class MultipleInheritanceInterface {
    public static void main(String[] args) {
        
        // Create object of Dog class
        Dog dog = new Dog("Buddy");
        
        System.out.println("========== MULTIPLE INHERITANCE WITH INTERFACES ==========\n");
        
        // Call methods from Animal interface
        System.out.println("--- From Animal Interface ---");
        dog.eat();
        dog.sleep();
        
        // Call methods from Vehicle interface
        System.out.println("\n--- From Vehicle Interface ---");
        dog.drive();
        dog.stop();
        
        // Call methods from Worker interface
        System.out.println("\n--- From Worker Interface ---");
        dog.work();
        dog.takeBreak();
        
        System.out.println("\n========== KEY POINTS ==========");
        System.out.println("1. Dog class implements 3 interfaces (multiple inheritance)");
        System.out.println("2. Dog has methods from all 3 interfaces");
        System.out.println("3. A class can implement multiple interfaces but can extend only 1 class");
        System.out.println("4. This is how Java achieves multiple inheritance");
    }
}
