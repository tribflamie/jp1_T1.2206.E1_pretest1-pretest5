package product;

import product.Item;
import java.util.Scanner;

public class Invoice {

    public static void main(String[] args) {
        Invoice i = new Invoice();
        i.menu();
    }

    private void menu() {
        Scanner sc = new Scanner(System.in);
        String op = "";
        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("1. Create new Item.");
            System.out.println("2. Seach and display Item by name.");
            System.out.println("3. Exit.");
            System.out.println("================");
            System.out.print("Choose option [1-3]: ");
            op = sc.nextLine().trim();
            switch (op) {
                case "1":
                    addItem();
                    break;
                case "2":
                    System.out.print("Input name: ");
                    String iname = sc.nextLine().trim().toLowerCase();
                    searchItem(iname);
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Error: Invalid option! Type again...");
            }
        }
    }

    int maxItem = 10, nextItem = 0;
    Item arrItem[] = new Item[maxItem];

    private void addItem() {
        if (nextItem == maxItem) {
            System.out.println("Error: Ran out of data.");
            return;
        }
        Item i = new Item();
        i.input();
        arrItem[nextItem++] = i;
    }

    private void searchItem(String iname) {
        if (nextItem == 0) {
            System.out.println("Error: No data in system.");
            return;
        }
        System.out.printf("== Item searched by [%s] ==", iname);
        int cnt = 0;
        for (int i = 0; i < nextItem; i++) {
            if (arrItem[i].name.contains(iname)) {
                arrItem[i].displayDetails();
                cnt++;
            }
        }
        if (cnt == 0) {
            System.out.println("Error: No item to display.");
        }
    }

}
