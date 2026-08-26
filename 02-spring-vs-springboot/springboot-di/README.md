# Spring Boot Dependency Injection Demo

This sub-module demonstrates annotation-driven Dependency Injection (DI) and Inversion of Control (IoC) in Spring Boot.

## Concepts Demonstrated
- **`@Component`**: Registers a Java class as a Spring-managed Bean.
- **`@Autowired`**: Instructs Spring to resolve and inject the required collaborator.
- **Constructor Injection**: Recommended pattern ensuring immutability and testability.
- **`@Primary` vs `@Qualifier`**: Resolving bean ambiguity when multiple implementations of an interface (`Laptop` and `Desktop`) exist.

## How to Run
```bash
./mvnw spring-boot:run
```
Or run tests:
```bash
./mvnw test
```
