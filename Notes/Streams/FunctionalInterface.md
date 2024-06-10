In Java, a **functional interface** is an interface that contains exactly one abstract method. They can have multiple default or static methods but must have only one abstract method. These interfaces are the foundation for lambda expressions and method references in Java.

Here are a few main functional interfaces in Java, along with a brief explanation and usage examples:

### 1. `Runnable`
- **Explanation**: Represents a task that can be executed by a thread.
- **Abstract Method**: `void run()`
- **Usage**:
  ```java
  Runnable runnable = () -> System.out.println("Runnable executed!");
  new Thread(runnable).start();
  ```

### 2. `Supplier<T>`
- **Explanation**: Represents a supplier of results, providing an output but no input.
- **Abstract Method**: `T get()`
- **Usage**:
  ```java
  Supplier<String> supplier = () -> "Hello, World!";
  System.out.println(supplier.get());
  ```

### 3. `Consumer<T>`
- **Explanation**: Represents an operation that accepts a single input argument and returns no result.
- **Abstract Method**: `void accept(T t)`
- **Usage**:
  ```java
  Consumer<String> consumer = message -> System.out.println(message);
  consumer.accept("Hello, Consumer!");
  ```

### 4. `Function<T, R>`
- **Explanation**: Represents a function that accepts one argument and produces a result.
- **Abstract Method**: `R apply(T t)`
- **Usage**:
  ```java
  Function<Integer, String> function = number -> "Number: " + number;
  System.out.println(function.apply(5));
  ```

### 5. `Predicate<T>`
- **Explanation**: Represents a predicate (boolean-valued function) of one argument.
- **Abstract Method**: `boolean test(T t)`
- **Usage**:
  ```java
  Predicate<Integer> isPositive = number -> number > 0;
  System.out.println(isPositive.test(10)); // true
  ```

### 6. `BiFunction<T, U, R>`
- **Explanation**: Represents a function that accepts two arguments and produces a result.
- **Abstract Method**: `R apply(T t, U u)`
- **Usage**:
  ```java
  BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
  System.out.println(add.apply(2, 3)); // 5
  ```

### 7. `BiConsumer<T, U>`
- **Explanation**: Represents an operation that accepts two input arguments and returns no result.
- **Abstract Method**: `void accept(T t, U u)`
- **Usage**:
  ```java
  BiConsumer<String, Integer> biConsumer = (s, i) -> System.out.println(s + ": " + i);
  biConsumer.accept("Age", 30);
  ```

### 8. `BiPredicate<T, U>`
- **Explanation**: Represents a predicate (boolean-valued function) of two arguments.
- **Abstract Method**: `boolean test(T t, U u)`
- **Usage**:
  ```java
  BiPredicate<Integer, Integer> isGreater = (a, b) -> a > b;
  System.out.println(isGreater.test(5, 3)); // true
  ```

These functional interfaces are part of the `java.util.function` package, which provides a comprehensive set of functional interfaces that are designed to facilitate functional programming in Java.