// DO NOT compile this .java file.  Follow the README instructions.

/*
    This program allows the user to select from two shapes: either a two dimensional or three dimensional shape.
    Next, the user chooses from 5 standard shapes in that dimension, and dpending on the shape's dimension,
    the user can calculate the shape's area (2-D) or choose to calculate either that shape's volume or
    surface area (3-D).  Then, all the shape names and calculations of that runtime are displayed.
*/



// === Beginning of shapes package =====================================================

package shapes;
// Top of shape hierarchy
public interface Shape {}

// --- TwoDShape tree -----------------------------------------------------------------

package shapes;
// All 2-D shapes inherit from this abstract class
abstract public class TwoDShape implements Shape {
    public abstract double calcArea(); // 2-D shapes have area
}


// Rectangle
package shapes;

public class Rectangle extends TwoDShape {
    // Rectangles' dimensions for area are length and width.
    private double length;
    private double width;
    
    public Rectangle(double l, double w) {
        length = l;
        width = w;
    }
    
    public double calcArea() {
        return length * width;
    }
    
    public double getLength() {
        return length;
    }
    
    public double getWidth() {
        return width;
    }
}

// Parallelogram
package shapes;

public class Parallelogram extends TwoDShape {
    // Parallelogram's dimensions for area are base and height.
    private double base;
    private double height;
    
    public Parallelogram(double b, double h) {
        base = b;
        height = h;
    }
    
    public double calcArea() {
        return base * height;
    }
    
    public double getBase() {
        return base;
    }
    
    public double getHeight() {
        return height;
    }
}

// Trapezoid
package shapes;

public class Trapezoid extends TwoDShape {
    // Trapezoids' dimensions for area are base1, base2, and height.
    private double base1;
    private double base2;
    private double height;
    
    public Trapezoid(double b1, double b2, double h) {
        base1 = b1;
        base2 = b2;
        height = h;
    }
    
    public double calcArea() {
        return ((base1 + base2) * height) / 2;
    }
    
    public double getBase1() {
        return base1;
    }
    
    public double getBase2() {
        return base2;
    }
    
    public double getHeight() {
        return height;
    }
}

// Triangle
package shapes;

public class Triangle extends TwoDShape {
    // Triangles' dimensions for area are base and height.
    private double base;
    private double height;
    
    public Triangle(double b, double h) {
        base = b;
        height = h;
    }
    
    public double calcArea() {
        return (base * height) / 2;
    }
    
    public double getBase() {
        return base;
    }
    
    public double getHeight() {
        return height;
    }
}

// Circle
package shapes;

import java.lang.Math.*; // Needed for PI and exponents
public class Circle extends TwoDShape {
    // Circles' dimensions for area is just radius.
    private double radius;
    
    public Circle(double r) {
        radius = r;
    }
    
    public double calcArea() {
        return Math.PI * Math.pow(radius, 2);
    }
    
    public double getRadius() {
        return radius;
    }
}
// --- End of TwoDShape tree ----------------------------------------------------------

// --- ThreeDShape tree ---------------------------------------------------------------

package shapes;
// All 3-D shapes inherit from this abstract class
abstract public class ThreeDShape implements Shape {
    // 3-D shapes have surface area and volume
    public abstract double calcSurfaceArea();
    public abstract double calcVolume();
}


// Right Circular Cone
package shapes;

import java.lang.Math.*; // Needed for PI and exponents
public class RightCircularCone extends ThreeDShape {
    private double radius; // Dimension for both calculations
    private double height; // Dimension for volume
    private double slantHeight; // Dimension for surface area
    
    public RightCircularCone(double r) {
        radius = r; // Only relevant dimension at object creation since radius is used in both calculations
        height = -1;
        slantHeight = -1;
    }
    
    public void setHeight(double h) { // use if calculating volume is desired
        height = h;
    }
    
    public void setSlantHeight(double sH) { // use if calculating surface area is desired
        slantHeight = sH;
    }
    
    public double calcVolume() {
        return (Math.PI * Math.pow(radius, 2) * height) / 3;
    }
    
    public double calcSurfaceArea() {
        return (Math.PI * radius * slantHeight) + (Math.PI * Math.pow(radius, 2));
    }
    
