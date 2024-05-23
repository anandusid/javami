Object-Oriented Programming (OOP) is a programming paradigm based on the concept of "objects," which can contain data and code that manipulates that data. Java is a widely used OOP language, and understanding its core concepts is essential for effective programming. Here are the primary OOP concepts in Java, along with explanations, when to use them, and their benefits:

1. Encapsulation
Explanation:
Encapsulation is the mechanism of wrapping the data (variables) and the code (methods) that manipulates the data into a single unit, known as a class. It restricts direct access to some of an object's components, which can prevent the accidental modification of data.

When to Use:

To hide the internal state and require all interactions to be performed through an object's methods.
To protect an object's state from unauthorized access and modification.
Benefits:

Improves Code Maintainability: By bundling the data and methods that operate on the data together.
Enhances Security: By restricting access to certain parts of an object.
Reduces Complexity: By providing a clear interface for interacting with an object.
Example:

java
Copy code
public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}
