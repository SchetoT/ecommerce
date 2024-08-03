E-commerce CRUD Application
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
Crear Factura: POST /api/v1/invoices
