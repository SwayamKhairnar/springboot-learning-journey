# 04 - CRUD API with Spring Data JPA & H2 Database

This module demonstrates building a production-style RESTful CRUD API leveraging **Spring Data JPA** and an embedded **H2 in-memory database**.

## Key Concepts Demonstrated
- **Spring Data JPA**: Repository abstraction eliminating boilerplate JDBC and SQL DAO code.
- **`JpaRepository<T, ID>`**: Out-of-the-box support for pagination, sorting, and standard CRUD operations (`save`, `findById`, `findAll`, `deleteById`).
- **JPA Annotations**: `@Entity`, `@Id`, `@GeneratedValue(strategy = GenerationType.IDENTITY)`.
- **H2 In-Memory DB**: Fast, zero-install relational database ideal for development and testing.
- **RESTful Status Codes**: `200 OK`, `201 CREATED`, `204 NO CONTENT`, `404 NOT FOUND`.

## API Endpoints
| HTTP Method | Endpoint | Description | Status Code |
|---|---|---|---|
| `GET` | `/api/products` | Retrieve all products | `200 OK` |
| `GET` | `/api/products/{id}` | Retrieve product by ID | `200 OK` / `404 NOT FOUND` |
| `POST` | `/api/products` | Create a new product | `201 CREATED` |
| `PUT` | `/api/products/{id}` | Update an existing product | `200 OK` / `404 NOT FOUND` |
| `DELETE` | `/api/products/{id}` | Delete a product by ID | `204 NO CONTENT` / `404 NOT FOUND` |

## H2 Console Access
- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:productdb`
- Username: `sa`
- Password: *(empty)*

## How to Run
```bash
./mvnw spring-boot:run
```
Or run tests:
```bash
./mvnw test
```
