/*
Create java main class MobilePhoneTest in package app for managing a collection of
MobilePhones:
- Fields: max, next – mList (array of MobilePhones)
- Methods:
- void add() - add a new mobile phone ( Note: ID must be unique )
- void display() - display all mobile phones.
- void displayTop1() - display the mobile phones have the most value.
- void display ( String mBrand ) - search and display MobilePhones by the required brand
name.
- void remove( String mID ) – remove an MobilePhone by ID.
- void menu() - allows to manage the list of MobilePhones through the menu system as
follows.
1. Add a new Mobile Phone
2. Display list of Mobile Phone
3. Display Top 1 Mobile Phone
4. Search Mobile Phone by brand name
5. Remove Mobile Phone by ID
6. Exit
 */
package app;

import data.*;
import java.util.*;
import java.util.stream.Stream;

public class MobilePhoneTest {

    public static void main(String[] args) {
        MobilePhoneTest m = new MobilePhoneTest();
        m.menu();
    }

    private void menu() {
        Scanner sc = new Scanner(System.in);
        String op = "";
        while (true) {
            System.out.println("\n === MENU ===");
            System.out.println("1. Add a new Mobile Phone");
            System.out.println("2. Display list of Mobile Phone");
            System.out.println("3. Display Top 1 Mobile Phone");
            System.out.println("4. Search Mobile Phone by brand name");
            System.out.println("5. Remove Mobile Phone by ID");
            System.out.println("6. Exit");
            System.out.println("=============");
            System.out.print("Choose option from [1-6]: ");
            op = sc.nextLine().trim();
            switch (op) {
                case "1":
                    add();
                    break;
                case "2":
                    display();
                    break;
                case "3":
                    displayTop1();
                    break;
                case "4":
                    System.out.print("Nhap ten thuong hieu muon tim: ");
                    String brand = sc.nextLine().trim();
                    display(brand);
                    break;
                case "5":
                    System.out.print("Nhap ma so muon xoa: ");
                    String ms = sc.nextLine().trim();
                    remove(ms);
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Sai ma chuc nang! Vui long nhap lai...");
            }
        }
    }

    int max = 10, next = 0;
    MobilePhone[] mList = new MobilePhone[max];

    private void add() {
        if (next == max) {
            System.out.println("Error: Het cho luu tru");
            return;
        }
        MobilePhone mp = new MobilePhone();
        mp.accept();
        mList[next++] = mp;
    }

    private void display() {
        if (next == 0) {
            System.out.println("Error: He thong chua co du lieu");
            return;
        }
        System.out.println("\n Danh sach Mobilephone");
        for (int i = 0; i < next; i++) {
            System.out.println(mList[i]);
        }
    }

    private void displayTop1() {
        if (next == 0) {
            System.out.println("Error: He thong chua co du lieu!");
            return;
        }

        Stream<MobilePhone> ds = Arrays.stream(mList, 0, next);
        int max_price = ds.max((o1, o2) -> o1.price - o2.price).get().price;

        System.out.println("Danh sach top 1: ");
        ds = Arrays.stream(mList, 0, next);
        ds.filter(x -> x.price == max_price).forEach(System.out::println);
    }

    private void display(String brand) {
        if (next == 0) {
            System.out.println("Error: He thong chua co du lieu!");
            return;
        }

        Stream<MobilePhone> ds = Arrays.stream(mList, 0, next);
        var cnt = ds.filter(x -> x.brand.equalsIgnoreCase(brand)).count();

        if (cnt == 0) {
            System.out.println("Khong tim thay!");
            return;
        }

        System.out.printf("Danh sach mobile theo thuong hieu [%s]\n", brand);
        Arrays.stream(mList, 0, next).filter(x -> x.brand.equalsIgnoreCase(brand)).forEach(System.out::println);
    }
    
    private void remove(String ms) {
        for (int i = 0; i < next; i++) {
            if (mList[i].id.equals(ms)) {
                /*
                tim thay sv co ma so muon xoa, 
                xoa sinh vien  ra khoi danh sach bang cach
                giam vi tri sinh vien xuong 1 hang
                 */
                for (int k = i; k < next - 1; k++) {
                    mList[k] = mList[k + 1];
                }
                next--;
                System.out.printf("Da xoa dien thoai theo ma so [%s] ", ms);
                return;
            }
        }
        System.out.printf("Khong tim thay ma so [%s]", ms);
    }
}
