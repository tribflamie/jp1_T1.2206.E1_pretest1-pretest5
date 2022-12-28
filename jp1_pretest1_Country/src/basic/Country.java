/*
Fields: code, name, capital, area, population;
Methods: input(); try-catch for all data; area and population>=0
Override print() display information of a country
 */
package basic;

import java.util.Scanner;

public class Country implements IPrintable {

    public String code, name, capital;
    public int area, population;

    public Country() {
        code = "a00";
        name = "unknown";
        capital = "unknown";
        area = 999;
        population = 999999999;
    }

    public Country(String code, String name, String capital, int area, int population) {
        this.code = code;
        this.name = name;
        this.capital = capital;
        this.area = area;
        this.population = population;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma so: ");
        code = sc.nextLine().trim();
        System.out.print("Nhap ten: ");
        name = sc.nextLine().trim();
        System.out.print("Nhap thanh pho: ");
        capital = sc.nextLine().trim();
        do {
            try {
                System.out.print("Nhap ma khu vuc: ");
                area = Integer.parseInt(sc.nextLine().trim());
                if (area < 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                System.out.println("Error: the area must be greater than 0");
            }
        } while (area < 0);

        do {
            try {
                System.out.print("Nhap dan so: ");
                population = Integer.parseInt(sc.nextLine().trim());
                if (population < 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                System.out.println("Error: the population must be greater than 0");
            }
        } while (population < 0);
    }

    @Override
    public void print() {
        System.out.println("\n=== Thong tin quoc gia ===");
        System.out.println("Ma so: " + code);
        System.out.println("Ten: " + name);
        System.out.println("Thanh pho: " + capital);
        System.out.println("Khu vuc: " + area);
        System.out.println("Dan so: " + population);
        System.out.println("==========================");
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %d, %d", code, name, capital, area, population);
    }

}
