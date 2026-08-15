public class but
{
    public static void main(String[] args) 
    {
        // System.out.println("Hello, World!");
        int n = 10;
        for (int i = 0; i < n; i++) 
        {
            for(int j=0;j<=i;j++)
            {
                System.out.print("#");
            }
            for(int k=i;k<(n-1);k++)
            {
                System.out.print(" ");
            }
             for(int k=i;k<(n-1);k++)
            {
                System.out.print(" ");
            }
            for(int a=0;a<=i;a++)
            {
                System.out.print("#");

            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) 
        {
            for(int j=i;j<n;j++)
            {
                System.out.print("#");
            }
            for(int k=0;k<=i-1;k++)
            {
                System.out.print(" ");
            }
             for(int k=0;k<=i-1;k++)
            {
                System.out.print(" ");
            }
            for(int a=i;a<n;a++)
            {
                System.out.print("#");

            }
            System.out.println();
        }
        
            

            
    }
}
