/*
Create class Member derives from Person, in package data, consists of:
- Fields : type
- Constructors to initialize the all fields
- Override methods:
- accept() : allow user to input additional details for an member:
invoke method accept() of super class.
using try-catch exception for validation: type belongs to [‘VIP’,’GOLD’,’STANDARD’].
- printInfo() : display details of an member including id, name, age, type.
- toString() : return a string presenting all the details of a member.
 */
package data;

import java.util.Scanner;
import java.time.Year;

public class Member extends Person {

    public String type;
    @Override
    public void accept() {
        super.accept();
        while (true) {
            Scanner sc = new Scanner(System.in);
            try {
                System.out.print("Nhap rank: ");
                type = sc.nextLine().trim();
                    if ("VIPGOLDSTANDARD".contains(type)==true) {
                        break;
                    } else {
                        throw new Exception("type belongs to ['VIP', 'GOLD', 'STANDARD']");
                    }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    @Override
    public void printInfo() {
        System.out.println("\n=== Details of an members ===");
        System.out.println("ID: " + ID);
        System.out.println("Ten: " + name);
        System.out.println("Age: " + age());
        System.out.println("Rank: " + type);
    }

    @Override 
    public String toString(){
        return String.format("%s, %s, %d, %s", ID, name, age(), type );
    }

    private int age() {
        int currentYear = Year.now().getValue();
        return currentYear - yob;
    }
}
