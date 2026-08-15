public class maxsubarray
{
    public static void printsubarrays(int number[])
    {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[number.length];
        prefix[0] = number[0];  
        for(int i=1;i<number.length;i++)
        {
            prefix[i] = prefix[i-1] + number[i];
        }
        for(int i=0;i<number.length;i++)
        {
            for(int j=i;j<number.length;j++)
            {           
                currentSum = i == 0 ? prefix[j] : prefix[j] - prefix[i-1];
                if(currentSum > maxSum)
                {
                    maxSum = currentSum;
                }
                // System.out.println();   
            }
        }
        // System.out.println();   
        System.out.println("Maximum Subarray Sum is: " + maxSum);
    }

    public static void kaddans(int numbers[])
    {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0;i<numbers.length;i++)
        {
            currentSum += numbers[i];
            if(currentSum < 0)
            {
                currentSum = 0;
            }
            if(currentSum > maxSum)
            {
                maxSum = currentSum;
            }   
        }
        System.out.println("Maximum Subarray Sum is: " + maxSum);
    }
    
    
    public static void main(String []args)
        {
            int number[] = {11,2,13,9,5};
            printsubarrays(number);
            kaddans(number);
        }
}

