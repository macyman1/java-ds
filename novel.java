// Class novel implementing interface Book
public class novel implements Book {
    
    // Data members
    private String title;
    private String author;
    private int pages;
    private double price;
    private String genre;
    
    // Constructor
    public novel(String title, String author, int pages, double price, String genre) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
        this.genre = genre;
    }
    
    // Implementation of Display() method from Book interface
    @Override
    public void Display() {
        System.out.println("===== NOVEL DETAILS =====");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Pages: " + pages);
        System.out.println("Price: $" + price);
        System.out.println("Genre: " + genre);
        System.out.println("========================");
    }
    
    // Main method to execute the program
    public static void main(String[] args) {
        
        System.out.println("===== INTERFACE AND PACKAGE EXAMPLE =====\n");
        
        // Create objects of novel class
        novel book1 = new novel("The Great Gatsby", "F. Scott Fitzgerald", 180, 12.99, "Fiction");
        novel book2 = new novel("To Kill a Mockingbird", "Harper Lee", 281, 14.99, "Drama");
        novel book3 = new novel("1984", "George Orwell", 328, 13.99, "Science Fiction");
        
        // Call Display() method
        System.out.println("Book 1:");
        book1.Display();
        
        System.out.println("\nBook 2:");
        book2.Display();
        
        System.out.println("\nBook 3:");
        book3.Display();
        
        System.out.println("\n===== EXPLANATION =====");
        System.out.println("1. Book interface is in package 'pack1'");
        System.out.println("2. novel class is in package 'pack2'");
        System.out.println("3. novel class implements Book interface from pack1");
        System.out.println("4. Data members: title, author, pages, price, genre");
        System.out.println("5. Display() method shows all book details");
    }
}
