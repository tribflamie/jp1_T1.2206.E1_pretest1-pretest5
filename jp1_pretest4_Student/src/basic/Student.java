/*
Create abstract class Student in basic package that stores the following details:
- Protected Fields: id, name, yob(year of birth)
- Constructors to initialise the all fields.
- Methods:
public abstract void print()
public void input (): input data for a student with following constraints:
• ID, name is not null
• Age must be between 15 and 60

 */
package basic;

import java.time.Year;
import java.util.Scanner;

public abstract class Student {

    public String id, name;
    public int yob;

    public abstract void print();

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ID: ");
        id = sc.nextLine().trim();
        System.out.print("Nhap ten: ");
        name = sc.nextLine().trim();

        do {
            System.out.print("Nhap nam sinh [15<=Age<=60]: ");
            yob = Integer.parseInt(sc.nextLine().trim());
            if(Age() < 15 || Age() > 60){
                System.out.println("Age must be between 15 and 60!");
            }
        } while (Age() < 15 || Age() > 60);
    }

    public int Age() {
        int currentYear = Year.now().getValue();
        return currentYear - yob;
    }
}
