import java.util.Scanner;
public class ques
{
    private static final int QUE = 5;
    private static final int[] arr = new int[QUE];

    
    Scanner sc = new Scanner(System.in);
    int front = -1, rear = -1;

    void input()
    {
        if(rear == QUE -1)
        {
            System.out.print("que is full");
        }
        else
        {
            System.out.println("Enter element of ques :");
            arr[++rear]= sc.nextInt();
            if(front == -1)
            {
                front = 0;
            }
        }
    }
    void delete()
    {
        if(front == -1 || front > rear)
        {
            System.out.println("Queue is empty");
        }
        else
        {
            System.out.println("Deleted element: " + arr[front]);
            front++;
        }
    }
    
    void display()
    {
        System.out.println("Elements in the queue are:");
        for(int i=front; i<=rear; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
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
                case 4 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice");
            }
        } while(choice != 4);
    }   
    
    public static void main(String[] args)
    {
        ques q = new ques();
        q.menu();
    }
}

