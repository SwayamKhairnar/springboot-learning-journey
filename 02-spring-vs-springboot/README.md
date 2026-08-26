# 02 - Spring Framework vs Spring Boot

This module highlights the architectural and configuration transition from the classic Spring Framework to modern Spring Boot.

## Sub-Modules
1. **`spring-core-xml/`**: Classic Spring Framework with manual XML bean configuration (`spring.xml`) and `ClassPathXmlApplicationContext`.
2. **`springboot-di/`**: Modern Spring Boot with annotation-driven IoC (`@Component`, `@Autowired`, `@Primary`, `@Qualifier`).

## Key Comparison
| Aspect | Classic Spring (XML) | Spring Boot (Annotations) |
|---|---|---|
| Configuration | Verbose XML files (`beans.xml`) | Auto-configuration & Java annotations |
| Dependency Injection | `<property>` or `<constructor-arg>` | `@Autowired`, `@Qualifier`, Constructor Injection |
| Server Setup | Requires external Tomcat/Jetty | Embedded Tomcat server included out-of-the-box |
| Dependency Management | Manual dependency & version coordination | Curated Starters (`spring-boot-starter-*`) |
