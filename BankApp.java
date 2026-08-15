public class BankApp
{
    public static void main(String[] args) 
    {
        BankAccount a1 = new BankAccount();
        a1.create("kush", "saving", 1000);
        a1.display();
        a1.deposit(2500);
        a1.withdraw(1000);
        System.out.println("balance : "+a1.balance);
        

        System.out.println("                                            ");

        BankAccount a2 = new BankAccount();
        a2.create("kushi", "saving", 2000);
        a2.display();
        a2.deposit(500);
        a2.withdraw(1000);
        System.out.println("balance : "+a2.balance);
    }
}

class BankAccount
{
    String name;
    String type;
    double balance;
    int acc;

    static int nxacc = 1;

    void create(String name, String type, double balance)
    {
        acc = nxacc++;  
        this.name = name;
        this.type = type;
        this.balance = balance;
    }

    void deposit(int balance)  
    {
        this.balance += balance;
        System.out.println("amount : " + balance + " deposited");
    }
    
    void withdraw(int balance)
    {
        if(this.balance < balance)
        {
            System.out.println("Insufficient balance");
        }
        else 
        {
            this.balance = this.balance - balance;
            System.out.println("amount : " + balance + " withdrawn");  // Added message
        }
    }
    
    void display()
    {
        System.out.println("name : " + this.name);
        System.out.println("account number : " + this.acc);
        System.out.println("type : " + this.type);
        System.out.println("balance : " + this.balance);
    }
}

