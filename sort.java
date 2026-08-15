public class sort
{
    public static void selectionsort(int []arr)
    {
        for(int i=0;i<arr.length-1;i++)
        {
            int min = i; 
            for(int j=i+1;j<arr.length-1;j++)
            {
                if(arr[min] > arr[j])
                {
                    min = j;
                }

            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;

        }
    }
    public static void printarr(int []arr)
    {
        for(int i=0;i<arr.length;i++)
        {
                System.out.print(arr[i]+",");
        }
    }

    public static void main(String []args)
    {
        int []arr = {4,6,2,7,1,9};
        selectionsort(arr);
        printarr(arr);
    }
}