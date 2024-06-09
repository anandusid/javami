In JPA (Java Persistence API), the default fetch type for each type of relationship is defined to optimize performance and handle common use cases. Understanding these defaults helps you manage how entity relationships are loaded from the database.

Here's a summary of the default fetch types for each relationship annotation:

1. **@OneToOne**
   - **Default Fetch Type**: `EAGER`
   - **Explanation**: By default, JPA fetches the related entity immediately along with the source entity. This means that when you load the source entity, the related entity is also loaded right away.

2. **@OneToMany**
   - **Default Fetch Type**: `LAZY`
   - **Explanation**: By default, JPA does not load the related entities when loading the source entity. Instead, it loads them on-demand when the relationship is accessed for the first time. This helps to avoid loading potentially large collections of entities unnecessarily.

3. **@ManyToOne**
   - **Default Fetch Type**: `EAGER`
   - **Explanation**: By default, JPA fetches the related entity immediately along with the source entity. This is because many-to-one relationships usually refer to single, relatively small objects that are often needed immediately.

4. **@ManyToMany**
   - **Default Fetch Type**: `LAZY`
   - **Explanation**: By default, JPA does not load the related entities when loading the source entity. This helps to avoid loading potentially large collections of entities unnecessarily, similar to the `@OneToMany` relationship.

### Examples

Here are examples of how you might define these relationships in an entity class:

1. **@OneToOne**

```java
@Entity
public class User {
    @Id
    private Long id;

    @OneToOne(fetch = FetchType.EAGER) // Explicitly setting the default fetch type
    private Profile profile;
    // other fields and methods
}

@Entity
public class Profile {
    @Id
    private Long id;

    @OneToOne(mappedBy = "profile")
    private User user;
    // other fields and methods
}
```

2. **@OneToMany**

```java
@Entity
public class Order {
    @Id
    private Long id;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY) // Explicitly setting the default fetch type
    private List<Item> items;
    // other fields and methods
}

@Entity
public class Item {
    @Id
    private Long id;

    @ManyToOne
    private Order order;
    // other fields and methods
}
```

3. **@ManyToOne**

```java
@Entity
public class Item {
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER) // Explicitly setting the default fetch type
    private Category category;
    // other fields and methods
}

@Entity
public class Category {
    @Id
    private Long id;

    @OneToMany(mappedBy = "category")
    private List<Item> items;
    // other fields and methods
}
```

4. **@ManyToMany**

```java
@Entity
public class Student {
    @Id
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY) // Explicitly setting the default fetch type
    private List<Course> courses;
    // other fields and methods
}

@Entity
public class Course {
    @Id
    private Long id;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
    // other fields and methods
}
```

### Changing Fetch Types

You can override the default fetch types by explicitly setting the `fetch` attribute in the annotation. For example, if you want to fetch a `@OneToMany` relationship eagerly, you can do so as follows:

```java
@OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
private List<Item> items;
```

By understanding and using these default fetch types appropriately, you can better manage performance and loading behavior in your JPA entities.