/*
Creates an interface named IGeometry in package data.
- Constant PI = 3.1415
- Method
- public double area() : calculate area of any shape.
- public double peripheral() : calculate peripheral of any shape.
- public double volume() : calculate volume of any shape.
 */
package data;

public interface IGeometry {
    Double PI=3.1415;
    public double area();
    public double peripheral();
    public double volume();
}
