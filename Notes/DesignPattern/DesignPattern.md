Singleton Pattern
Singleton pattern is a creational design pattern

It restricts the instantiation of a class to ensure that there is only one instance of that class in the entire application.

It guarantees to provide a global point of access to that instance.

Singleton pattern is often used to control access to a resource, manage a shared resource, or maintain a single point of control, such as a configuration manager or a connection pool (Database connections, Logger instances).

Key characteristics

Private Constructor: The Singleton class has a private constructor, preventing external code from creating instances of the class directly.
Private Static Instance: It typically contains a private static instance of the class itself.
Public Static Method: It provides a public static method that allows access to the unique instance. This method creates the instance if it doesn't exist or returns the existing instance
public class Singleton {

  private final String data;
// Private static volatile instance
  private static volatile Singleton instance;

  // Private constructor
  private Singleton(String data) {
      this.data = data;
  }

  // Public static method to get the instance
  public static Singleton getInstance() {
    Singleton result = instance;
      if (result == null) {
        //only one thread at a time can enter this critical section
          synchronized (Singleton.class) {
              result = instance;
              if (result == null) {
                  instance = result = new Singleton(data);
              }
          }
      }
      return result;
  }

  public String getData() {
      return data;
  }

}



Factory Pattern

The Signnificance of this pattern is to create an object in an abstract way and client couldnt identify how the object is creating.
The Factory Pattern provides an interface for creating an object in a Super class and allow the sub classes of the super class will define the type of te instance which is creating.This will help to avoid tight coupling to the super class by reducing the dependent code.

this will help to avodi the object creation logic until the run time.