    public double getRadius() {
        return radius;
    }
    
    public double getHeight() {
        return height;
    }
    
    public double getSlantHeight() {
        return slantHeight;
    }
}

// Pyramid
package shapes;

public class Pyramid extends ThreeDShape {
    private double baseArea; // Dimension used in both calculations
    private double basePerimeter; // Dimension used in surface area calculation
    private double height; // Dimension used volume calculaion
    private double slantHeight; // Dimension used in surface area calculations
    
    public Pyramid(double bA) {
        baseArea = bA; // Only relevant dimension at object creation since baseArea is used in both calculations
        basePerimeter = -1;
        height = -1;
        slantHeight = -1;
    }
    
    public void setBasePerimeter(double bP) { // For surface area
        basePerimeter = bP;
    }
    
    public void setHeight(double h) { // For Volume
        height = h;
    }
    
    public void setSlantHeight(double sH) { // For surface area
        slantHeight = sH;
    }
    
    public double calcVolume() {
        return (baseArea * height) / 3;
    }
    
    public double calcSurfaceArea() {
        return baseArea + (basePerimeter * slantHeight) / 2;
    }
    
    public double getBaseArea() {
        return baseArea;
    }
    
    public double getBasePerimeter() {
        return basePerimeter;
    }
    
    public double getHeight() {
        return height;
    }
    
    public double getSlantHeight() {
        return slantHeight;
    }
}

// Sphere
package shapes;

import java.lang.Math.*; // Needed for PI and exponents
public class Sphere extends ThreeDShape {
    private double radius; // Only dimension needed for both calculations
    
    public Sphere(double r) {
        radius = r;
    }
    
    public double calcVolume() {
        return (4 * Math.PI * Math.pow(radius, 3)) / 3;
    }
    
    public double calcSurfaceArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }
    
    public double getRadius() {
        return radius;
    }
}

// Right Circular Cylinder
package shapes;

import java.lang.Math.*; // Needed for PI and exponents
public class RightCircularCylinder extends ThreeDShape {
    private double radius; // Used in both calculations
    private double height; // Used in both calculations
    
    public RightCircularCylinder(double r, double h) {
        radius = r;
        height = h;
    }
    
    public double calcVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }
    
    public double calcSurfaceArea() {
        return (2 * Math.PI * radius * height) + (2 * Math.PI * Math.pow(radius, 2));
    }
    
    public double getRadius() {
        return radius;
    }
    
    public double getHeight() {
        return height;
    }
}

// Right Prism
package shapes;

public class RightPrism extends ThreeDShape {
    private double baseArea; // Used in both calculations
    private double basePerimeter; // Used only in surface area calculations
    private double height; // Used in both calculations
    
    public RightPrism(double bA, double h) {
        baseArea = bA;
        basePerimeter = -1;
        height = h;
    }
    
    public void setBasePerimeter(double bP) {
        basePerimeter = bP;
    }
    
    public double calcVolume() {
        return baseArea * height;
    }
    
    public double calcSurfaceArea() {
        return (2 * baseArea) + (basePerimeter * height);
    }
    
    public double getBaseArea() {
        return baseArea;
    }
    
    public double getBasePerimeter() {
        return basePerimeter;
    }
    
    public double getHeight() {
        return height;
    }
}
// --- End of ThreeDShape tree --------------------------------------------------------

// === End of shapes package ==========================================================



// === Default package ================================================================

// Skeleton for all menus that will be displayed
public interface MenuSkeleton
{
    public void start();
    public void twoD();
    public void threeD();
    public void threeDSub();
}

// All menus that will be displayed
class Menu implements MenuSkeleton {
    
   public void start() { // Initial start menu at the beginning of each loop
       System.out.println();
       System.out.println("Choose a shape type: \n" +
                           "1. 2-D SHape \n" +
                           "2. 3-D SHape"); 
                           
   }    
    
   public void twoD() { // Menu for 2-D shapes
       System.out.println();
       System.out.println("Please choose a shape: \n" +
                           "1. Rectangle \n" +
                           "2. Parallelogram \n" +
                           "3. Trapezoid \n" +
                           "4. Triangle \n" +
                           "5. Circle");
                           
   }
    
