import java.util.Scanner;

public class insertionsort
{
    public static long insertionSort(int arr[])
    {
        long steps = 0;

        for(int i = 1; i < arr.length; i++)
        {
            int curr = arr[i];
            int prev = i - 1;
            steps++;

            while(prev >= 0)
            {
                steps++;
                if(arr[prev] > curr)
                {
                    arr[prev + 1] = arr[prev];
                    prev--;
                    steps++;
                }
                else
                {
                    break;
                }
            }

            arr[prev + 1] = curr;
            steps++;
        }

        return steps;
    }

    public static void print(int arr[])
    {
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i = 0; i < n; i++)
        {
            arr[i] = i + 1;
        }

        long startTime = System.nanoTime();
        long steps = insertionSort(arr);
        long endTime = System.nanoTime();

        double seconds = (endTime - startTime) / 1000000000.0;

        System.out.println("Step count: " + steps);
        System.out.println("Time in seconds: " + seconds);

        sc.close();
    }
}
