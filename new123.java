import java.util.Scanner;

public class new123
{
    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);
        int choice;

        System.out.println("-----------------------------------------------");
        System.out.print("Enter a: ");
        int a1 = s.nextInt();
        System.out.print("Enter b: ");
        int b1 = s.nextInt();

        System.out.println("1.sum \n2.subtraction \n3.multiplication \n4.division");
        choice = s.nextInt();

        switch (choice) 
        {
            case 1 -> System.out.print("the sum of the a and b is "+(a1+b1));
            case 2 -> System.out.println("The subtraction of the a and b is "+(a1-b1));
            case 3 -> System.out.println("The multiplication of the a and b is "+(a1*b1));
            case 4 -> System.out.println("The division of the a and b is "+(a1/b1));
            default -> System.out.println("invalid! please Enter valid answer");
        }
    }
}

       
