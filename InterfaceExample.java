// Interface definition with 3 methods
interface Animal {
    void eat();
    void sleep();
    void makeSound();
}

// Class implementing the interface
class Dog implements Animal {
    private String name;
    
    public Dog(String name) {
        this.name = name;
    }
    
    // Implementation of eat() method
    @Override
    public void eat() {
        System.out.println(name + " is eating dog food");
    }
    
    // Implementation of sleep() method
    @Override
    public void sleep() {
        System.out.println(name + " is sleeping on the bed");
    }
    
    // Implementation of makeSound() method
    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof Woof!");
    }
}

// Another class implementing the same interface
class Cat implements Animal {
    private String name;
    
    public Cat(String name) {
        this.name = name;
    }
    
    @Override
    public void eat() {
        System.out.println(name + " is eating cat food");
    }
    
    @Override
    public void sleep() {
        System.out.println(name + " is sleeping in the sun");
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow Meow!");
    }
}

// Main class to demonstrate interface usage
public class InterfaceExample {
    public static void main(String[] args) {
        // Create objects of classes implementing the interface
        Animal dog = new Dog("Buddy");
        Animal cat = new Cat("Whiskers");
        
        // Call methods using interface reference
        System.out.println("--- Dog Behavior ---");
        dog.eat();
        dog.sleep();
        dog.makeSound();
        
        System.out.println("\n--- Cat Behavior ---");
        cat.eat();
        cat.sleep();
        cat.makeSound();
    }
}
