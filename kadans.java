public class kadans
{
    
    public static void kadansalgo(int[] number)
    {
        int ms = Integer.MIN_VALUE;
        int cs = 0;
        for(int i=0;i<number.length;i++)
        {
            cs = cs + number[i];
            if(cs < 0)
            {
                cs =0 ;
            }
            ms = Math.max(ms,cs);
                
        }
        System.out.println("Maximum subarray sum is: " + ms);
    }
    public static void main(String[] args) 
    {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        kadansalgo(nums);
    }
        
}