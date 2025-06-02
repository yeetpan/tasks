import java.util.*;

// Enum for Item Types
enum ItemType{
    BEVERAGE,PASTRY
}
// Orderable Interface
interface  Orderable{
    public double getPrice();
    public String getName();
}

// Abstract MenuItem Class
abstract class MenuItem implements  Orderable{
    protected String name;
    protected double price;
    public MenuItem(String name,double price){
        this.name=name;
        this.price=price;
    }
    public double getPrice(){
        return price;
    }
    public String getName(){
        return name;
    }
}
// Beverage Class
 class Beverage extends MenuItem{
     public Beverage(String name,double price){
        super(name,price);
    }

}
// Pastry Class
 class Pastry extends MenuItem{
    public Pastry(String name,double price){
        super(name,price);
    }

}

// Order Class
class Order{
    List<Orderable>items;
    public Order(){
        items=new ArrayList<>();
    }
    public void addItem(Orderable item){
        items.add(item);
        System.out.println("Order Added: "+item.getName());
    }
    public void calculateTotal(){
        double total=0.0;
        for(Orderable item:items){
            total+=item.getPrice();
        }
        System.out.println(total);
    }
}

// Main Class
public class CoffeeSys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        while (true) {
            int action = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (action == 4) {
                break;
            }

            switch (action) {
                case 1: // Add Beverage
                    String beverageName = scanner.nextLine();
                    double beveragePrice = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    Beverage beverage = new Beverage(beverageName, beveragePrice);
                    order.addItem(beverage);
                    break;

                case 2: // Add Pastry
                    String pastryName = scanner.nextLine();
                    double pastryPrice = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    Pastry pastry = new Pastry(pastryName, pastryPrice);
                    order.addItem(pastry);
                    break;

                case 3: // Calculate Total
                    order.calculateTotal();
                    break;

                default:
                    System.out.println("Invalid action. Please enter 1 to 4.");
            }
        }

        scanner.close();
    }
}
