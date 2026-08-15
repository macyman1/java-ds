public class dou
{

    public class node
    {
        int data;
        node next;
        node prev;

    }
    node start;

    public node createnode(int data)
    {
        node newnode = new node();
        newnode.data = data;
        newnode.next = null;
        newnode.prev = null;
        return newnode;
    }
    
    public dou()
    {
        this.start = null;
    }
    public void insertatstart(int data)
    {
        node newnode = createnode(data);
        start = newnode;
        newnode.prev = start;
        System.out.println("Inserted " + data + " at beginning");
    }
        
    public void insertatend(int data)
    {
        node newnode = createnode(data);
        if(start == null)
        {
            start = newnode;
            newnode.prev = start;
        }
        else
        {
            node current = start;
            while(current.next!=null)
            {
                current = current.next;
            }
            current.next = newnode;
            newnode.prev = current;
        }
        System.out.println("Inserted " + data + " at end");
    }
    public void insertatpos(int data , int pos)
    {
        if (pos == 0)
        {
            insertatstart(data);
        }
        node newNode = createnode(data);
        node current = start;
        for(int i =0; i<pos -1 && current != null; i++)
        {
            current=current.next;
        }
        if (current==null)
        {
            System.out.println("position outoff bound");
        }
        newNode.next = current.next;
        newNode.prev = current;
        current.next = newNode;
        System.out.println("Inserted " + data + " at position " + pos);
    }
    public void display() {
        if (start == null) {
            System.out.println("List is empty");
            return;
        }
        
        System.out.print("Linked List: ");
        node current = start;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }
        System.out.println(" <-> null");
    }
            
        
    
                
    
    public static void main(String[] args) 
    {
        dou d = new dou();
        d.insertatstart(10);
        d.insertatpos(12,1);
        d.insertatend(20);
        d.display();

    }
}