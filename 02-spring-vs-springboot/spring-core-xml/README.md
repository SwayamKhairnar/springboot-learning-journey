# Spring Core XML Configuration Demo

This sub-module demonstrates how the classic Spring Framework handled Inversion of Control (IoC) and Dependency Injection (DI) before Spring Boot.

## Concepts Demonstrated
- **`ApplicationContext`**: `ClassPathXmlApplicationContext` parsing `spring.xml`.
- **XML Bean Definition**: `<bean id="..." class="..." />`.
- **Setter Injection**: `<property name="comp" ref="laptop" />`.
- **Decoupling with Interfaces**: `Dev` depends on the `Computer` interface, with either `Laptop` or `Desktop` injected via XML.

## How to Run
```bash
mvn clean compile exec:java -Dexec.mainClass="com.swayam.springxml.App"
```
Or run tests:
```bash
mvn clean test
```