   public void threeD() { // Menu for 3-D shapes
       System.out.println(); 
       System.out.println("Please choose a shape: \n" +
                           "1. Right Circular Cone \n" +
                           "2. Pyramid \n" +
                           "3. Sphere \n" +
                           "4. Right Circular Cylinder \n" +
                           "5. Right Prism");
        
   }
   
   public void threeDSub() { // 3-D sub menu
       System.out.println();
       System.out.println("Calculate volume or surface area? Enter either 1 or 2:\n" +
                           "1. Volume \n" +
                           "2. Surface Area");
                           
   }
}


import shapes.*; // package that contains all shape objects
import java.util.Scanner; // input object

// class that contains main() and supporting methods
class GeoShapes {
    public static Scanner reader = new Scanner(System.in); // global scanner within GeoShapes class
    public static Menu m = new Menu(); // global Menu object in GeoShapes class: used to display the menus
    
    public static int chooseShape() { // input validator for shape selection
        int num;
        
        num = reader.nextInt();  
        while (num < 1 || num > 5) {
            System.out.print("Please enter a number between 1 and 5: ");
            num = reader.nextInt();
        }
        
        return num;
    }
    
    public static double assignVal(){ // input validator for shape data input
        double num;
        
        num = reader.nextDouble();
        while(num <= 0) {
            System.out.print("Please enter a number greater than 0: ");
            num = reader.nextDouble();
        }
        
        return num;
    }
    
    public static int VorSA() { // 3-D shapes sub menu input validator
        int num;
        
        m.threeDSub(); // display menu to choose 2-D or 3-D
        
        num = reader.nextInt();
        while (num < 1 || num > 2) {
            System.out.print("Please enter either 1 or 2: ");
            num = reader.nextInt();
        }
       
        return num;
    }
    
