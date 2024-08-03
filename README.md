**E-commerce CRUD Application
Descripción
Este proyecto es una aplicación CRUD (Crear, Leer, Actualizar, Eliminar) para un sistema de comercio electrónico, desarrollada con Spring Boot y MySQL. La aplicación proporciona una interfaz para gestionar productos, clientes, carritos de compra y facturas. Utiliza Spring Data JPA para la persistencia en base de datos y Spring Web para la creación de servicios RESTful.

Características
Gestión de Productos: Crear, obtener, actualizar y eliminar productos.
Gestión de Clientes: Registrar, obtener, actualizar y eliminar clientes.
Gestión de Carritos de Compra: Añadir productos a un carrito, obtener carritos por cliente y eliminar productos del carrito.
Gestión de Facturas: Crear facturas para clientes y obtener facturas por cliente.
Tecnologías Utilizadas
Spring Boot: Framework principal para el desarrollo de la aplicación.
Spring Data JPA: Para la gestión de la persistencia de datos.
MySQL: Base de datos relacional para almacenar la información.
Lombok: Para simplificar el código con anotaciones de generación automática de getters, setters, etc.
Springdoc OpenAPI: Para la generación automática de documentación Swagger/OpenAPI.
Configuración
Base de Datos: Configurada para MySQL. Asegúrate de ajustar las credenciales en el archivo application.properties.

Dependencias: Utiliza Maven para gestionar las dependencias. Incluye dependencias para Spring Boot, Spring Data JPA, MySQL y Lombok.

Documentación de API: Accede a la documentación Swagger a través de http://localhost:8080/swagger-ui.html cuando la aplicación esté en funcionamiento.

Endpoints de API
Productos: /api/v1/products
Clientes: /api/v1/clients
Carritos: /api/v1/carts
Facturas: /api/v1/invoices
Ejemplo de Uso
Añadir Producto al Carrito: POST /api/v1/carts/{clientId}/{productId}/{quantity}
Eliminar Producto del Carrito: DELETE /api/v1/carts/{cartId}?clientId={clientId}
Crear Factura: POST /api/v1/invoices**# E-commerce CRUD Application

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
