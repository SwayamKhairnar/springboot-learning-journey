# 01 - Spring Boot Basics

This module demonstrates the absolute fundamentals of a Spring Boot application.

## Key Concepts
- **`@SpringBootApplication`**: Combines `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`.
- **`@RestController`**: Marks a class where every method returns a domain object / string directly written to the HTTP response body (combines `@Controller` and `@ResponseBody`).
- **Embedded Server**: Running the application bootstraps an embedded Apache Tomcat web server on port `8080` with zero external servlet container setup.

## Endpoints
- `GET /` &mdash; Returns a welcoming greeting message.

## How to Run
```bash
./mvnw spring-boot:run
```
