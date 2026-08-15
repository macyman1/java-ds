public class triangle0_1
{
    public static void main(String[] args) 
    {
        int r = 5; // number of rows
        // int c = 5; // number of columns

        for(int i=0;i<r;i++)
        {
            for(int j=0;j<=i;j++)
            {
                if((i+j) % 2 == 0)
                {
                    System.out.print("1 ");
                }
                else
                {
                    System.out.print("0 ");
                }
                
            }
            System.out.println();
        }
    }   
}