# Bank Statement Analyser

###Chapter 1:

- “Keep It Short and Simple” (KISS)

- “Don’t Repeat Yourself” (DRY)

- The Single Responsibility Principle (SRP)

- God classes and code duplication lead to code that is hard to reason about and maintain.

- The Single Responsibility Principle helps you write code that is easier to manage and maintain.

- Cohesion is concerned with how how strongly related the responsibilities of a class or method are.

- Coupling is concerned with how dependent a class is on other parts of your code.

- High cohesion and low coupling are characteristics of maintainable code.

- A suite of automated tests increases confidence that your software is correct, makes it more robust for changes and helps program comprehension.

- jUnit is a Java testing framework which lets you specify unit tests that verifies the behaviour of your methods and classes.

- Given-When-Then is a pattern for setting up a test into three parts to help understanding of the tests you implement.

###Chapter 2:

- The Open Closed principle promotes the idea of being able to change the behaviour of a method or class without having to modify the code

- The Open Closed principle reduces fragility of code by not changing existing code, promotes re-usability of existing code and promotes decoupling which leads to better code maintenance

- God interfaces with many specific methods introduce complexity and coupling

- Too granular interface with single methods can introduce the opposite of cohesion

- You should not be worried of adding descriptive method names to help readability and comprehension of your API

- Returning void as a result of an operation makes it difficult to test its behaviour

- Exceptions in Java contribute to documentation, type safety and separation of concern

- Use checked exceptions sparingly rather than the default as it can cause significant clutter

- Overly specific exceptions can make software development unproductive

- The Notification Pattern introduces a domain class to collect errors

- Do not ignore an exception or catch the generic Exception as you will lose the benefits of diagnosis the root of the problem

- A build tool automates the repeative tasks in the software development lifecycle including building, testing and deploying your application

- Maven and Gradle are two popular build tools used in the Java community

Reference:
Real-World Software Development by Richard Warburton, Raoul-Gabriel Urma
https://learning.oreilly.com/library/view/real-world-software-development/9781491967164/
