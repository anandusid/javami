Sure! Here are brief explanations of some common design patterns in Java, along with small examples:

1. **Singleton Pattern**:
   - Ensures that a class has only one instance and provides a global point of access to that instance.
   
   ```java
   public class Singleton {
       private static Singleton instance;

       private Singleton() {}

       public static Singleton getInstance() {
           if (instance == null) {
               instance = new Singleton();
           }
           return instance;
       }
   }
   ```

2. **Factory Pattern**:
   - Defines an interface for creating an object, but allows subclasses to alter the type of objects that will be created.
   
   ```java
   interface Animal {
       void sound();
   }

   class Dog implements Animal {
       public void sound() {
           System.out.println("Woof");
       }
   }

   class Cat implements Animal {
       public void sound() {
           System.out.println("Meow");
       }
   }

   class AnimalFactory {
       public static Animal createAnimal(String type) {
           if (type.equalsIgnoreCase("dog")) {
               return new Dog();
           } else if (type.equalsIgnoreCase("cat")) {
               return new Cat();
           }
           return null;
       }
   }

   public class Main {
       public static void main(String[] args) {
           Animal dog = AnimalFactory.createAnimal("dog");
           dog.sound();  // Output: Woof
       }
   }
   ```

3. **Observer Pattern**:
   - Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

  Got it! Let's use a similar example with the observer pattern to demonstrate how different services can handle events when an order is created.

### Example: Order Creation and Event Handling with Observer Pattern

#### Components

1. **OrderService**: Publishes an event when an order is created.
2. **OrderCreatedEvent**: Custom event class carrying order information.
3. **ShippingService**: Listens to the order created event and handles shipping logic.

### Detailed Implementation

#### 1. Define the Order Created Event

Create a custom event class that carries the necessary information about the order.

```java
import org.springframework.context.ApplicationEvent;

public class OrderCreatedEvent extends ApplicationEvent {
    private final String orderId;

    public OrderCreatedEvent(Object source, String orderId) {
        super(source);
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}
```

#### 2. Publish the Event in OrderService

Modify the `OrderService` to publish the `OrderCreatedEvent` when an order is successfully created.

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private OrderRepository repo;

    @Transactional
    public void createOrder(String orderId, String productName) {
        try {
            // Create and save order
            final Order order = new Order();
            order.setOrderId(orderId);
            order.setProductName(productName);
            repo.save(order);

            // Publish order created event
            eventPublisher.publishEvent(new OrderCreatedEvent(this, orderId));
        } catch (final Exception e) {
            // Handle exceptions
            System.out.println(e.getMessage());
            // Optionally, handle rollback logic
        }
    }
}
```

#### 3. Create the Shipping Service to Handle the Event

Create a listener that handles the `OrderCreatedEvent` and performs shipping-related tasks.

```java
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ShippingService {

    @EventListener
    public void handleOrderCreated(OrderCreatedEvent event) {
        // Logic to handle order created event
        System.out.println("ShippingService: Order created - " + event.getOrderId());
        // Perform shipping related tasks...
    }
}
```

### Summary

1. **OrderCreatedEvent**: Custom event class to carry order information.
2. **OrderService**: Publishes an `OrderCreatedEvent` when an order is created.
3. **ShippingService**: Listens for `OrderCreatedEvent` and handles shipping logic.

This example demonstrates how to use the observer pattern with Spring's event system to decouple components and handle events in a clean, modular way. The `OrderService` publishes an event when an order is created, and the `ShippingService` listens for this event to perform shipping-related tasks.

These examples provide a basic understanding of how these design patterns are implemented in Java. Each pattern addresses a specific problem and provides a reusable solution that can be applied to various scenarios in software development.

Yes, the Prototype Pattern is another commonly used design pattern in Java. It's used to create new objects by copying an existing object, known as the prototype.

Here's a simple example of the Prototype Pattern in Java:

```java
import java.util.HashMap;
import java.util.Map;

// Prototype interface
interface Prototype {
    Prototype clone();
}

// Concrete prototype
class ConcretePrototype implements Prototype {
    private String name;

    public ConcretePrototype(String name) {
        this.name = name;
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// Prototype manager
class PrototypeManager {
    private static Map<String, Prototype> prototypes = new HashMap<>();

    static {
        // Add predefined prototypes
        prototypes.put("prototype1", new ConcretePrototype("Prototype 1"));
        prototypes.put("prototype2", new ConcretePrototype("Prototype 2"));
    }

    public static void addPrototype(String key, Prototype prototype) {
        prototypes.put(key, prototype);
    }

    public static Prototype getPrototype(String key) {
        return prototypes.get(key).clone();
    }
}

public class Main {
    public static void main(String[] args) {
        // Get and clone prototype
        Prototype prototype1 = PrototypeManager.getPrototype("prototype1");
        Prototype prototype2 = PrototypeManager.getPrototype("prototype2");

        // Modify cloned prototypes
        ((ConcretePrototype) prototype1).setName("Modified Prototype 1");

        // Output original and cloned prototype names
        System.out.println("Original prototype1: " + ((ConcretePrototype) PrototypeManager.getPrototype("prototype1")).getName());
        System.out.println("Cloned prototype1: " + ((ConcretePrototype) prototype1).getName());
        System.out.println("Original prototype2: " + ((ConcretePrototype) PrototypeManager.getPrototype("prototype2")).getName());
        System.out.println("Cloned prototype2: " + ((ConcretePrototype) prototype2).getName());
    }
}
```

In this example:
- The `Prototype` interface defines the `clone()` method for creating a copy of the object.
- The `ConcretePrototype` class implements the `Prototype` interface and provides the implementation for the `clone()` method.
- The `PrototypeManager` class manages the prototypes and allows clients to retrieve cloned prototypes.

The Prototype Pattern is useful when creating new objects is more expensive or complex than copying existing ones. It helps improve performance and reduces code duplication by using prototypes as templates for creating new objects.