class Parent {
    public Parent() {
        System.out.println("Parent class constructor invoked");
    }
}

class Child extends Parent {
    public Child() {
        super(); // Invoking parent class constructor
        System.out.println("Child class constructor invoked");
    }
}

public class Question2 {
    public static void main(String[] args) {
        Child child = new Child(); // Creates a Child object
    }
}
/*
 * Explanation:
 * 
 * Constructor: A constructor is a special method used to initialize objects of
 * a class. It has the same name as the class and doesn't have a return type.
 * Constructors are automatically called when an object is created using the new
 * keyword. Invoking Parent Class Constructor: In Java, when you create an
 * instance of a subclass, the constructor of the superclass is automatically
 * called before the constructor of the subclass. This is done to ensure that
 * the inherited members from the parent class are properly initialized. super()
 * Keyword: super() is used to call the constructor of the parent class from the
 * child class. It must be the first statement in the child class constructor.
 * 4 Output:
Parent class constructor invoked
Child class constructor invoked
 */