/*
Create java main class MemberTest in package app for managing a collection of Members:
- Fields: max, next – mList (array of members)
- Methods:
- void add() - add a new member
- void display() - display all members.
- void display ( String sName ) - search and display members by the required name.
- void remove( String sID ) – remove an member by ID.
- void menu() - allows to manage the list of members through the menu system as follows.
1. Add a new member
2. Display list of member
3. Search member by name
4. Remove member by ID
5. Exit
 */
package app;

import data.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class MemberTest {

    public static void main(String[] args) {
        MemberTest m = new MemberTest();
        m.menu();
    }

    private void menu() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n===== MENU =====");
            System.out.println("1. Them nhan vien. ");
            System.out.println("2. In toan bo nhan vien.");
            System.out.println("3. Tim nhan vien theo ten.");
            System.out.println("4. Xoa nhan vien theo ID.");
            System.out.println("5. Thoat.");
            System.out.println("================");
            System.out.print("Nhap ma chuc nang tu [1-5]: ");
            String op = sc.nextLine().trim();

            switch (op) {
                case "1":
                    add();
                    break;
                case "2":
                    display();
                    break;
                case "3":
                    System.out.print("Nhap ten nhan vien: ");
                    String sName = sc.nextLine().trim();
                    display(sName);
                    break;
                case "4":
                    System.out.print("Nhap ID nhan vien muon xoa: ");
                    String id = sc.nextLine().trim();
                    remove(id);
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Nhap sai ma chuc nang! Vui long nhap lai...");
            }
        }
    }

    int max = 10, next = 0;
    Member[] mList = new Member[max];

    private void add() {
        if (next == max) {
            System.out.println("Het dung luong du tru!");
            return;
        }
        Member mp = new Member();
        mp.accept();
        mList[next++] = mp;
    }

    private void display() {
        if (next == 0) {
            System.out.println("He thong chua co du lieu!");
            return;
        }
        System.out.println("\n=== In toan bo nhan vien ===");
        for (int i = 0; i < next; i++) {
            System.out.println(mList[i]);
        }
    }

    private void display(String sName) {
        if (next == 0) {
            System.out.println("Error: He thong chua co du lieu!");
            return;
        }

        Stream<Member> ds = Arrays.stream(mList, 0, next);
        var cnt = ds.filter(x -> x.name.equalsIgnoreCase(sName)).count();

        if (cnt == 0) {
            System.out.println("Khong tim thay!");
            return;
        }

        System.out.printf("Danh sach nhan vien co ten [%s]\n", sName);
        Arrays.stream(mList, 0, next).filter(x -> x.name.equalsIgnoreCase(sName)).forEach(System.out::println);
    }

    private void remove(String id) {
        for (int i = 0; i < next; i++) {
            if (mList[i].ID.equals(id)) {
                /*
                tim thay sv co ma so muon xoa, 
                xoa sinh vien  ra khoi danh sach bang cach
                giam vi tri sinh vien xuong 1 hang
                 */
                for (int k = i; k < next - 1; k++) {
                    mList[k] = mList[k + 1];
                }
                next--;
                System.out.printf("Da xoa nhan vien co ID la %s ", id);
                return;
            }
        }
        System.out.printf("Khong tim thay %s trong he thong!", id);
    }

}
