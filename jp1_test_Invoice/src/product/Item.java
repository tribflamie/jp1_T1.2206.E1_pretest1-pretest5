package product;

import java.util.Scanner;
import sale.IDiscount;

public class Item implements IDiscount {

    public String name;
    public int price;
    public int quantity;
    
    //ham tinh tong cong;
    public int total() {
        return quantity * price;
    }
    
    //ham co tham so;
    public Item() {
        this.name = "unknown";
        this.price = 9999;
        this.quantity = 99;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        
        //kiem tra ten;
        while (true) {
            try {
                System.out.print("input name: ");
                name = sc.nextLine().trim();
                if (!name.isBlank()) {
                    break;
                }
                throw new NumberFormatException();

            } catch (NumberFormatException e) {
                System.out.println("name cannot be blank!");
            }
        }
        
        //kiem tra gia;
        while (true) {
            try {
                System.out.print("input price [price > 0]: ");
                price = Integer.parseInt(sc.nextLine().trim());
                if (price > 0) {
                    break;
                }
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("price must be greater than 0!");
            }
        }
        
        //kiem tra so luong;
        while (true) {
            try {
                System.out.print("input quantity [quantity > 0]: ");
                quantity = Integer.parseInt(sc.nextLine().trim());
                if (quantity > 0) {
                    break;
                }
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("price must be greater than 0!");
            }
        }
    }

    @Override
    public void displayDetails() {
        System.out.println("\n=== Product Information ===");
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total: " + this.total());
    }

}
