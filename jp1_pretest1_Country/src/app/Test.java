/*
methods: add(), display(), displayTop1(), remove(string code);
 */
package app;

import basic.Country;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        Test t = new Test();
        Scanner sc = new Scanner(System.in);
        String op = "";

        while (true) {

            System.out.println("\n=== MENU ===");
            System.out.println("1. Add new country");
            System.out.println("2. Display all countries");
            System.out.println("3. Display the country having the highest population");
            System.out.println("4. Remove a country by code");
            System.out.println("5. Exit");
            System.out.println("============");
            System.out.print("Choose your option [1-5]: ");
            op = sc.nextLine().trim();

            switch (op) {
                case "1":
                    t.add();
                    break;
                case "2":
                    t.display();
                    break;
                case "3":
                    t.displayTop1();
                    break;
                case "4":
                    System.out.print("Remove a country by code: ");
                    String code = sc.nextLine().trim();
                    t.remove(code);
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Error: Invalid option! Choose again.");
            }
        }
    }

    int max = 2;
    int next = 0;
    Country[] arr = new Country[max];

    private void add() {
        if (next == max) {
            System.out.println(">> Error: Ran out of data!");
            return;
        }

        Country c = new Country();
        c.input();
        arr[next++] = c;
    }

    private void display() {
        if (next == 0) {
            System.out.println("Error: no data in system!");
            return;
        }

        System.out.println("\n=== All countries ===");
        for (int i = 0; i < next; i++) {
            System.out.println(arr[i]);
        }
    }

    private void displayTop1() {
        if (next == 0) {
            System.out.println("Error: no data in system!");
            return;
        }

        Stream<Country> ds = Arrays.stream(arr, 0, next);
        int max_price = ds.max((o1, o2) -> o1.population - o2.population).get().population;

        System.out.println("Display the country having the highest population: ");
        ds = Arrays.stream(arr, 0, next);
        ds.filter(x -> x.population == max_price).forEach(System.out::println);
    }

    private void remove(String ms) {
        for (int i = 0; i < next; i++) {
            if (arr[i].code.equals(ms)) {
                /*
                tim thay sv co ma so muon xoa, 
                xoa sinh vien  ra khoi danh sach bang cach
                giam vi tri sinh vien xuong 1 hang
                 */
                for (int k = i; k < next - 1; k++) {
                    arr[k] = arr[k + 1];
                }
                next--;
                System.out.println("The country has been removed by code: " + ms);
                return;
            }
        }
        System.out.println("Don't find country by code: " + ms);
    }
}
