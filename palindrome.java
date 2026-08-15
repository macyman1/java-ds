public class palindrome
{
    public static boolean pali(int n)
    {
        int onumber = n;
        int rnumber = 0;
        int digit;

        while(n>0)
        {
            digit = n % 10;
            rnumber = rnumber*10 + digit;
            n = n/10; 
        }

        return onumber==rnumber;

    }
    
    public static void main(String[] args) 
    {
        boolean a=pali(1211);
        System.out.println(a);

    }
}