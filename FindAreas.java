// Parent class
class Figure {
    protected double dim1;
    protected double dim2;
    
    public Figure(double dim1, double dim2) {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }
    
    public double area() {
        System.out.println("Area calculation in Figure class");
        return 0;
    }
}

// Child class 1
class Rectangle extends Figure {
    public Rectangle(double length, double width) {
        super(length, width);
    }
    
    @Override
    public double area() {
        double result = dim1 * dim2;
        System.out.println("Rectangle area: " + result);
        return result;
    }
}

// Child class 2
class Triangle extends Figure {
    public Triangle(double base, double height) {
        super(base, height);
    }
    
    @Override
    public double area() {
        double result = (dim1 * dim2) / 2;
        System.out.println("Triangle area: " + result);
        return result;
    }
}

// Child class 3
class Circle extends Figure {
    public Circle(double radius) {
        super(radius, 0);
    }
    
    @Override
    public double area() {
        double result = 3.14 * dim1 * dim1;
        System.out.println("Circle area: " + result);
        return result;
    }
}

// Main class demonstrating dynamic method dispatch
public class FindAreas {
    public static void main(String[] args) {
        
        System.out.println("===== DYNAMIC METHOD DISPATCH WITH SINGLE REFERENCE =====\n");
        
        // Create parent class reference
        Figure figref;
        
        // Create child class objects
        Rectangle r = new Rectangle(9, 5);
        Triangle t = new Triangle(10, 8);
        Circle c = new Circle(7);
        
        // Using single reference to call different child methods
        System.out.println("--- Assigning Rectangle object ---");
        figref = r;
        figref.area();  // Calls Rectangle's area()
        
        System.out.println("\n--- Assigning Triangle object ---");
        figref = t;
        figref.area();  // Calls Triangle's area()
        
        System.out.println("\n--- Assigning Circle object ---");
        figref = c;
        figref.area();  // Calls Circle's area()
        
        System.out.println("\n===== EXPLANATION =====");
        System.out.println("figref is a reference of type: Figure (Parent)");
        System.out.println("But it stores different child objects: Rectangle, Triangle, Circle");
        System.out.println("When figref.area() is called:");
        System.out.println("  - At compile time: Compiler sees Figure reference");
        System.out.println("  - At runtime: Actual child's area() method is executed");
        System.out.println("\nThis is DYNAMIC METHOD DISPATCH!");
    }
}