    // main method
    public static void main(String args[]) 
    throws java.io.IOException {
        
        double [] calcs; //calculation tracker
        String [] shapeTypes; // shape type tracker
        int numShapes; // number of shapes user will practice
        int choice; // menu input variable
        
        System.out.print("Welcome to GeoShape Practice. How many shapes would you like to practice? "); // welcome message
        numShapes = reader.nextInt(); // choose number of shapes to practice
        while (numShapes <= 0) { // validate numShapes
            System.out.print("Please enter a number greater than 0: ");
            numShapes = reader.nextInt();
        }
        
        // size trackers to number of shapes
        calcs = new double[numShapes]; 
        shapeTypes = new String[numShapes];
        
        for(int i = 0; i < numShapes; i++) { // repeat until user-specified number of shapes has been reached
        
            m.start(); // display main menu
        
            choice = reader.nextInt(); // choose shape dimension
            while (choice < 1 || choice > 2) { // validate choice
                System.out.print("Please enter either 1 or 2: ");
                choice = reader.nextInt();
            }

            if (choice == 1) { // 2-D shapes selected
                
                m.twoD(); // display 2-D shapes menu
                choice = chooseShape(); // choose shape
        
                switch (choice) { // actual 2-D shape menu
                    case 1: // Rectangle
                    {
                        Rectangle ob; // object refrence variable
                        double length, width; // shape data
                        
                        // input shape data
                        System.out.println();
                        System.out.println("Please enter the length and width of the rectangle.");
                        System.out.print("Length: ");
                        length = assignVal();
                        System.out.print("Width: ");
                        width = assignVal();
                        
                        ob = new Rectangle(length, width); // initialize object
                        
                        // run calculation
                        System.out.println("Area of a rectangle is length * width: \n" +
                                           ob.getLength() + " * " + ob.getWidth() + " = " + ob.calcArea()); 
                        calcs[i] = ob.calcArea(); // update calculations tracker
                        shapeTypes[i] = "Rectangle area"; // update shapes tracker
                        break;
                    }
                    case 2: // Parallelogram
                    {
                        Parallelogram ob; // object reference varaiable 
                        double base, height; // shape data
                        
                        // input shape data
                        System.out.println();
                        System.out.println("Please enter the base and height of the parallelogram.");
                        System.out.print("Base: ");
                        base = assignVal();
                        System.out.print("Height: ");
                        height = assignVal();
                        
                        ob = new Parallelogram(base, height); // initialize object
                        
                        // run calculation
                        System.out.println("Area of a parallelogram is base * height: \n" +
                                           ob.getBase() + " * " + ob.getHeight() + " = " + ob.calcArea()); 
                        calcs[i] = ob.calcArea(); // update calculations tracker
                        shapeTypes[i] = "Parallelogram area"; // update shapes tracker
                        break;
                    }
                    case 3: // Trapezoid
                    {
                        Trapezoid ob; // object reference variable
                        double base1, base2, height; // shape data
                        
                        // input shape data
                        System.out.println();
                        System.out.println("Please enter both bases and the height of the trapezoid.");
                        System.out.print("Base1: ");
                        base1 = assignVal();
                        System.out.print("Base2: ");
                        base2 = assignVal();
                        System.out.print("Height: ");
                        height = assignVal();
                            
                        ob = new Trapezoid(base1, base2, height); // initialize object
                        
                        // run calculation
                        System.out.println("Area of a trapezoid is ((base1 + base2) * height) / 2: \n" +
                                           "((" + ob.getBase1() + " + " + ob.getBase2() + ") * " + ob.getHeight() + ") / 2 = " 
                                           + ob.calcArea()); 
                        calcs[i] = ob.calcArea(); // update calculations tracker
                        shapeTypes[i] = "Trapezoid area"; // update shapes tracker
                        break;
                    }
                    case 4: // Triangle
                    {
                        Triangle ob; // object reference variable
                        double base, height; // shape data
                        
                        // input shape data
                        System.out.println();
                        System.out.println("Please enter the base and height of the triangle.");
                        System.out.print("Base: ");
                        base = assignVal();
                        System.out.print("Height: ");
                        height = assignVal();
                            
                        ob = new Triangle(base, height); // initialize object
                        
                        // run calculation
                        System.out.println("Area of a triangle is (base * height) / 2: \n" +
                                           "(" + ob.getBase() + " * " + ob.getHeight() + ") / 2 = " + ob.calcArea()); 
                        calcs[i] = ob.calcArea(); // update calculations tracker
                        shapeTypes[i] = "Triangle area"; // update shapes tracker
                        break;
                    }
                    case 5: // Circle
                    {
                        Circle ob; // object reference variable
                        double radius; // shape data
                        
                        // input shape data
                        System.out.println();
                        System.out.print("Please enter the radius of the circle: ");
                        radius = assignVal();
                            
                        ob = new Circle(radius); // initialize object
                            
                        // run calculation
                        System.out.println("Area of a circle is PI * radius^2: \n" +
                                           "PI" + " * " + ob.getRadius() + "^2 = " + ob.calcArea()); 
                        calcs[i] = ob.calcArea(); // update calculations tracker
                        shapeTypes[i] = "Circle area"; // update shapes tracker
                        break;
                    }
                    default: // 2-D shape switch-case error check
                        System.out.println("Error in switch-case 1.");
                }    
            }    
            else // 3-D shapes selected
            {
                
                m.threeD(); // display 3-D shapes menu
                choice = chooseShape(); // choose shape
        
                switch (choice) { // actual 3-D shape menu
                    case 1: // Right Circular Cone
                    {
                        RightCircularCone ob; // object reference variable
                        double radius; // general shape data
                        
                        choice = VorSA(); // chose claculation
                        
                        // input general shape data
                        System.out.println();
                        System.out.println("Please enter the radius of the right circular cone.");
                        System.out.print("Radius: "); 
                        radius = assignVal();
                        
                        ob = new RightCircularCone(radius); // initialize object
                        if (choice == 1) { // Volume
                            double height; // calculation specific data
                            
                            // input and update object
                            System.out.print("Please enter the height: "); 
                            height = assignVal();
                            ob.setHeight(height);
                            
                            // run calculation
                            System.out.println("Volume of a right circular cone is PI * radius^2 * height / 3: \n" +
                                               "PI" + " * " + ob.getRadius() + "^2 * " + ob.getHeight() + " / 3 " +
                                               "= " + ob.calcVolume()); 
                            calcs[i] = ob.calcVolume(); // update caluclations tracker
                            shapeTypes[i] = "Right Circular Cone volume"; // update shapes tracker
                        }
                        else { // Surface Area
                            double slantHeight; // calculation specific data
                            
                            // input and update object
                            System.out.print("Please enter the slant height: "); 
                            slantHeight = assignVal();
                            ob.setSlantHeight(slantHeight);
                            
                            // run calculation
                            System.out.println("Surface Area of a right circular cone is (PI * radius * slant height) + (PI * radius^2)): \n" +
                                               "(PI" + " * " + ob.getRadius() + " * " + ob.getSlantHeight() + ") + (PI * " + ob.getRadius() +
                                               "^2) = " + ob.calcSurfaceArea()); 
                            calcs[i] = ob.calcSurfaceArea(); // update calculations tracker
                            shapeTypes[i] = "Right Circular Cone surface area"; // update shapes tracker
                        }
                        break;
                    }
                    case 2: // Pyramid
                    {
                        Pyramid ob; //object reference variable
                        double baseArea; // general shape data
                        
                        choice = VorSA(); // choose calculations
                        
                        // input general shape data
                        System.out.println();
                        System.out.println("Please enter the base area of the pyramid:");
                        System.out.print("Base Area: "); 
                        baseArea = assignVal();
                        
                        ob = new Pyramid(baseArea); // initialize object
                        if (choice == 1) { // Volume
                            double height; // calculation specific data
                            
                            // input and update object
                            System.out.print("Please enter the height: "); 
                            height = assignVal();
                            ob.setHeight(height);
                            
                            // run calculation
                            System.out.println("Volume of a pyramid is base area * height / 3: \n" +
                                               ob.getBaseArea() + " * " + ob.getHeight() + " / 3 " +
                                               "= " + ob.calcVolume()); 
                            calcs[i] = ob.calcVolume(); // update calculations tracker
                            shapeTypes[i] = "Pyramid volume"; // update shapes tracker
                        }
                        else { // Surface Area
                            double slantHeight, basePerimeter; // calculation specific data
                            
                            // input and update object
                            System.out.print("Please enter the slant height: "); 
                            slantHeight = assignVal();
                            ob.setSlantHeight(slantHeight);
                            System.out.print("Please enter the base perimeter: "); 
                            basePerimeter = assignVal();
                            ob.setBasePerimeter(basePerimeter);
                            
                            // run calculation
                            System.out.println("Surface Area of a pyramid is base area + (base perimeter * slant height) / 2: \n" +
                                               ob.getBaseArea() + " + (" + ob.getBasePerimeter() + " * " + ob.getSlantHeight() +
                                               ") / 2) = " + ob.calcSurfaceArea()); 
                            calcs[i] = ob.calcSurfaceArea(); // update calculations tracker
                            shapeTypes[i] = "Pyramid surface area"; // update shapes tracker
                        }    
                        break;
                    }
                    case 3: // Sphere
                    {
                        Sphere ob; // object reference variable
                        double radius; // general shape data
                        
                        choice = VorSA(); // choose calculation
                        
                        // input general shape data
                        System.out.println();
                        System.out.print("Please enter the radius of the sphere: "); 
                        radius = assignVal();
                        
                        ob = new Sphere(radius); // initialize object
                        if (choice == 1) { // Volume
                            // run calculation (no extra shape data needed)
                            System.out.println("Volume of a sphere is (4 * PI * radius^3) / 3: \n" +
                                               "(4 * PI" + " * " + ob.getRadius() + "^3) / 3 " +
                                               "= " + ob.calcVolume()); 
                            calcs[i] = ob.calcVolume(); // update calculations tracker
                            shapeTypes[i] = "Sphere volume"; // update shapes tracker
                        }
                        else { // Surface Area
                            // run calculation (no extra data needed)
                            System.out.println("Surface Area of a sphere is 4 * PI * radius^2: \n" +
                                               "4 * PI" + " * " + ob.getRadius() + "^2 = " +
                                               + ob.calcSurfaceArea()); 
                            calcs[i] = ob.calcSurfaceArea(); // update calculations tracker
                            shapeTypes[i] = "Sphere surface area"; // update shapes tracker
                        }
                        break;
                    }
                    case 4: // Right Circular Cylinder
                    {
                        RightCircularCylinder ob; // object reference variable
                        double radius, height; // general shape data
                        
                        choice = VorSA(); // choose calculation
                        
                        // input general shape data
                        System.out.println();
                        System.out.println("Please enter the radius and height of the right circular cylinder.");
                        System.out.print("Radius: "); 
                        radius = assignVal();
                        System.out.print("Height: "); 
                        height = assignVal();
                        
                        ob = new RightCircularCylinder(radius, height); // initialize object
                        if (choice == 1) { // Volume
                            // run calculation (no extra data needed)
                            System.out.println("Volume of a right circular cylinder is PI * radius^2 * height: \n" +
                                               "PI" + " * " + ob.getRadius() + "^2 * " + ob.getHeight() +
                                               " = " + ob.calcVolume()); 
                            calcs[i] = ob.calcVolume(); // update calculations tracker
                            shapeTypes[i] = "Right Circular Cylinder volume"; // update shapes tracer
                        }
                        else { // Surface Area
                            // run calculation (no extra data needed)
                            System.out.println("Surface Area of a right circular cylinder is "+
                                               "(2 * PI * radius * height) + (2 * PI * radius^2): \n" +
                                               "(2 * PI" + " * " + ob.getRadius() + " * " + ob.getHeight() + ")" +
                                               " + (2 * PI * " + ob.getRadius() + "^2)" +
                                               " = "+ ob.calcSurfaceArea()); 
                            calcs[i] = ob.calcSurfaceArea(); // update calculations tracker
                            shapeTypes[i] = "Right Circular Cylinder surface area"; // update shapes tracker
                        }
                        break;
                    }
                    case 5: // Right Prism
                    {
                        RightPrism ob; // object reference variable
                        double baseArea, height; // general shape data
                        
                        choice = VorSA(); // choose calculation
                        
                        // input general shape data
                        System.out.println();
                        System.out.println("Please enter the base area and height of the right prism.");
                        System.out.print("Base Area: "); 
                        baseArea = assignVal();
                        System.out.print("Height: "); 
                        height = assignVal();
                        
                        ob = new RightPrism(baseArea, height); // initialize object
                        if (choice == 1) { // Volume
                            // run calculation  (no extra data needed)
                            System.out.println("Volume of a right prism is base area * height: \n" +
                                               ob.getBaseArea() + " * " + ob.getHeight() +
                                               " = " + ob.calcVolume()); 
                            calcs[i] = ob.calcVolume(); // update calculations tracker
                            shapeTypes[i] = "Right Prism volume"; // update shapes tracker
                        }
                        else { // Surface Area
                            double basePerimeter; // calculation specific data
                            
                            // input and update object
                            System.out.print("Please enter the base perimeter: ");
                            basePerimeter = assignVal();
                            ob.setBasePerimeter(basePerimeter);
                            
                            // run calculation
                            System.out.println("Surface Area of a right prism is (2 * base area) + (base perimeter * height): \n"+
                                               "(2 * " + ob.getBaseArea() + ") + (" + ob.getBasePerimeter() + " * " + ob.getHeight() +
                                               ") = "+ ob.calcSurfaceArea()); 
                            calcs[i] = ob.calcSurfaceArea(); // update calculations tracker
                            shapeTypes[i] = "Right Prism surface area"; // update shapes tracker
                        }
                        break;
                    }
                    default: // 3-D shape switch-case error check
                        System.out.println("Error in switch-case 2.");
                }
            }
        }    
        
        // pause program
        System.out.println(); 
        System.out.println("Press Enter To Contiue...");
        System.in.read(); 
        System.out.println();
        System.out.println("Your shapes and calculations:"); 
        for (int i = 0; i < calcs.length; i++) { // display all shape types and calculations
            System.out.println("Calculation " + (i + 1) + ":");
            System.out.println(shapeTypes[i] + ": " + calcs[i]);
            System.out.println();
        }
    }      
}

// === End of Default package =========================================================