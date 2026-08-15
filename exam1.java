public class exam1
{
    public static void main(String[] args) 
    {
        // box<String> box1 = new box<>();
        // box1.set("banana");
        // System.out.println(box1.get());
        product<String, Integer> product1 = new product<>("apple", 100);
        System.out.println("Item: " + product1.getItem());
        System.out.println("Price: " + product1.getPrice());
    }

}
class box<T> 
{
    T item;
    public void set(T item)
    {
        this.item = item;
    }
    public T get()
    {
        return this.item;
    }
}
class product<T, U>
{
    T item;
    U price;

    public product(T item, U price)
    {
        this.item = item;
        this.price = price;
    }
    public T getItem()
    {
        return this.item;
    }
    public U getPrice()
    {   
        return this.price;
    }


      
}