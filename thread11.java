//threding 

import java.util.Scanner;
public class thread11
{
    public static void main(String[] args) 
    {
        runable r = new runable();
        Thread thread = new Thread(r);
        thread.start();
        thread.setDaemon(true);
        Scanner s = new Scanner(System.in);
        System.out.println("you have 5 seconds to enter your name :");
        String name = s.nextLine();
        System.out.println("hello "+name);
        s.close();
    }
}

class runable implements Runnable
{
    @Override
    public void run()
    {
        for(int i=1;i<=5;i++)
        {
            try 
            {
                Thread.sleep(1000);    
            }
             catch (InterruptedException e) 
            {
                System.out.println("System was interrupted");
            }
            if(i == 5)
            {
                System.out.println("Times up!");
            }
        }
    }
}