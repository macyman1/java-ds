
import static java.lang.System.identityHashCode;

public class StringExample
{
    public static void main(String[] args) 
    {
        String a1 = "word";
        System.out.println(a1);
        System.out.println(identityHashCode(a1));
        // a1 = "hello";
        System.out.println(a1);

        System.out.println(identityHashCode(a1));

    }
}