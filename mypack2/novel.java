package mypack2;

import mypack1.Book;  // Import interface from mypack1

// Class novel in package mypack2 implementing interface Book from mypack1
public class novel implements Book {
    
    private String title;
    private String author;
    private int year;
    
    public novel(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
    
    @Override
    public void Display() {
        System.out.println("===== NOVEL DETAILS =====");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year: " + year);
    }
    
    @Override
    public void getDetails() {
        System.out.println(title + " by " + author + " (" + year + ")");
    }
    
    public static void main(String[] args) {
        
        System.out.println("===== FILES IN SUBFOLDERS EXAMPLE =====\n");
        
        System.out.println("Book 1:");
        novel book1 = new novel("Pride and Prejudice", "Jane Austen", 1813);
        book1.Display();
        book1.getDetails();
        
        System.out.println("\nBook 2:");
        novel book2 = new novel("The Hobbit", "J.R.R. Tolkien", 1937);
        book2.Display();
        book2.getDetails();
        
        System.out.println("\nBook 3:");
        novel book3 = new novel("Dune", "Frank Herbert", 1965);
        book3.Display();
        book3.getDetails();
        
        System.out.println("\n===== FOLDER STRUCTURE =====");
        System.out.println("/home/mightbe/java ds/");
        System.out.println("├── mypack1/");
        System.out.println("│   └── Book.java (interface)");
        System.out.println("└── mypack2/");
        System.out.println("    └── novel.java (class)");
        
        System.out.println("\n===== HOW IT WORKS =====");
        System.out.println("1. Book.java is in subfolder mypack1 with 'package mypack1;'");
        System.out.println("2. novel.java is in subfolder mypack2 with 'package mypack2;'");
        System.out.println("3. novel imports Book: 'import mypack1.Book;'");
        System.out.println("4. novel implements the Book interface");
        System.out.println("5. Both files are in subfolders of /home/mightbe/java ds/");
    }
}
