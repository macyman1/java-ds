import java.util.Scanner;
public class cir_que
{
    private static final int QUE = 5;
    private static final int[] arr = new int[QUE];

    
    Scanner sc = new Scanner(System.in);
    int front = -1, rear = -1;
    

    void input()
    {
        if(rear == QUE-1 && front == 0)
        {
            System.out.println("Queue is full");
        }
        else
        {
            System.out.print("Enter element of queue: ");
            int element = sc.nextInt();
            
            if(front == -1)
            {
                front = 0;
                rear = 0;
            }
            else
            {
                rear = (rear + 1) % QUE;
            }
            
            arr[rear] = element;
            
            System.out.println("Element " + element + " added to queue");
        }
    } 
    void delete()
    {
        if(front == -1 && rear == -1)
        {
            System.out.println("Queue is empty");
        }
        else
        {
            System.out.println("Deleted element: " + arr[front]);
            
           if(rear == front)
           {
               front = -1;
               rear = -1;   
           }
            else
            {
                front = (front + 1) % QUE;
            }
            
        }
    }
    
    void display()
    {
        if(front == -1 && rear == -1)
        {
            System.out.println("Queue is empty");
        }
        else
        {
            System.out.println("Elements in the queue are:");
            int temp = front;
            for(int i = 0; i < QUE; i++)
            {
                System.out.print(arr[temp] + " ");
                temp = (temp + 1) % QUE;
            }
            System.out.println();
        }
    }

    void menu()
    {
        int choice;
        do
        {
            System.out.println("1. Input\n2. Delete\n3. Display\n4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> input();
                case 2 -> delete();
                case 3 -> display();
                case 4 -> System.out.println("Exit");
                default -> System.out.println("Invalid choice");
            }
        } while(choice != 4);
    }   
    
    public static void main(String[] args)
    {
        cir_que q = new cir_que();
        q.menu();
    }
}

