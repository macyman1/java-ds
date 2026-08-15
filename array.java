public class array
{
   void binar(int[] arr, int key)
    {
        int low = 0;
        int high = arr.length - 1;
        boolean found = false;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                found = true;
                System.out.println("Element found at index: " + mid);
                break;
            }
            else if (arr[mid] < key) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        if (!found) {
            System.out.println("Element not found in the array.");
        }
    }

    public static void main(String[] args) {
        array obj = new array();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int key = 5;
        obj.binar(arr, key);
    }

}