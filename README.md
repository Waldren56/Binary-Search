# Advanced Binary Search Architecture in Java

An engineering-grade implementation of the **Binary Search** algorithm in Java, re-engineered according to **Clean Code** principles, **Separation of Concerns (SoC)**, and defensive programming.

---

## 🏗️ Architecture & Design Patterns

The project is structured by moving away from a monolithic procedural approach, cleanly separating the business logic from the user interface:

### 1. Logic Module (`Algorithms.java`)
- **Utility Class Pattern:** The class is marked as `final` and features a private constructor that throws an `AssertionError`. This prevents illegitimate instantiation of the class, ensuring it acts solely as a container for pure functions.
- **Immutability (`final` local variables):** All parameters and variables that do not require reassignment are declared `final` to prevent side effects and optimize performance at the compiler level.
- **Anti-Overflow Algorithm:** Implements a memory-safe midpoint calculation formula:
  $$\text{mid} = \text{left} + \frac{\text{right} - \text{left}}{2}$$
  This avoids the classic integer overflow inherent in the standard $(L+R)/2$ formula when dealing with massive datasets.

### 2. Interface Module (`Main.java`)
- **Separation of Concerns (SoC):** `Main` handles exclusively I/O (Input/Output) and visual formatting via ANSI codes. It has no knowledge of the mathematical mechanics of binary search, consuming only its output.
- **Resource Management (`try-with-resources`):** The `java.util.Scanner` instance is managed via the *try-with-resources* statement, guaranteeing automatic stream closure and preventing potential system resource memory leaks.
- **DRY Principle (Don't Repeat Yourself):** Input validation loops are abstracted into private, parametric helper methods (`promptForPositiveInt`, `promptForBoundedInt`), making the codebase highly reusable and maintainable.

---

## 🛠️ Technologies & Requirements

- **Language:** Java 8 or higher (JDK 11+ recommended)
- **Paradigm:** Object-Oriented / Functional Utility
- **Dependencies:** None (Standard Java SDK)

---

## 🚀 Compilation & Execution

The project adopts the standard structure for coupled source files. To compile and run via CLI (Command Line Interface):

1. **Clone the repository or download the source files into the same directory.**
2. **Compile the modules:**
   ```bash
   javac Algorithms.java Main.java
