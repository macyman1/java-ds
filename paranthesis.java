
//first read input string and push all oopening parentheses onto the stack and pop them when a closing parenthesis is encountered
//skip operands, dont save them in the stack
import java.util.Scanner;

public class paranthesis
{
    private static final int s = 100;
    public static void main(String[] args)
    {
        int[] stack = new int[s];
        int top = -1;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string of parentheses:");
        String input = sc.nextLine();

        boolean isValid = true;
        for (char ch : input.toCharArray()) 
        {
            if (ch == '('||ch == '{'||ch == '['||ch == '<') 
            {
                if (top < s - 1) 
                {
                    stack[++top] = ch; 
                } 
                else 
                {
                    isValid = false; 
                    break;
                }
            } 
            else if (ch == ')'||ch == '}'||ch == ']'||ch == '>') 
            {
                if (top >= 0) 
                {
                    top--;
                } 
                else 
                {
                    isValid = false;
                    break;
                }
            }
            
        }

        if (isValid && top == -1) 
        {
            System.out.println("The parentheses are balanced.");
        } 
        else 
        {
            System.out.println("The parentheses are not balanced.");
        }
    }

    public static int getS() {
        return s;
    }

    
        
}