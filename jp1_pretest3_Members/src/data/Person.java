/*
Creates an abstract class named Person in package data.
- Fields ID, name, yob
- Default constructor to initialize the above fields.
- Method
- public void accept() : allow user input data into data fields.
Using try-catch exception for validation: ID, name not null- yob must be in range [1940-
2006] .
- public abtract void printInfo() : print details of an person. 
 */
package data;

import java.util.Scanner;

public abstract class Person {

    public String ID, name;
    public int yob;

    public void accept() {
        Scanner sc = new Scanner(System.in);
        //Kiem tra ID;
        do {
            try {
                System.out.print("Nhap ID: ");
                ID = sc.nextLine().trim();
                if (ID == null) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                System.out.println("ID not null!");
            }
        } while (ID == null);

        //Kiem tra name;
        do {
            try {
                System.out.print("Nhap ten: ");
                name = sc.nextLine().trim();
                if (name == null) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                System.out.println("name not null!");
            }
        } while (name == null);

        //Kiem tra yob;
        do {
            try {
                System.out.print("Nhap nam sinh [1940-2006]: ");
                yob = Integer.parseInt(sc.nextLine().trim());
                if (yob < 1940 || yob > 2006) {
                    throw new NumberFormatException();
                }
            } catch (Exception e) {
                System.out.println("yob must be in range [1940-2006]!");
            }
        } while (yob < 1940 || yob > 2006);
    }

    //Khai bao ham printInfo;
    public abstract void printInfo(); //Print details of an person;
}
