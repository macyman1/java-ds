public class binary_to_decimal
{
    public static void deci(int bnum)
    {
        int pow=0;
        int d = 0;
        while(bnum>0)
        {
            int lastd = bnum%10;

            d = d + ( lastd * (int)Math.pow(2,pow));
            pow++;
            bnum = bnum/10;
        }
        System.out.print("decimal of given binary is "+ d);

     
    }
    public static void bina(int n)
    {
        int pow = 0;
        int binnum = 0;
        

        while(n > 0)
        {
            int rem = n%2;

            binnum = binnum + (rem*(int)Math.pow(10,pow));
            pow++;
            n=n/2;

        }

        System.out.println("binary nuber is "+binnum);
    }

    public static void main(String[] args) 
    {
        bina(5);
    }
}