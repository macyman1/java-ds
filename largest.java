public class largest
{
    public static void main(String[] args)
    {
        int[] array = {10,12,156,20,25};
        int largest=array[0];
        for(int i=0;i<array.length;i++)
        {
            if(array[i] > largest)
            {
                largest = array[i];
            }
        }
    
        System.out.println("Largest element is: " + largest);
        // Note: The above code will throw an ArrayIndexOutOfBoundsException
        // because it tries to access array[i+1] when i is at the last index.
        // To fix this, we should iterate only up to array.length - 1.
        
        
    }
}