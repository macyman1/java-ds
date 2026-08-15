import java.util.Scanner;
// import java.util.Stack;

public class lab 
{
    private static final int STACK_SIZE = 100;
    
    public static void main(String[] args) 
    {
        int top = -1;
        int[] stack = new int[STACK_SIZE];
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("1.push");
        System.out.println("2.pop");
        System.out.println("3.peek");
        System.out.println("4.display");
        System.out.println("5.exit");
        System.out.println("Enter your choice:");
        choice = sc.nextInt();

        while (choice != 5) 
        {
            switch (choice)
            {
                case 1: // push
                    if (top < STACK_SIZE - 1) 
                    {
                        System.out.println("Enter the element to push:");
                        int element = sc.nextInt();
                        stack[++top] = element;
                        System.out.println("Element pushed: " + element);
                    } 
                    else 
                    {
                        System.out.println("Stack overflow");
                    }
                    break;

                case 2: // pop
                    if (top >= 0) 
                    {
                        int poppedElement = stack[top--];
                        System.out.println("Element popped: " + poppedElement);
                    } 
                    else 
                    {
                        System.out.println("Stack underflow");
                    }
                    break;

                case 3: // peek
                    if (top >= 0) 
                    {
                        System.out.println("Top element is: " + stack[top]);
                    } 
                    else 
                    {
                        System.out.println("Stack is empty");
                    }
                    break;

                case 4: // display
                    if (top >= 0) 
                    {
                        System.out.print("Stack elements: ");
                        for (int i = 0; i <= top; i++) 
                        {
                            System.out.print(stack[i] + " ");
                        }
                        System.out.println();
                    } 
                    else 
                    {
                        System.out.println("Stack is empty");
                    }
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }

            System.out.println("\n1.push");
            System.out.println("2.pop");
            System.out.println("3.peek");
            System.out.println("4.display");
            System.out.println("5.exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
        }

        sc.close();
    }
}
