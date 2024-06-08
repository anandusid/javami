In Java, `Comparator` and `Comparable` are two interfaces used to define the natural ordering and custom ordering of objects, respectively. Here are the key differences between them:

### Comparable

1. **Interface Definition**: 
   - `Comparable<T>` is a generic interface in `java.lang` package.

2. **Method**:
   - It contains one method: `int compareTo(T o)`.
   - This method compares the current object with the specified object to determine their natural ordering.

3. **Purpose**:
   - Used to define the natural ordering of objects, meaning that each object of the class can compare itself to another object of the same class.

4. **Implementation**:
   - The class that implements `Comparable` must implement the `compareTo` method.

5. **Single Sort Sequence**:
   - There can be only one implementation of `compareTo` method, meaning one natural sort order.

6. **Example**:
   ```java
   public class Student implements Comparable<Student> {
       private int id;
       private String name;

       public Student(int id, String name) {
           this.id = id;
           this.name = name;
       }

       @Override
       public int compareTo(Student other) {
           return Integer.compare(this.id, other.id); // Sorting by id
       }

       // Getters and setters
   }
   ```

### Comparator

1. **Interface Definition**:
   - `Comparator<T>` is a generic interface in `java.util` package.

2. **Methods**:
   - It contains several methods, with the primary one being `int compare(T o1, T o2)`.
   - Other methods include `equals(Object obj)`, and static methods like `comparing`, `thenComparing`, etc.

3. **Purpose**:
   - Used to define custom orderings for objects, allowing for multiple ways to compare objects.

4. **Implementation**:
   - The class that uses `Comparator` can create multiple comparator implementations to provide different sorting orders.

5. **Multiple Sort Sequences**:
   - Allows for multiple ways of sorting, which can be useful in different scenarios.

6. **Example**:
   ```java
   import java.util.Comparator;

   public class Student {
       private int id;
       private String name;

       public Student(int id, String name) {
           this.id = id;
           this.name = name;
       }

       // Getters and setters

       // Comparator for sorting by name
       public static Comparator<Student> NameComparator = new Comparator<Student>() {
           @Override
           public int compare(Student s1, Student s2) {
               return s1.name.compareTo(s2.name);
           }
       };

       // Comparator for sorting by id
       public static Comparator<Student> IdComparator = new Comparator<Student>() {
           @Override
           public int compare(Student s1, Student s2) {
               return Integer.compare(s1.id, s2.id);
           }
       };
   }
   ```

### Summary of Differences

1. **Comparable**:
   - Defines the natural ordering.
   - Implemented by the class itself.
   - Has a single `compareTo` method.
   - Only one natural sort order per class.

2. **Comparator**:
   - Defines custom orderings.
   - Implemented as a separate class or as a lambda expression.
   - Has multiple `compare` methods.
   - Allows multiple sorting orders.

### Practical Usage

- **Comparable**:
  - Use when you want a default sorting order for a class, and you can modify the class to implement the `Comparable` interface.
  - Example: Sorting integers, strings, or dates in their natural order.

- **Comparator**:
  - Use when you need different ways to sort objects and you don't want to or can't modify the class itself.
  - Example: Sorting employees by name, salary, or hire date depending on the context.

Using these interfaces properly helps in achieving flexible and reusable code for sorting and ordering objects in Java.