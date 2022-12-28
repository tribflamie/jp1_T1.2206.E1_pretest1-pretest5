/*
Create class Cylinder derives from Shape, implements IGeometry in package data, consists of:
- Fields : radius, height
- Constructors to initialize the all fields
- Override methods of Shape and IGeometry:
-accept() :
using try-catch exception for validation: radius, height must be greater than zero.
- printInfo() : display detailed information of a cylinder including radius, height, peripheral,
area, volume
- toString() : return a string presenting all the details of a cylinder
 */
package data;

import java.util.Scanner;

public class Cylinder extends Shape implements IGeometry {

    public double radius, height;

    @Override
    public void accept() {
        Scanner sc = new Scanner(System.in);
        //kiem tra ban kinh;
        do {
            try {
                System.out.print("Nhap ban kinh: ");
                radius = Double.parseDouble(sc.nextLine().trim());
                if (radius < 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("radius must be greater than zero");
            }
        } while (radius < 0);
        
        //kiem tra chieu cao;
        do {
            try {
                System.out.print("Nhap chieu cao: ");
                height = Double.parseDouble(sc.nextLine().trim());
                if (radius < 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("height must be greater than zero");
            }
        } while (height < 0);
    }

    @Override
    public void printInfo() {
        System.out.println("ban kinh: " + radius);
        System.out.println("chieu cao: " + height);
        System.out.println("chu vi: " + peripheral());
        System.out.println("dien tich: " + area());
        System.out.println("the tich: " + volume());
    }

    @Override
    public double area() {
        return (2 * PI * radius *  radius) + peripheral();
    }

    @Override
    public double peripheral() {
        return 2 * PI * radius * height;
    }

    @Override
    public double volume() {
        return PI * radius * radius * height;
    }

    @Override
    public String toString() {
        return String.format("ban kinh: %.2f, chieu cao: %.2f, chu vi: %.2f, dien tich: %.2f, the tich: %.2f", radius, height,  peripheral(), area(), volume());
    }
}
