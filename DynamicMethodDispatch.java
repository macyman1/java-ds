// Parent class (Superclass)
class Shape {
    public void draw() {
        System.out.println("Drawing a generic shape");
    }
    
    public void calculateArea() {
        System.out.println("Calculating area of a generic shape");
    }
}

// Child class 1
class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a Circle with radius: " + radius);
    }
    
    @Override
    public void calculateArea() {
        double area = 3.14 * radius * radius;
        System.out.println("Area of Circle: " + area);
    }
}

// Child class 2
class Rectangle extends Shape {
    private double length;
    private double width;
    
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle with length: " + length + " and width: " + width);
    }
    
    @Override
    public void calculateArea() {
        double area = length * width;
        System.out.println("Area of Rectangle: " + area);
    }
}

// Child class 3
class Triangle extends Shape {
    private double base;
    private double height;
    
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a Triangle with base: " + base + " and height: " + height);
    }
    
    @Override
    public void calculateArea() {
        double area = (base * height) / 2;
        System.out.println("Area of Triangle: " + area);
    }
}

// Main class demonstrating Dynamic Method Dispatch
public class DynamicMethodDispatch {
    public static void main(String[] args) {
        
        System.out.println("========== DYNAMIC METHOD DISPATCH EXAMPLE ==========\n");
        
        // Create an array of Shape references
        Shape[] shapes = new Shape[3];
        
        // Store different objects (Circle, Rectangle, Triangle) in Shape references
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(4, 6);
        shapes[2] = new Triangle(5, 8);
        
        System.out.println("--- Dynamic Method Dispatch in Action ---\n");
        
        // Loop through and call methods
        // The actual method called is determined at RUNTIME based on the object type
        for (int i = 0; i < shapes.length; i++) {
            System.out.println("Shape " + (i + 1) + ":");
            shapes[i].draw();              // Calls the overridden draw() method
            shapes[i].calculateArea();     // Calls the overridden calculateArea() method
            System.out.println();
        }
        
        System.out.println("========== KEY POINTS ==========");
        System.out.println("1. Shape is the parent class (superclass)");
        System.out.println("2. Circle, Rectangle, Triangle extend Shape");
        System.out.println("3. All are stored in Shape[] array (parent reference)");
        System.out.println("4. At compile time: Compiler sees Shape reference");
        System.out.println("5. At runtime: Actual method of the object is called");
        System.out.println("6. This is DYNAMIC METHOD DISPATCH (Runtime Polymorphism)");
        
        System.out.println("\n========== EXPLANATION ==========");
        System.out.println("When shapes[0].draw() is called:");
        System.out.println("  - Reference type is: Shape");
        System.out.println("  - Actual object type is: Circle");
        System.out.println("  - Circle's draw() method is executed");
        System.out.println("\nThis decision is made at RUNTIME, not compile time!");
    }
}
