import java.util.Scanner;
public class Linkedlist {
    //basic structure of a node
    public class Node {
        int data;
        Node next;  // Reference to next node (no * in Java)
    }
    
    // Function to create a new node
    public Node createNode(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        return newNode;
    }


    // Head reference to point to the first node
    Node head;
    
    // Constructor to initialize empty list
    public Linkedlist() {
        this.head = null;
    }
    
    // Method to insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = createNode(data);
        newNode.next = head;
        head = newNode;
        System.out.println("Inserted " + data + " at beginning");
    }
    
    // Method to insert at the end
    public void insertAtEnd(int data) {
        Node newNode = createNode(data);
        
        if (head == null) 
        {
            head = newNode;
        } 
        else 
        {
            Node current = head;
            while (current.next != null) 
            {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Inserted " + data + " at end");
    }
    
    // Method to insert at a specific position
    public void insertAtPosition(int data, int position) {
        if (position == 0) {
            insertAtBeginning(data);
            return;
        }
        
        Node newNode = createNode(data);
        Node current = head;
        
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        
        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }
        
        newNode.next = current.next;
        current.next = newNode;
        System.out.println("Inserted " + data + " at position " + position);
    }
    
    // Method to delete a node by value
    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        // If head node contains the data to be deleted
        if (head.data == data) {
            head = head.next;
            System.out.println("Deleted " + data);
            return;
        }
        
        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
        
        if (current.next == null) {
            System.out.println(data + " not found in the list");
        } else {
            current.next = current.next.next;
            System.out.println("Deleted " + data);
        }
    }
    
    // Method to search for a value
    public boolean search(int data) {
        Node current = head;
        int position = 0;
        
        while (current != null) {
            if (current.data == data) {
                System.out.println(data + " found at position " + position);
                return true;
            }
            current = current.next;
            position++;
        }
        
        System.out.println(data + " not found in the list");
        return false;
    }
    
    // Method to display the linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        System.out.print("Linked List: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println(" -> null");
    }
    
    // Method to get the size of the linked list
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    // Method to reverse the linked list
    public void reverse() {
        Node previous = null;
        Node current = head;
        Node next;
        
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        
        head = previous;
        System.out.println("List reversed");
    }
    
    public static void main(String[] args) 
    {
        // Create a new linked list
        Linkedlist list = new Linkedlist();
        
        // Test various operations
        int choice;
        Scanner sc = new Scanner(System.in);
        while (true) {
        System.out.println("1. Insert at Beginning\n2. Insert at End\n3. Insert at Position\n4. Delete\n5. Search\n6. Display\n7. Size\n8. Reverse\n9. Exit ");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter value to insert at beginning: ");
                    int value1 = sc.nextInt();
                    list.insertAtBeginning(value1);
                }
                case 2 -> {
                    System.out.print("Enter value to insert at end: ");
                    int value2 = sc.nextInt();
                    list.insertAtEnd(value2);
                }
                case 3 -> {
                    System.out.print("Enter value and position to insert: ");
                    int value3 = sc.nextInt();
                    int position = sc.nextInt();
                    list.insertAtPosition(value3, position);
                }
                case 4 -> {
                    System.out.print("Enter value to delete: ");
                    int value4 = sc.nextInt();
                    list.delete(value4);
                }
                case 5 -> {
                    System.out.print("Enter value to search: ");
                    int value5 = sc.nextInt();
                    list.search(value5);
                }
                case 6 -> {
                    list.display();
                }
                case 7 -> {
                    System.out.println("Size of list: " + list.size());
                }
                case 8 -> {
                    list.reverse();
                }
                case 9 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}