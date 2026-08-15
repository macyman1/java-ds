// Parent class
class Animal {
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

// Child class 1
class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks: Woof Woof!");
    }
}

// Child class 2
class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Cat meows: Meow Meow!");
    }
}

// Child class 3
class Cow extends Animal {
    @Override
    public void sound() {
        System.out.println("Cow moos: Moo Moo!");
    }
}

// Main class
public class SimpleDynamicDispatch {
    public static void main(String[] args) {
        
        System.out.println("===== DYNAMIC METHOD DISPATCH USING REFERENCES =====\n");
        
        // Create an array of Animal references (parent class)
        Animal[] animals = new Animal[3];
        
        // Store different child objects in the parent reference array
        animals[0] = new Dog();
        animals[1] = new Cat();
        animals[2] = new Cow();
        
        System.out.println("--- Using Loop with References ---");
        // Same method call in loop, different output at runtime
        for (int i = 0; i < animals.length; i++) {
            System.out.println("Animal " + (i + 1) + ":");
            animals[i].sound();  // Calls the appropriate child's sound() method
        }
        
        System.out.println("\n===== REFERENCE EXPLANATION =====");
        System.out.println("animals[0] reference type: Animal");
        System.out.println("animals[0] actual object: Dog");
        System.out.println("animals[0].sound() calls: Dog's sound() method\n");
        
        System.out.println("animals[1] reference type: Animal");
        System.out.println("animals[1] actual object: Cat");
        System.out.println("animals[1].sound() calls: Cat's sound() method\n");
        
        System.out.println("animals[2] reference type: Animal");
        System.out.println("animals[2] actual object: Cow");
        System.out.println("animals[2].sound() calls: Cow's sound() method\n");
        
        System.out.println("===== KEY POINT =====");
        System.out.println("All references are of type 'Animal' but");
        System.out.println("actual object types are different!");
        System.out.println("Method call is resolved at RUNTIME = DYNAMIC DISPATCH");
    }
}
