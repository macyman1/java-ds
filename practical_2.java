import java.util.Arrays;
import java.util.Scanner;

public class practical_2
{
    int data[];

        
    public practical_2()
    {
        data = new int[10];
        System.out.println("The array of size 10 is created. :)");
    }

    public practical_2(int[] data) 
    {
        this.data = data;
        System.out.println("The array of size "+data.length+" is created");
    }
    public practical_2(int size)
    {
        data = new int[size];
        System.out.println("The array of size "+size+" created");
    }
    public void reverse()
    {
        int temp[] = new int[data.length];
        for(int i=0;i<data.length;i++)
        {
            temp[data.length-1-i] = data[i];
        }
        System.arraycopy(temp, 0, data, 0, data.length);
            
    }
    public void display()
    {
        for (int i = 0; i < data.length; i++) 
        {
            System.out.println(data[i]);
        }
    }
    public int maximum()
    {
        int max = data[0];
        for (int i = 0; i < data.length; i++) 
        {
            if(data[i]>max)
            {
                max = data[i];
            }
        }
        return max;
    }
    public int avg()
    {
        int sum  = 0;
        for(int i=0;i<data.length;i++)
        {
            sum = sum + data[i];
        }
        return (sum/data.length);
    }
    public int search(int value)
    {
        for(int i=0;i<data.length;i++)
        {
            if(value==data[i])
            {
                return i;
            }
        }
        return -1;
    }
    public void sorting()
    {
        Arrays.sort(data);
    }
    public int size()
    {
        return data.length;
    }
}

@SuppressWarnings("unused")
class main
{
    public static void main(String[] args) 
    {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the size of array: ");
            int size = sc.nextInt();
            practical_2 arr = new practical_2(size);
            
            System.out.println("\nEnter " + size + " elements:");
            for(int i = 0; i < size; i++)
            {
                System.out.print("Element " + (i+1) + ": ");
                arr.data[i] = sc.nextInt();
            }
            
            System.out.println("\n=== Menu ===");
            System.out.println("1. Display Array");
            System.out.println("2. Find Maximum");
            System.out.println("3. Find Average");
            System.out.println("4. Search Element");
            System.out.println("5. Sort Array");
            System.out.println("6. Reverse Array");
            System.out.println("7. Get Array Size");
            
            boolean running = true;
            while(running)
            {
                System.out.print("\nEnter your choice (1-7): ");
                int choice = sc.nextInt();
                
                switch(choice)
                {
                    case 1 -> {
                        System.out.println("\nArray Elements:");
                        arr.display();
                    }
                    
                    case 2 -> System.out.println("\nMaximum Element: " + arr.maximum());
                    
                    case 3 -> System.out.println("\nAverage: " + arr.avg());
                    
                    case 4 -> {
                        System.out.print("Enter element to search: ");
                        int searchVal = sc.nextInt();
                        int pos = arr.search(searchVal);
                        if(pos != -1)
                            System.out.println("Element found at index: " + pos);
                        else
                            System.out.println("Element not found");
                    }
                    
                    case 5 -> {
                        arr.sorting();
                        System.out.println("Array sorted successfully!");
                    }
                    
                    case 6 -> {
                        arr.reverse();
                        System.out.println("Array reversed successfully!");
                    }
                    
                    case 7 -> System.out.println("Array Size: " + arr.size());
                    
                    default -> {
                        System.out.println("Invalid choice! Exiting...");
                        running = false;
                    }
                }
            }
        }
    }
}