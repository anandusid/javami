SOLID principles
SOLID is an acronym representing a set of five design principles that are widely used in object-oriented programming to create maintainable, flexible, and understandable software
They are are considered fundamental guidelines for writing clean and well-structured code.
Single Responsibility Principle (SRP)
A class should have only one reason to change or only one responsibility
// Problem - Violating SRP
class Employee {
    void calculateSalary() { /* ... */ }
    void generatePaySlip() { /* ... */ }
    void saveData() { /* ... */ }
}

// Solution - Following SRP
class Employee {
    void calculateSalary() { /* ... */ }
}

class PaySlipGenerator {
    void generatePaySlip() { /* ... */ }
}

class EmployeeDataStorage {
    void saveData() { /* ... */ }
}
Open/Closed Principle (OCP)
Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification
Modules should be extended without modifying it.
Similar to abstraction.
Eg., EmailNotification.java class and MobileNotificationService.java class both implements NotificationService.java interface, instead of having both email and mobile services in NotificationService.java class.
// Problem - Violating OCP
class Rectangle {
    int width, height;
}

class Circle {
    int radius;
}

// Solution - Following OCP
interface Shape {
    double area();
}

class Rectangle implements Shape {
    int width, height;
    public double area() { return width * height; }
}

class Circle implements Shape {
    int radius;
    public double area() { return Math.PI * radius * radius; }
}
Liskov Substitution Principle (LSP)
LSP states that derived class must be completely substitutable for their base classes. i.e., if class A is a subtype of class B, then we should be able to replace B with A without interrupting the behaviour of the program.
Derived classes should adhere to the contract established by their base classes and should not change the expected behavior.
Eg.,
// Problem - Violating LSP
class Bird {
    void fly() { /* ... */ }
}

class Ostrich extends Bird {
    void fly() { throw new UnsupportedOperationException(); }
}

// Solution - Following LSP
interface Bird {
    void move();
}

class Sparrow implements Bird {
    void move() { /* ... */ }
}

class Ostrich implements Bird {
    void move() { /* ... */ }
}
Interface Segregation Principle (ISP)
Do not force client to use methods that they do not want to use.
Large interfaces should be broken into small ones.
Eg., ShapeCalculatorInterface has abstract methods calculateArea() and calculateVolume(), if Circle class implements ShapeCalculatorInterface then LSP is broken as Circle does not have volume. Inorder to fix this create another interface 3DCalculatorInterface with calculateVolume() alone.
// Problem - Violating ISP
interface Worker {
    void work();
    void eat();
}

// Solution - Following ISP
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}
Dependency Inversion Principle (DIP)
High-level modules should not depend on low-level modules. Both should depend on abstractions.
// Problem - Violating DIP
class LightBulb {
    void turnOn() { /* ... */ }
    void turnOff() { /* ... */ }
}

class Switch {
    LightBulb bulb = new LightBulb();

    void operate() {
        if (/* condition */) {
            bulb.turnOn();
        } else {
            bulb.turnOff();
        }
    }
}

// Solution - Following DIP
interface Switchable {
    void turnOn();
    void turnOff();
}

class LightBulb implements Switchable {
    public void turnOn() { /* ... */ }
    public void turnOff() { /* ... */ }
}

class Fan implements Switchable {
    public void turnOn() { /* ... */ }
    public void turnOff() { /* ... */ }
}

class Switch {
    Switchable device;

    void operate() {
        if (/* condition */) {
            device.turnOn();
        } else {
            device.turnOff();
        }
    }
}
