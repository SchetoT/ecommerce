package com.ecommercescheto.crud.controllers;

import com.ecommercescheto.crud.entities.Product;
import com.ecommercescheto.crud.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@Tag(name = "Product controller", description = "Here you can add a new product, see all products, edit a product or delete a product.")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/registerproduct")
    @Operation(summary = "Register a new product", description = "You need to enter the data to create a new product, in this case title, description, stock and price will be used")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request. Invalid product data"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping
    @Operation(summary = "Get all products", description = "This endpoint will return all products stored in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Products retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{pid}")
    @Operation(summary = "Get a product by ID", description = "This endpoint will return a specific product by its ID")
    public Optional<Product> getProductById(@PathVariable Long pid) {
        return productService.getProductById(pid);
    }

    @PutMapping("/{productId}/{productTitle}/{productDescription}/{productStock}/{productPrice}")
    @Operation(summary = "Update a product", description = "You need to provide the ID of the product and the updated data, in this case title, description, stock and price will be used")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Product not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public Product updateProduct(@PathVariable Long productId, @PathVariable String productTitle, @PathVariable String productDescription, @PathVariable Integer productStock, @PathVariable Double productPrice) {
        return productService.updateProduct(productId, productTitle, productDescription,productStock,productPrice);
    }
    // @PutMapping("/{pid}")
    //    @Operation(summary = "Update a product", description = "You need to provide the ID of the product and the updated data, in this case title, description, stock and price will be used")
    //    public Product updateProduct(@PathVariable Long pid, @RequestBody Product product) {
    //        product.setId(pid);
    //        return productService.updateProduct(product);
    //    }
    // If you do not want the path variable form and they are not required, uncomment this method and comment on the previous one
    //    @PostMapping("/{clid}/{pid}/{q}")
    //    @Operation(summary = "ADD product to cart", description = "You will need to enter the ID of the client, the product and the quantity.")
    //    public Cart addProductToCart(@PathVariable Long clid, @PathVariable Long pid, @PathVariable Double q) {
    //        return cartService.addProductToCart(clid, pid, q);
    //    }

    @DeleteMapping("/{pid}")
    @Operation(summary = "Delete a product", description = "You need to provide the ID of the product you want to delete")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Product deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Product not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public void deleteProduct(@PathVariable Long pid) {
        productService.deleteProduct(pid);
    }
}
