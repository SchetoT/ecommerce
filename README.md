# E-commerce CRUD Application

## Description

This project is a CRUD (Create, Read, Update, Delete) application for an e-commerce system, developed with **Spring Boot** and **MySQL**. The application provides an interface for managing products, clients, shopping carts, and invoices. It uses **Spring Data JPA** for database persistence and **Spring Web** for creating RESTful services.

## Features

- **Product Management**: Create, retrieve, update, and delete products.
- **Client Management**: Register, retrieve, update, and delete clients.
- **Cart Management**: Add products to a cart, retrieve carts by client, and remove products from the cart.
- **Invoice Management**: Create invoices for clients and retrieve invoices by client.

## Technologies Used

- **Spring Boot**: Main framework for application development.
- **Spring Data JPA**: For data persistence management.
- **MySQL**: Relational database for storing information.
- **Lombok**: Simplifies code with automatic getters, setters, etc.
- **Springdoc OpenAPI**: For automatic Swagger/OpenAPI documentation generation.

## Configuration

1. **Database**: Configured for MySQL. Adjust credentials in `application.properties`.
2. **Dependencies**: Managed via Maven. Includes Spring Boot, Spring Data JPA, MySQL, and Lombok.
3. **API Documentation**: Access Swagger documentation at `http://localhost:8080/swagger-ui.html` when the application is running.

## API Endpoints

- **Products**: `/api/v1/products`
- **Clients**: `/api/v1/clients`
- **Carts**: `/api/v1/carts`
- **Invoices**: `/api/v1/invoices`

## Example Usage

- **Add Product to Cart**: `POST /api/v1/carts/{clientId}/{productId}/{quantity}`
- **Remove Product from Cart**: `DELETE /api/v1/carts/{cartId}?clientId={clientId}`
- **Create Invoice**: `POST /api/v1/invoices`

## Installation and Running

1. Clone the repository: `git clone https://github.com/your_username/your_repository.git`
2. Navigate to the project directory.
3. Run `mvn spring-boot:run` to start the application.

## Contributing

Contributions are welcome. Please submit a pull request or open an issue to discuss improvements.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.
