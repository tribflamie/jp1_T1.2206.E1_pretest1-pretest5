/*
Create a main class named Test in app package, manage a list of StudentFPT, declares :
Fields:
- StudentFPT[ ] arr: store array of the students
- max: the maximum of the number of students in the array.
- next: the actual number of students in the array.
Methods:
- add(): create a new studentFPT and then save into the array. However, if the
array is full, display an error message.
- displayAll(): list all students
- displayPass(): display list of the students passed the examinations (each mark
must be greater than 40 and final mark >=50 )
 */
package app;

import basic.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        Test m = new Test();
        m.menu();
    }

    private void menu() {
        Scanner sc = new Scanner(System.in);
        String op = "";
        while (true) {
            System.out.println("\n === MENU ===");
            System.out.println("1. Them hoc sinh moi.");
            System.out.println("2. In danh sach hoc sinh.");
            System.out.println("3. In hoc sinh qua mon.");
            System.out.println("4. In hoc sinh top 1.");
            System.out.println("5. Thoat.");
            System.out.println("=============");
            System.out.print("Chon ma chuc nang [1-5]: ");
            op = sc.nextLine().trim();
            switch (op) {
                case "1":
                    add();
                    break;
                case "2":
                    display();
                    break;
                case "3":
                    displayPass();
                    break;
                case "4":
                    displayTop1();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Sai ma chuc nang! Vui long nhap lai...");
            }
        }
    }

    int max = 10, next = 0;
    StudentFPT[] arr = new StudentFPT[max];

    private void add() {
        if (next == max) {
            System.out.println("Het dung luong du tru");
            return;
        }
        StudentFPT mp = new StudentFPT();
        mp.input();
        arr[next++] = mp;
    }

    private void display() {
        if (next == 0) {
            System.out.println("He thong chua co du lieu");
            return;
        }
        System.out.println("=== In danh sach hoc sinh ===");
        for (int i = 0; i < next; i++) {
            System.out.println(arr[i]);
        }
    }

    private void displayPass() {
        if (next == 0) {
            System.out.println("He thong chua co du lieu");
            return;
        }
        System.out.println("=== In danh sach hoc sinh qua mon===");
        for (int i = 0; i < next; i++) {
            if (arr[i].theoryMark > 40 && arr[i].practiceMark > 40 && arr[i].project > 40 && arr[i].getFinal() >= 50) {
                System.out.println(arr[i]);
            }
        }
    }

    private void displayTop1() {
        if (next == 0) {
            System.out.println("He thong chua co du lieu!");
            return;
        }

        for (int i = 1; i < next; i++) {
            if (arr[0].getFinal() < arr[i].getFinal()) {
                arr[0] = arr[i];
            }
        }
        System.out.println("=== Hoc sinh co diem cao nhat ===");
        System.out.println(arr[0]);
    }
}
