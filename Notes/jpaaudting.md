Template Method Design Pattern:



### Design Pattern Used

The approach of using **JPA Auditing** for tracking changes follows the **Template Method Design Pattern**. This pattern defines the skeleton of an algorithm in a base class and allows subclasses or configurations to define certain steps of the algorithm. In this case:

- The `AuditingEntityListener` provides a "template" for setting audit fields.
- Subclasses like your entities (e.g., `Offer`) provide the context for which the auditing logic is applied.

---

### Internal Workings of JPA Auditing

JPA Auditing uses a combination of **lifecycle callbacks**, **reflection**, and **Spring AOP** to populate the audit fields.

1. **Entity Listeners**:
   - The `@EntityListeners(AuditingEntityListener.class)` annotation tells JPA to invoke specific methods during entity lifecycle events (`@PrePersist` and `@PreUpdate`).
   - The `AuditingEntityListener` is part of Spring Data JPA, which hooks into these events to populate fields like `createdDate`, `lastModifiedDate`, `createdBy`, and `lastModifiedBy`.

2. **Event Interception**:
   - When an entity is about to be persisted (saved for the first time), JPA triggers the `@PrePersist` method.
   - Similarly, for updates, it triggers the `@PreUpdate` method.

3. **Reflection**:
   - The `AuditingEntityListener` inspects the entity class at runtime using reflection to determine if fields like `@CreatedDate` or `@LastModifiedDate` are present.
   - If found, it assigns the current timestamp or user to these fields.

4. **AuditorAware Integration**:
   - The `AuditorAware` interface provides the logic for retrieving the current user (or "auditor").
   - For fields annotated with `@CreatedBy` or `@LastModifiedBy`, the framework invokes the `getCurrentAuditor()` method and assigns the returned value.

5. **Spring AOP and Proxying**:
   - Spring integrates JPA Auditing seamlessly by using AOP (Aspect-Oriented Programming) to register the `AuditingEntityListener` automatically when `@EnableJpaAuditing` is used.
   - It ensures that the `AuditorAware` and date/time provider are invoked when entities are persisted or updated.

---

### Key Benefits of This Approach

- **Separation of Concerns**: The auditing logic is centralized and abstracted away from individual entities.
- **Reusability**: The same auditing logic can be applied across multiple entities without duplication.
- **Consistency**: Since the auditing logic is managed centrally, it ensures consistent behavior across all entities.

---

### Analogy for Better Understanding

Think of JPA Auditing like a "smart receptionist" in an office:

- When someone (an entity) comes to the office (database), the receptionist automatically notes their **arrival time** (`createdDate`), **departure time** (`lastModifiedDate`), and who they were sent by (`createdBy`).
- This is done without you explicitly telling the receptionist to log these details—they do it automatically every time someone interacts with the office.