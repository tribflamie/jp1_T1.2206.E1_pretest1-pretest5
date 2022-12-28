/*
Create java main class Test in package app for managing a collection of Cylinders:
- Fields: max, next – cList (array of cylinders)
- Methods:
- void add() - add a new cylinder
- void display() - display all cylinders.
- void display( float v ) - display cylinders having volume greater than v.
- void menu() - allows to manage the list of cylinders through the menu system as follows.
1. Add a new cylinder
2. Display all cylinders
3. Display all cylinders having required volume
4. Exit
 */
package app;

import data.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        Test m = new Test();
        m.menu();
    }

    private void menu() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n===== MENU =====");
            System.out.println("1. Them hinh tru. ");
            System.out.println("2. In toan bo thong tin hinh tru.");
            System.out.println("3. In toan bo hinh tru co the tich lon hon tham so nhap.");
            System.out.println("4. Thoat.");
            System.out.println("================");
            System.out.print("Nhap ma chuc nang tu [1-4]: ");
            String op = sc.nextLine().trim();

            switch (op) {
                case "1":
                    add();
                    break;
                case "2":
                    display();
                    break;
                case "3":
                    System.out.print("Nhap the tich: ");
                    Double v = Double.parseDouble(sc.nextLine().trim());
                    display(v);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Nhap sai ma chuc nang! Vui long nhap lai...");
            }
        }
    }
    int max = 10, next = 0;
    Cylinder[] mList = new Cylinder[max];

    private void add() {
        if (next == max) {
            System.out.println("Het dung luong du tru!");
            return;
        }
        Cylinder mp = new Cylinder();
        mp.accept();
        mList[next++] = mp;
    }

    private void display() {
        if (next == 0) {
            System.out.println("He thong chua co du lieu!");
            return;
        }
        System.out.println("\n=== In toan bo hinh tru ===");
        for (int i = 0; i < next; i++) {
            System.out.println(mList[i]);
        }
    }

    private void display(Double v) {
        if (next == 0) {
            System.out.println("He thong chua co du lieu!");
            return;
        }

        int cnt = 0;
        System.out.printf("=== In toan bo hinh tru co the tich lon hon %.2f lit ===\n", v);
        for (int i = 0; i < next; i++) {
            if (mList[i].volume() >= v) {
                System.out.println(mList[i]);
                cnt++;
            }
        }

        if (cnt == 0) {
            System.out.println("Khong tim thay hinh tru!");
        }
    }

}
