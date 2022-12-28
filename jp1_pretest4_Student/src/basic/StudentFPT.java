/*
Create sub class StudentFPT derives from Student, in package basic. Including:
- Fields: theoryMark, practiceMark, project.
- Constructors to initialise the all fields.
- public float getFinal() : return the final mark that calculated by formula :
(theoryMark*2 + practiceMark + project*3)/6
- Override methods :
input(): allow user input more data into data fields theoryMark, practiceMark,
project. Using try-catch exception for data validation: marks must be between 0
and 100
print():display detailed information of a student, including final mark.
 */
package basic;

import java.util.Scanner;

public class StudentFPT extends Student {

    public float theoryMark, practiceMark, project;

    public float getFinal() {
        return (theoryMark * 2 + practiceMark + project * 3) / 6;
    }

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);

        //kiem tra diem ly thuyet;
        do {
            try {
                System.out.print("Nhap diem ly thuyet [0-100]: ");
                theoryMark = Float.parseFloat(sc.nextLine().trim());
                if (theoryMark < 0 || theoryMark > 100) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Marks must be between 0 and 100");
            }
        } while (theoryMark < 0 || theoryMark > 100);
        
        //kiem tra diem thuc hanh;
        do {
            try {
                System.out.print("Nhap diem thuc hanh [0-100]: ");
                practiceMark = Float.parseFloat(sc.nextLine().trim());
                if (practiceMark < 0 || practiceMark > 100) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Marks must be between 0 and 100");
            }
        } while (practiceMark < 0 || practiceMark > 100);
        
        //kiem tra diem project;
        do {
            try {
                System.out.print("Nhap diem do an [0-100]: ");
                project = Float.parseFloat(sc.nextLine().trim());
                if (project < 0 || project > 100) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Marks must be between 0 and 100");
            }
        } while (project < 0 || project > 100);

    }

    @Override
    public void print() {
        System.out.println("=== Information of a student ===\n");
        System.out.println("id: " + id);
        System.out.println("ten: " + name);
        System.out.println("tuoi: " + Age());
        System.out.println("diem ly thuyet: " + theoryMark);
        System.out.println("diem thuc hanh: " + practiceMark);
        System.out.println("diem do an: " + project);
        System.out.println("================================");
        System.out.println("diem tong ket: " + getFinal());
    }
    
    @Override 
    public String toString(){
        return String.format("id: %s, ten: %s, tuoi: %d, ly thuyet: %.2f, thuc hanh: %.2f, do an: %.2f, tong ket: %.2f", id, name, Age(), theoryMark, practiceMark, project, getFinal());
    }
}
