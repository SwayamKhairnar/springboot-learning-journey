# E-Commerce Backend (Spring Boot 3 REST API)

A full-featured RESTful backend API for an e-commerce platform built with Spring Boot, Spring Data JPA, and H2 Database.

## Features
- **Product Management**: Full CRUD operations for products (name, description, brand, category, price, stock, release date).
- **Multipart File Upload**: Upload, store, and stream binary product images directly via database `@Lob BLOB` storage.
- **Search & Filtering**: Custom JPQL multi-field search querying across product name, description, brand, and category.
- **Cross-Origin Resource Sharing (CORS)**: Enabled for seamless integration with the React frontend.

## REST API Specification
| Method | Endpoint | Consumes / Parameters | Description |
|---|---|---|---|
| `GET` | `/api/products` | None | Fetch all products |
| `GET` | `/api/product/{id}` | `id` (path) | Fetch single product by ID |
| `GET` | `/api/product/{id}/image` | `id` (path) | Fetch binary product image |
| `GET` | `/api/products/search` | `?name=...` or `?keyword=...` | Search products across fields |
| `POST` | `/api/product` | `multipart/form-data` (`product` JSON + `imageFile`) | Create product with image |
| `PUT` | `/api/product/{id}` | `multipart/form-data` (`product` JSON + optional `imageFile`) | Update product & image |
| `DELETE` | `/api/product/{id}` | `id` (path) | Delete product |

## How to Run
```bash
./mvnw spring-boot:run
```
API will start on `http://localhost:8080`.  
H2 Console available at `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:ecommerce_db`).
