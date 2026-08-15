public class rombus
{
    public static void main(String[] args) 
    {
        int r=4,c=4;
        for (int i = 1; i <=r; i++) 
        {
            for(int a=i;a<=r;a++)
            {
                System.out.print(" ");
            }
            for (int j = 1; j <= c; j++) 
            {
                if(i==1||i==r||j==1||j==c)
                {
                    System.out.print("%");
                }    
                else
                {
                    System.out.print(" ");
                }
            }    
            System.out.println("");
        }

        
    }
}