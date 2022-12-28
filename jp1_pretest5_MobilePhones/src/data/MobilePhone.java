/*
Create class MobilePhone derives from Product, in package data, consists of:
- Fields : brand, year , qoh (quantity-on-hand)
- Constructors to initialize the all fields
- Override methods:
- accept() : allow user to input additional details for an MobilePhone:
invoke method accept() of super class.
using try-catch exception for validation:
brand belongs to [ Iphone, Samsung, Motorola, Nokia ],
year from 2000 until now,
qoh belongs to [0-30]
- printInfo() : display details of an Mobile Phone including id, name, brand, price , year,
qoh and amount (price*qoh)
- toString() : return a string presenting all the details of a Mobile Phone
 */
package data;

import java.time.Year;
import java.util.Scanner;

public class MobilePhone extends Product {

    public String brand;
    public int year, qoh;

    public MobilePhone() {
        super(); //hoi ham dung cua lop cha, de khoi tao 3 fields: id, name, price;
        brand = "unknown";
        year = 9999;
        qoh = 99;
    }

    public MobilePhone(String brand, int year, int qoh) {
        this.brand = brand;
        this.year = year;
        this.qoh = qoh;
    }

    @Override
    public void accept() {
        super.accept();
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("nhap thuong hieu iphone|samsung|lg: ");
                brand = sc.nextLine().trim();

                if ("iphone|samsung|lg".contains(brand)) {
                    break;
                }
                throw new NumberFormatException("Error: thuong hieu khong hop le!");
            } catch (NumberFormatException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        int currentYear = Year.now().getValue();

        while (true) {
            try {
                System.out.printf("nhap nam sx [2000-%d]: ", currentYear);
                year = Integer.parseInt(sc.nextLine().trim());
                if (year >= 2000 && year <= currentYear) {
                    break;
                }
                throw new NumberFormatException("Nam sx khong hop le!");
            } catch (NumberFormatException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("nhap qoh [0-30]: ");
                qoh = Integer.parseInt(sc.nextLine().trim());
                if (qoh >= 0 && qoh <= 30) {
                    break;
                }
                throw new NumberFormatException("qoh khong hop le!");
            } catch (NumberFormatException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    @Override
    public void printInfo() {
        System.out.println("id" + id);
        System.out.println("ten: " + name);
        System.out.println("thuong hieu: " + brand);
        System.out.println("nam sx: " + year);
        System.out.println("don gia" + price);
        System.out.println("so luong ton kho: " + qoh);
        System.out.println("=====================");
    }

    @Override
    public String toString() {
        return String.format("%s,  %s, %s, %d, %d", id, name, brand, price, qoh);
    }

}
