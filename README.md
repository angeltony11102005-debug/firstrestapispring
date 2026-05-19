# First REST API Spring Boot Project

**Student:** Anson Tony  
**University:** Vistula University, Warsaw  
**Course:** Java & Spring Boot

---

## Project Overview

A full CRUD REST API built with Spring Boot, Spring Data JPA, H2 in-memory database, and documented with Swagger UI (OpenAPI 3.0).

---

## Tech Stack

| Technology | Version |
|---|---|
| Java | 17 |
| Spring Boot | 3.3.0 |
| Spring Data JPA | (managed by Boot) |
| H2 Database | (managed by Boot) |
| Springdoc OpenAPI (Swagger) | 2.3.0 |
| Maven | 3.x |

---

## Project Structure

```
src/main/java/pl/edu/vistula/firstrestapispring/
├── FirstrestapispringApplication.java
├── OpenApiConfig.java
├── product/
│   ├── api/
│   │   ├── request/
│   │   │   ├── ProductRequest.java
│   │   │   └── UpdateProductRequest.java
│   │   └── response/
│   │       └── ProductResponse.java
│   ├── domain/
│   │   └── Product.java
│   ├── repository/
│   │   └── ProductRepository.java
│   ├── service/
│   │   └── ProductService.java
│   └── support/
│       ├── ProductMapper.java
│       ├── ProductExceptionSupplier.java
│       ├── ProductExceptionAdvisor.java
│       └── exception/
│           └── ProductNotFoundException.java
└── shared/
    └── api/
        └── response/
            └── ErrorMessageResponse.java
```

---

## API Endpoints

Base URL: `http://localhost:8080/api/v1/products`

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/api/v1/products` | Create a new product |
| `GET` | `/api/v1/products` | Get all products |
| `GET` | `/api/v1/products/{id}` | Get product by ID |
| `PUT` | `/api/v1/products/{id}` | Update product by ID |
| `DELETE` | `/api/v1/products/{id}` | Delete product by ID |

---

## Request & Response Examples

### Create Product (POST)
**Request body:**
```json
{
  "name": "Laptop"
}
```
**Response (201 Created):**
```json
{
  "id": 1,
  "name": "Laptop"
}
```

### Update Product (PUT)
**Request body:**
```json
{
  "name": "Updated Laptop"
}
```

### Error Response (404 Not Found)
```json
{
  "message": "Product with id 99 not found"
}
```

---

## How to Run

### Prerequisites
- Java 17+
- Maven 3.x
- IntelliJ IDEA (recommended)

### Steps

1. Clone the repository:
```bash
git clone https://github.com/<your-username>/firstrestApispring.git
cd firstrestApispring
```

2. Run the application:
```bash
./mvnw spring-boot:run
```

Or open in IntelliJ IDEA and click the **Run** button.

---

## Access the Application

| URL | Description |
|---|---|
| `http://localhost:8080/swagger-ui/index.html` | Swagger UI — interactive API docs |
| `http://localhost:8080/v3/api-docs` | OpenAPI JSON definition |
| `http://localhost:8080/h2-console` | H2 Database Console |

### H2 Console Login
- **JDBC URL:** `jdbc:h2:mem:testdb`
- **User Name:** `sa`
- **Password:** *(leave empty)*

---

## Sample Data

To insert sample products, run these SQL statements in the H2 console:

```sql
INSERT INTO PRODUCTS (ID, NAME) VALUES (1, 'Laptop');
INSERT INTO PRODUCTS (ID, NAME) VALUES (2, 'Mobile');
INSERT INTO PRODUCTS (ID, NAME) VALUES (3, 'Tablet');
```

Verify with:
```sql
SELECT * FROM PRODUCTS;
```

---

## Screenshots

### Swagger UI
![Swagger UI](screenshots/swagger-ui.png)

### H2 Console
![H2 Console](screenshots/h2-console.png)

### Application Running
![App Running](screenshots/app-running.png)

---

## Configuration

`src/main/resources/application.properties`:

```properties
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
springdoc.api-docs.path=/v3/api-docs
springdoc.swagger-ui.path=/swagger-ui/index.html
```