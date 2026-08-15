import java.util.Scanner;
import java.util.Stack;



public class infix
{
    public static int prec(char c)
    {
        return switch (c) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> -1;
        };
    }
    public static String infixtopostfix(String s)
    {
         Stack<Character> st = new Stack<>();
         String res = "";
         char[] ch = s.toCharArray();
        for(int i=0;i<s.length();i++)
        {
            if(ch[i]>='a' && ch[i]<='z')
            {
                res+=ch[i];
            }
            else if(ch[i]=='(')
            {
                st.push(ch[i]);
            }
            else if(ch[i]==')')
            {
                while(!st.empty() && st.peek()!='(')
                {
                    res+=st.peek();
                    st.pop();
                }
                if(!st.empty())
                {
                    st.pop();
                }
            }
            else
            {
                while(!st.empty() && prec(st.peek())>prec(ch[i]))
                {
                    res+=st.peek();
                    st.pop();

                }
                st.push(ch[i]);
            }
            

        }

        while(!st.empty())
        {
            res+=st.peek();
            st.pop();
        }

        return res;
        
    }


    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter infix expression: ");
        String expr = sc.nextLine();
        System.out.println(infixtopostfix(expr));    
    }
    
}