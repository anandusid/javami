Sure, let’s illustrate examples that demonstrate the use of the first-level cache and the second-level cache separately.

### Example: First-Level Cache

In this example, we'll show how the first-level cache works within a single transactional context.

#### Scenario:
- An API call retrieves an employee by ID twice within the same transaction.

#### Code:
```java
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.findEmployeeById(id);
    }
}

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public Employee findEmployeeById(Long id) {
        // First query within the same transaction
        Employee employee1 = employeeRepository.findById(id).orElse(null);
        System.out.println("First query: " + employee1);

        // Second query within the same transaction
        Employee employee2 = employeeRepository.findById(id).orElse(null);
        System.out.println("Second query: " + employee2);

        // Check if both entities are the same instance
        boolean areSameInstance = (employee1 == employee2);
        System.out.println("Are both instances same: " + areSameInstance);

        return employee1;
    }
}

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
```

#### Explanation:
- When `findEmployeeById` is called, it queries the database to retrieve the employee by ID.
- The first query fetches the employee and stores it in the first-level cache.
- The second query retrieves the employee from the first-level cache, avoiding a database hit.
- The `areSameInstance` check confirms that both queries return the same instance, showing the first-level cache's effectiveness within the same transaction.

### Example: Second-Level Cache

In this example, we'll show how the second-level cache works across multiple transactions.

#### Configuration:
Add the following to your `application.properties`:

```properties
# Enable second-level cache
spring.jpa.properties.hibernate.cache.use_second_level_cache=true
spring.jpa.properties.hibernate.cache.region.factory_class=org.hibernate.cache.ehcache.EhCacheRegionFactory
```

#### Code:
```java
import javax.persistence.Cacheable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Employee {
    @Id
    private Long id;
    private String name;
    private int age;

    // Getters and setters
}

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.findEmployeeById(id);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }
}

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Transactional
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
```

#### Scenario:
1. The first API call (`GET /employees/{id}`) retrieves an employee and stores it in the second-level cache.
2. The second API call (`PUT /employees`) updates the employee.
3. The third API call (`GET /employees/{id}`) retrieves the employee again, benefiting from the second-level cache.

#### Explanation:
1. **First API Call (`GET /employees/{id}`)**:
   - Checks the first-level cache (empty for this session).
   - Checks the second-level cache (also empty initially).
   - Queries the database, retrieves the employee, and stores it in both the first-level and second-level caches.

2. **Second API Call (`PUT /employees`)**:
   - Updates the employee entity.
   - Updates the second-level cache with the new state of the employee.

3. **Third API Call (`GET /employees/{id}`)**:
   - Checks the first-level cache (empty for this new session).
   - Retrieves the updated employee from the second-level cache, avoiding a database query.

### Summary

- **First-Level Cache**: Demonstrated within a single transaction where multiple queries for the same entity avoid redundant database hits by using the session cache.
- **Second-Level Cache**: Demonstrated across multiple transactions where an updated entity can be retrieved from the cache, reducing database load and improving performance.