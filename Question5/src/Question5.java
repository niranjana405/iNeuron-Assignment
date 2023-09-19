abstract class Shape {
    abstract void draw(); // Abstract method
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle extends Shape {
    void draw() {
        System.out.println("Drawing Rectangle");
    }
}

public class Question5 {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();
        circle.draw();
        rectangle.draw();
    }
}
/*
 * Key Points about Interface:
 * 
 * Definition: An interface is like a blueprint of a class, it only contains
 * method signatures (no method bodies). 
 * Purpose: Used when you want to specify
 * a contract that multiple classes can implement. 
 * Usage: Contains method
 *declarations only, no implementation details. Cannot have instance variables
 * (prior to Java 8). Implementation: Classes implement an interface using
 * implements. A class can implement multiple interfaces. All methods declared
 * in an interface must be implemented in the class.
 * When to use Abstract Class vs Interface:

Abstract Class:
Use when you want to provide a default implementation for some methods.
When you want to share code among closely related classes.
Interface:
Use when you want to specify a contract for a group of classes that are not necessarily related by inheritance.
When you want to achieve multiple inheritance-like behavior (prior to Java 8).

 */