# Inventory Management System

A Java-based Inventory Management System built with Spring Boot. This application provides a RESTful API and a web interface to efficiently manage product inventory, track stock levels, and handle user authentication.

---

## Tech Stack

-   **Backend**: Java 17, Spring Boot
-   **Database**: PostgreSQL
-   **Security**: Spring Security (HTTP Basic & Form-Based Login)
-   **Frontend**: Thymeleaf
-   **ORM**: Spring Data JPA / Hibernate
-   **Build Tool**: Maven

---

## How to Run Locally

1.  **Prerequisites**:
    -   JDK 17 or newer
    -   Maven
    -   A running PostgreSQL instance

2.  **Clone the repository**:
    ```bash
    git clone [https://github.com/Kaitzz/inventory_management_system.git](https://github.com/Kaitzz/inventory_management_system.git)
    ```

3.  **Configure the database**:
    -   Open `src/main/resources/application.properties`.
    -   Update the `spring.datasource.url`, `spring.datasource.username`, and `spring.datasource.password` properties to point to your PostgreSQL database.

4.  **Run the application**:
    -   You can run the `InventoryManagementSystemApplication.java` class from your IDE or use the Maven command:
    ```bash
    mvn spring-boot:run
    ```
    The application will be accessible at `http://localhost:8080`.

---

## API Endpoints

The application exposes the following RESTful API endpoints under the base path `/api`.

| Method | Endpoint              | Description                      | Authentication |
| :----- | :-------------------- | :------------------------------- | :------------- |
| `GET`  | `/products`           | Retrieves a list of all products | Public         |
| `GET`  | `/products/{id}`      | Retrieves a single product by ID | Public         |
| `POST` | `/products`           | Creates a new product            | Required       |
| `PUT`  | `/products/{id}`      | Updates an existing product      | Required       |
| `DELETE`| `/products/{id}`      | Deletes a product                | Required       |

**Default Login Credentials**:
-   **Username**: `user`
-   **Password**: `password`