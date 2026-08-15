public class inverted
{
    public static void main(String[] args) 
    {
        int row =5,a=1;
        for(int i = 0;i<row;i++)
        {
            // for(int j=i;j<row;j++)
            // {
            //     System.out.print(" ");
            // }

            for(int k=0;k<i;k++)
            {
                System.out.print(" " + a + " ");
                a++;
            }
            System.out.println();
        }

    }
}