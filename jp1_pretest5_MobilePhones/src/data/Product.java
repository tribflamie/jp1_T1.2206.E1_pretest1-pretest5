/*
Creates an abstract class named Product in package data.
- Fields ID, name, price
- Default constructor to initialize the above fields.
- Method
- public void accept() : allow user input data into data fields.
Using try-catch exception for validation: ID, name not null- price must be greater than 0
- public abtract void printInfo() : print details of an Product. 
 */
package data;

import java.util.Scanner;

public abstract class Product {

    public String id, name;
    public int price;

    public Product() {
        id = "abc";
        name = "unknown";
        price = 9999;
    }

    public Product(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    public abstract void printInfo();

    public void accept() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("nhap id: ");
            id = sc.nextLine().trim();
            if (id.isEmpty()) {
                System.out.println("Error: id can't be flank!");
                continue;
            }
            break;
        }

        while (true) {
            System.out.print("nhap ten: ");
            name = sc.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Error: id can't be flank!");
                continue;
            }
            break;
        }
        
        while(true){
            try {
                System.out.print("Nhap don gia [>=0]: ");
                price = Integer.parseInt(sc.nextLine().trim());
                if(price<0){
                    throw new NumberFormatException("Don gia phai >=0!");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    
}
