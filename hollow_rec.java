import java.util.Scanner;
public class hollow_rec
{
    public static void hollow(int r,int c)
    {
        for(int i=1;i<=r;i++)
        {
            for(int j=1;j<=c;j++)
            {
                if(i==1||i==r||j==1||j==c)
                {
                    System.out.print("*"); 
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) 
    {
            Scanner s = new Scanner(System.in);
            System.out.println("Enter the number of rows:");
            int r = s.nextInt();
            System.out.println("Enter the number of columns:");
            int c = s.nextInt();
            hollow(r, c);
            System.out.println("Hollow rectangle printed successfully.");
    }

          
    
}